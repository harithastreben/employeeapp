CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    date_of_birth VARCHAR(255) NOT NULL,
    address VARCHAR(255),
    department VARCHAR(255) NOT NULL,
    is_deleted BOOLEAN DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS asset (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    collected_date VARCHAR(255) NOT NULL,
    return_date VARCHAR(255),
    is_deleted BOOLEAN DEFAULT FALSE,
    approval BOOLEAN,
    user_id INTEGER REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS attendance (
    id SERIAL PRIMARY KEY,
    date VARCHAR(255) NOT NULL,
    login_time VARCHAR(255) NOT NULL,
    logout_time VARCHAR(255),
    is_deleted BOOLEAN DEFAULT FALSE,
    is_present BOOLEAN,
    user_id INTEGER REFERENCES users(id)
);

