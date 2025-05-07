-- ========================================================
-- USERS TABLE: Stores user profile and embedded address
-- ========================================================
CREATE TABLE users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    full_name VARCHAR(255) NOT NULL,
    phone_no VARCHAR(20) UNIQUE NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    role VARCHAR(50) NOT NULL,
    created_by VARCHAR(100),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    line1 VARCHAR(255),
    line2 VARCHAR(255),
    city VARCHAR(100),
    state VARCHAR(100),
    country VARCHAR(100),
    postal_code VARCHAR(20)
);

-- ========================================================
-- CARS TABLE: Car inventory associated with an owner
-- ========================================================
CREATE TABLE cars (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    make VARCHAR(100),
    model VARCHAR(100),
    year INT,
    price_per_day DECIMAL(10, 2), 
    status VARCHAR(50), 
    owner_id BIGINT NOT NULL,
    created_by VARCHAR(100),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_car_owner FOREIGN KEY (owner_id) REFERENCES users(id)
);

-- ========================================================
-- LEASES TABLE: Booking/Lease transactions of cars
-- ========================================================
CREATE TABLE leases (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    status VARCHAR(50),
    car_id BIGINT NOT NULL,
    customer_id BIGINT NOT NULL,
    CONSTRAINT fk_lease_car FOREIGN KEY (car_id) REFERENCES cars(id),
    CONSTRAINT fk_lease_customer FOREIGN KEY (customer_id) REFERENCES users(id)
);
