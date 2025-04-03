CREATE TABLE product (
    id_prodcut VARCHAR(36) NOT NULL,
    tx_name VARCHAR(256) NOT NULL,
    tx_unit VARCHAR(256) NOT NULL,
    int_price INT NOT NULL,
    CONSTRAINT pk_account PRIMARY KEY (id_prodcut)
);
