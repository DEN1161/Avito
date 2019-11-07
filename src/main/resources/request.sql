CREATE TABLE houses
(
    id          INTEGER PRIMARY KEY AUTOINCREMENT,
    price       INTEGER NOT NULL CHECK ( price >= 0 ),
    rooms       INTEGER NOT NULL CHECK ( price > 0 ),
    district    TEXT NOT NULL,
    metro       TEXT NOT NULL NULL
);
INSERT INTO houses (price, rooms , district, metro) VALUES (50000000, 5, 'Marylebon', 'Baker Street');
INSERT INTO houses (price, rooms , district, metro) VALUES (8220000, 6,'Vahitovskiy', 'Sykonnaya Sloboda');
INSERT INTO houses (price, rooms , district, metro) VALUES (9200000, 3,'Kirovskiu', 'Kozya Sloboda');
INSERT INTO houses (price, rooms , district, metro) VALUES (12000000, 4, 'Novo-Savinovskiu', 'Kozya Sloboda');
INSERT INTO houses (price, rooms , district, metro) VALUES (2300000, 1, 'Privolshkiu', 'Prospekt Pobedi');