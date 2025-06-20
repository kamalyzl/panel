 CREATE TABLE IF NOT EXISTS customers (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    lastname VARCHAR(100) NOT NULL,
    dni VARCHAR(8) NOT NULL UNIQUE,
    address VARCHAR(255),
    number_phone VARCHAR(20),
    email VARCHAR(255) UNIQUE
);


CREATE TABLE IF NOT EXISTS products (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(255),
    total_quantity INTEGER NOT NULL,
    available_quantity INTEGER NOT NULL,
    category VARCHAR(100) NOT NULL,
    price NUMERIC(10, 2) NOT NULL
);

CREATE TABLE IF NOT EXISTS invoices (
    id SERIAL PRIMARY KEY,
    invoice_date DATE NOT NULL,
    total_amount NUMERIC(10, 2) NOT NULL,
    customer_id BIGINT NOT NULL,
    CONSTRAINT fk_invoice_customer
        FOREIGN KEY (customer_id) REFERENCES customers(id)
        ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS invoice_products (
    id SERIAL PRIMARY KEY,
    quantity INTEGER NOT NULL,
    price NUMERIC(10, 2) NOT NULL,
    invoice_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    CONSTRAINT fk_detail_invoice
        FOREIGN KEY (invoice_id) REFERENCES invoices(id)
        ON DELETE CASCADE,
    CONSTRAINT fk_detail_product
        FOREIGN KEY (product_id) REFERENCES products(id)
        ON DELETE CASCADE
);
