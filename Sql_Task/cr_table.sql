CREATE TABLE company (id SERIAL PRIMARY KEY, floor INT, comp_name CHAR(100));
CREATE TABLE employees (id SERIAL PRIMARY KEY, fio CHAR(100), office INT, comp_id SERIAL REFERENCES company(id) on update cascade on delete cascade);
CREATE TABLE access (comp_id SERIAL REFERENCES company(id) on update cascade on delete cascade, floor INT);