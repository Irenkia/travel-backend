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

-- VALUES(1,'��������','������','�������'),
--       (2,'���������','��������','����'),
--       (3,'����������','��������','������'),
--       (4,'�����','��������','����'),
--       (5,'�������','�����','������'),
--       (6,'������','���','������'),
--       (7,'���������','����','������');
