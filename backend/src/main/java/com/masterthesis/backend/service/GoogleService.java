package com.masterthesis.backend.service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;

import java.util.List;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;

import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.CalendarList;
import com.google.api.services.calendar.model.CalendarListEntry;
import com.google.api.services.calendar.model.Events;


import com.masterthesis.backend.model.CalendarDto;
import com.masterthesis.backend.model.EventDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.DateTime;


@Service
public class GoogleService {

    private static final String APPLICATION_NAME = "Masterthesis";
    private static final HttpTransport httpTransport = new NetHttpTransport();
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();

    private static final LocalDate today = LocalDate.now();
    private static final LocalDateTime startOfDay = LocalDateTime.of(today, LocalTime.MIN);
    private static final LocalDateTime endOfDay = LocalDateTime.of(today, LocalTime.MAX);

    public List<EventDto> getEvents(String tokenValue, String calendarId) {
        GoogleCredential credential = new GoogleCredential().setAccessToken(tokenValue);
        Calendar calendar =
                new Calendar.Builder(httpTransport, JSON_FACTORY, credential)
                        .setApplicationName(APPLICATION_NAME)
                        .build();
        Events events = null;
        try {
            events = calendar.events().list(calendarId)
                    .setMaxResults(50)
                    .setTimeMin(convertToDateTime(startOfDay))
                    .setTimeMax(convertToDateTime(endOfDay))
                    .setOrderBy("startTime")
                    .setSingleEvents(true)
                    .execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<EventDto> eventDtos = new ArrayList<>();
        assert events != null;
        events.getItems().forEach(e -> {
            EventDto eventDto = new EventDto();
            BeanUtils.copyProperties(e, eventDto);
            eventDto.setStartTime(e.getStart().toString());
            eventDtos.add(eventDto);
        });
        return eventDtos;
    }

    public List<CalendarDto> getCalendars(String tokenValue) throws IOException {
        GoogleCredential credential = new GoogleCredential().setAccessToken(tokenValue);
        Calendar service = new Calendar.Builder(httpTransport, JSON_FACTORY, credential)
                .setApplicationName("applicationName").build();
        CalendarList calendarList;
        List<CalendarDto> calendarDtos = new ArrayList<>();
        String pageToken = null;
        do {
            calendarList = service.calendarList().list().setPageToken(pageToken).execute();
            List<CalendarListEntry> items = calendarList.getItems();

            for (CalendarListEntry calendarListEntry : items) {
                CalendarDto calendarDto = new CalendarDto();
                BeanUtils.copyProperties(calendarListEntry, calendarDto);
                calendarDtos.add(calendarDto);
            }
            pageToken = calendarList.getNextPageToken();
        } while (pageToken != null);

        return calendarDtos;
    }

    public static DateTime convertToDateTime(LocalDateTime localDateTime) {
        long millis = localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        return new DateTime(millis);
    }

}
