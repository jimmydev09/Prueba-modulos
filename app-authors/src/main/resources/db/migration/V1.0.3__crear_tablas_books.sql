CREATE TABLE books
(
    isbn    VARCHAR(255) NOT NULL,
    title   VARCHAR(128),
    price   DECIMAL(12, 2),
    version INTEGER,
    CONSTRAINT pk_books PRIMARY KEY (isbn)
);

CREATE TABLE inventory
(
    isbn     VARCHAR(255) NOT NULL,
    sold     INTEGER,
    supplied INTEGER,
    CONSTRAINT pk_inventory PRIMARY KEY (isbn)
);

ALTER TABLE inventory
    ADD CONSTRAINT FK_INVENTORY_ON_ISBN FOREIGN KEY (isbn) REFERENCES books (isbn);

ALTER TABLE books_authors
    ADD CONSTRAINT FK_BOOKS_AUTHORS_ON_BOOKS FOREIGN KEY (books_isbn) REFERENCES books (isbn);

INSERT INTO public.books(isbn, title, price, version) VALUES
                                                          ('978-0134685991', 'Effective Java',        50.00, 1),
                                                          ('978-1492056355', 'MicroProfile Cookbook', 39.99, 1),
                                                          ('978-1617292545', 'Spring in Action',      44.95, 1);