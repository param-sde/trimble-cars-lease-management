-- ===========================================
-- USERS
-- ===========================================
INSERT INTO users (full_name, phone_no, email, role, created_by, created_at, updated_at, line1, line2, city, state, country, postal_code)
VALUES
('John Doe', '1234567890', 'john.doe@example.com', 'ADMIN', 'system', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, '123 Elm Street', NULL, 'New York', 'NY', 'USA', '10001'),
('Jane Smith', '0987654321', 'jane.smith@example.com', 'CUSTOMER', 'system', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, '456 Oak Avenue', 'Apt 5B', 'Los Angeles', 'CA', 'USA', '90001'),
('Robert Brown', '1122334455', 'robert.brown@example.com', 'OWNER', 'admin', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, '789 Pine Road', 'Suite 10', 'Chicago', 'IL', 'USA', '60007'),
('Alice Johnson', '2233445566', 'alice.johnson@example.com', 'CUSTOMER', 'system', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, '321 Maple Street', NULL, 'San Francisco', 'CA', 'USA', '94105'),
('Michael Lee', '3344556677', 'michael.lee@example.com', 'OWNER', 'admin', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, '654 Birch Lane', 'Unit 3', 'Miami', 'FL', 'USA', '33101');

-- ===========================================
-- CARS
-- ===========================================
INSERT INTO cars (make, model, year, price_per_day, status, owner_id, created_by, created_at, updated_at)
VALUES
('Toyota', 'Corolla', 2020, 35.50, 'AVAILABLE', 3, 'admin', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Honda', 'Civic', 2019, 40.00, 'BOOKED', 5, 'admin', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Ford', 'Mustang', 2022, 100.00, 'IN_SERVICE', 5, 'admin', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('BMW', 'X5', 2021, 85.00, 'AVAILABLE', 4, 'admin', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Audi', 'A4', 2023, 90.00, 'BOOKED', 3, 'admin', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- ===========================================
-- LEASES
-- ===========================================
INSERT INTO leases (start_date, end_date, status, car_id, customer_id)
VALUES
('2025-05-10', '2025-05-15', 'ACTIVE', 1, 2),
('2025-06-01', '2025-06-10', 'COMPLETED', 2, 4),
('2025-05-20', '2025-06-05', 'CANCELLED', 3, 5),
('2025-06-10', '2025-06-20', 'ACTIVE', 4, 1),
('2025-06-15', '2025-06-25', 'COMPLETED', 5, 3);