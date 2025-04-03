CREATE TABLE product (
    id_prodcut VARCHAR(36) NOT NULL,
    tx_name VARCHAR(256) NOT NULL,
    tx_unit VARCHAR(256) NOT NULL,
    double_price DECIMAL(10,2) NOT NULL,
    CONSTRAINT pk_account PRIMARY KEY (id_prodcut)
);
