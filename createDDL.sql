CREATE TABLE patients (id BIGINT AUTO_INCREMENT NOT NULL, created_by VARCHAR(255), created_date DATETIME, first_name VARCHAR(255), last_name VARCHAR(255), name VARCHAR(255), updated_date DATETIME, updated_by VARCHAR(255), PRIMARY KEY (id))
CREATE TABLE patient_condition (id BIGINT AUTO_INCREMENT NOT NULL, description VARCHAR(255), PRIMARY KEY (id))
