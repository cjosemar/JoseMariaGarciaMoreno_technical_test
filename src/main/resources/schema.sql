DROP TABLE IF EXISTS prices;
DROP TABLE IF EXISTS brands;
DROP TABLE IF EXISTS products;

CREATE TABLE brands
(
    id_brand   INT,
    name_brand VARCHAR2(20),
    CONSTRAINT pk_brands PRIMARY KEY (id_brand)
);

CREATE TABLE products
(
    id_product   INT,
    name_product VARCHAR2(40),
    CONSTRAINT pk_products PRIMARY KEY (id_product)
);
CREATE TABLE prices
(
    brand_id   INT,
    start_date TIMESTAMP,
    end_date   TIMESTAMP,
    price_list INT,
    product_id INT,
    priority   INT,
    price      DECIMAL(10, 2),
    curr       VARCHAR(3),
    CONSTRAINT pk_prices PRIMARY KEY (product_id, brand_id, price_list, start_date, end_date),
    CONSTRAINT fk_prices_brands FOREIGN KEY (brand_id) REFERENCES brands (id_brand),
    CONSTRAINT fk_prices_products FOREIGN KEY (product_id) REFERENCES products (id_product)
);