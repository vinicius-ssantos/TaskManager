CREATE TABLE task (
                      id SERIAL PRIMARY KEY,
                      title VARCHAR(255) NOT NULL,
                      description TEXT,
                      creation_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
                      completion_date TIMESTAMP WITHOUT TIME ZONE,
                      status VARCHAR(50)
);
