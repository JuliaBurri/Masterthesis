DROP TABLE IF EXISTS task;
CREATE TABLE task
(
    id          BIGINT NOT NULL,
    title       VARCHAR(255),
    description VARCHAR(255),
    due_date    TIMESTAMP,
    prio        SMALLINT,
    CONSTRAINT pk_task PRIMARY KEY (id)
);

INSERT INTO task VALUES (1L, 'Make coffee', 'Black no milk', '2024-01-20', 0);
INSERT INTO task VALUES (2L, 'Have lunch', 'cook noodles', '2024-01-22', 0);

DROP TABLE IF EXISTS appointment;
CREATE TABLE appointment
(
    id          BIGINT NOT NULL,
    title       VARCHAR(255),
    description VARCHAR(255),
    start_date  TIMESTAMP,
    end_date    TIMESTAMP,
    CONSTRAINT pk_appointment PRIMARY KEY (id)
);

INSERT INTO appointment VALUES (1L, 'Dentist', 'Check teeth', '2024-01-22T10:00:00', '2024-01-22T11:00:00');
