CREATE TABLE orderItem (
    id_orderItem VARCHAR(36) NOT NULL,
    id_order VARCHAR(36) NOT NULL,
    id_product VARCHAR(36) NOT NULL,
    int_quantity INT NOT NULL,
    nr_priceProduct DECIMAL(10, 2) NOT NULL,
    nr_total DECIMAL(10, 2) NOT NULL,
    CONSTRAINT pk_orderItem PRIMARY KEY (id_orderItem)
);
