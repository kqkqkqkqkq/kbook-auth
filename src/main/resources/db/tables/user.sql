CREATE TABLE IF NOT EXISTS user (
    id SERIAL PRIMARY KEY,

    first_name VARCHAR(255) NULL,
    last_name VARCHAR(255) NULL,

    email VARCHAR(255) NOT NULL UNIQUE,
    phone VARCHAR(255) NULL,

    is_email_verified BOOLEAN NOT NULL DEFAULT FALSE,
    is_phone_verified BOOLEAN NOT NULL DEFAULT FALSE,

    username VARCHAR(255) NOT NULL,
    password_hash VARCHAR(255) NOT NULL,

    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    last_updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),

    date_of_birth DATE NULL
);