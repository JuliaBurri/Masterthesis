DROP TABLE IF EXISTS task;
CREATE TABLE task
(
    id          BIGINT NOT NULL,
    title       VARCHAR(255),
    description VARCHAR(255),
    due_date    TIMESTAMP,
    prio        SMALLINT,
    category    SMALLINT,
    CONSTRAINT pk_task PRIMARY KEY (id)
);

INSERT INTO task VALUES (1L, 'Make coffee', 'Black no milk', '2024-01-23', 0, 1);
INSERT INTO task VALUES (2L, 'Have lunch', 'cook noodles', '2024-01-23', 0, 0);

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
