CREATE TABLE countries(
                      country_id integer primary key,
                      name varchar(30) NOT NULL,
                      capital varchar(30) NOT NULL,
                      region varchar(30)
);

INSERT INTO countries
VALUES(1,'Colombia','Bogota','Americas'),
      (2,'Indonesia','Jakarta','Asia'),
      (3,'Portugal','Lisbon','Europe'),
      (4,'Nepal','Kathmandu','Asia'),
      (5,'Morocco','Rabat','Africa'),
      (6,'Italy','Rome','Europe'),
      (7,'Switzerland','Bern','Europe');

SELECT * FROM countries;

-- VALUES(1,'Колумбия','Богота','Америка'),
--       (2,'Индонезия','Джакарта','Азия'),
--       (3,'Португалия','Лиссабон','Европа'),
--       (4,'Непал','Катманду','Азия'),
--       (5,'Марокко','Рабат','Африка'),
--       (6,'Италия','Рим','Европа'),
--       (7,'Швейцария','Берн','Европа');
