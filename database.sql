-- Project Management System Database Initialization

-- Create database
CREATE DATABASE IF NOT EXISTS pms_db;
USE pms_db;

-- Sample data will be inserted after first run
-- The application will auto-create tables using JPA

-- After application starts, you can insert sample data:

-- Insert sample users (passwords are 'password123' encrypted with BCrypt)
-- INSERT INTO users (username, password, email, full_name, role) VALUES
-- ('superadmin', '$2a$10$xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx', 'super@pms.com', 'Super Admin', 'SUPER_ADMIN'),
-- ('admin1', '$2a$10$xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx', 'admin@pms.com', 'Admin User', 'ADMIN'),
-- ('manager1', '$2a$10$xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx', 'manager@pms.com', 'Manager User', 'MANAGER');

-- Insert sample clients
-- INSERT INTO client (name, email, phone, company, address) VALUES
-- ('John Doe', 'john@company.com', '1234567890', 'Tech Corp', '123 Main St'),
-- ('Jane Smith', 'jane@business.com', '0987654321', 'Business Inc', '456 Oak Ave');

-- Note: Use the web interface to register users and add data
-- This ensures proper password encryption and data validation
