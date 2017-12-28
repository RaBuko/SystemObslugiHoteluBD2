CREATE USER 'administrator'@'localhost' IDENTIFIED BY 'admin';
CREATE USER 'hotelarz'@'localhost' IDENTIFIED BY 'hotel';

GRANT SELECT, INSERT, UPDATE, DELETE, REFERENCES ON hotel.Hotelarz TO 'administrator'@'localhost';
GRANT SELECT, INSERT, UPDATE, DELETE, REFERENCES ON hotel.Pokoj TO 'administrator'@'localhost';
GRANT SELECT, INSERT, UPDATE, DELETE, REFERENCES ON hotel.Administrator TO 'administrator'@'localhost';
GRANT SELECT, REFERENCES ON hotel.Klient TO 'hotelarz'@'localhost';

GRANT SELECT, INSERT, UPDATE, DELETE, REFERENCES ON hotel.Rezerwacja TO 'hotelarz'@'localhost';
GRANT SELECT, INSERT, UPDATE, DELETE, REFERENCES ON hotel.Klient TO 'hotelarz'@'localhost';
GRANT SELECT, REFERENCES ON hotel.Pokoj TO 'hotelarz'@'localhost';
GRANT REFERENCES ON hotel.Hotelarz TO 'hotelarz'@'localhost';
