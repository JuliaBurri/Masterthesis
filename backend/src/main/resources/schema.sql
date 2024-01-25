DROP TABLE IF EXISTS task;
CREATE TABLE task
(
    id          BIGINT NOT NULL,
    title       VARCHAR(255),
    description VARCHAR(255),
    duration    VARCHAR(255),
    prio        SMALLINT,
    category    SMALLINT,
    done        SMALLINT,
    CONSTRAINT pk_task PRIMARY KEY (id)
);

INSERT INTO task
VALUES (1L, 'Prepare Review Meeting', 'Make Powerpoint, Invite guests', 30, 0, 1, 0);
INSERT INTO task
VALUES (2L, 'Have lunch', 'cook noodles', 60, 1, 0, 0);
INSERT INTO task
VALUES (3L, 'Prepare Workshop', 'Topic: Scrum Basics', 120, 0, 2, 0);
INSERT INTO task
VALUES (4L, 'Setup Project', 'Create Backend with Spring Boot', 240, 0, 0, 0);
INSERT INTO task
VALUES (5L, 'Write Email to Customer', 'Ask for needed data', 30, 0, 1, 0);
INSERT INTO task
VALUES (6L, 'Implement Features in Project', 'Use Placeholder Data', 150, 0, 1, 0);


/*DROP TABLE IF EXISTS appointment;
CREATE TABLE appointment
(
    id          BIGINT NOT NULL,
    title       VARCHAR(255),
    description VARCHAR(255),
    time  TIMESTAMP,
    duration    VARCHAR(255),
    CONSTRAINT pk_appointment PRIMARY KEY (id)
);

INSERT INTO appointment VALUES (1L, 'Dentist', 'Check teeth', '2024-01-23T10:00:00', '1:30');
INSERT INTO appointment VALUES (2L, 'Meeting', 'General Update', '2024-01-23T10:00:00', '0:30');*/
