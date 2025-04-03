CREATE TABLE "order" (
    id_order VARCHAR(36) NOT NULL,
    id_account VARCHAR(36) NOT NULL,
    dt_order TIMESTAMP NOT NULL,
    double_total DECIMAL(10, 2) NOT NULL,
    CONSTRAINT pk_order PRIMARY KEY (id_order)
);

CREATE TABLE order_item (
    id_order_item SERIAL PRIMARY KEY,
    id_order VARCHAR(36) NOT NULL,
    id_product VARCHAR(36) NOT NULL,
    int_quantity INTEGER NOT NULL,
    double_price DECIMAL(10, 2) NOT NULL,
    double_total DECIMAL(10, 2) NOT NULL
);
