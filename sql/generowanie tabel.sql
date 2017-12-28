CREATE TABLE Administrator
(
	  `e-mail` varchar(30) NOT NULL UNIQUE,
	  haslo    varchar(20) NOT NULL
);

CREATE TABLE Hotelarz
(
		ID integer(10) NOT NULL AUTO_INCREMENT,
		`e-mail` varchar(30) not null unique,
	 	haslo varchar(20) not null,
		imie varchar(30),
		nazwisko varchar(30),
		data_urodzenia date,
		PRIMARY KEY (ID)
);

CREATE TABLE Klient
(
	  ID               int(10) NOT NULL AUTO_INCREMENT,
	  HotelarzID       int(10) NOT NULL,
	  imie             varchar(30) NOT NULL,
	  nazwisko         varchar(30) NOT NULL,
	  numer_telefonu   int(10),
	  `e-mail`         varchar(30),
	  rodzaj_dokumentu varchar(30) NOT NULL,
	  numer_dokumentu  varchar(20) NOT NULL,
	  jezyk            varchar(20),
	  PRIMARY KEY (ID),
		FOREIGN KEY (HotelarzID) REFERENCES Hotelarz(ID)
			ON DELETE CASCADE
	    ON UPDATE CASCADE
);


CREATE TABLE Pokoj
(		ID integer(5) NOT NULL AUTO_INCREMENT,
		KlientID integer(10),
		numer_pokoju integer(10) NOT NULL,
    pietro integer(5),
    poziom_standardu double(10,2),
    liczba_osob integer(5),
    cena_za_dobe double(10,2),
    primary KEY (ID),
    foreign KEY (KlientID) REFERENCES Klient(ID)
			ON DELETE CASCADE
			ON UPDATE CASCADE
);

CREATE TABLE Rezerwacja
(		HotelarzID integer(10) NOT NULL,
		PokojID integer(5) NOT NULL,
    KlientID integer(10) NOT NULL,
    data_przyj date NOT NULL,
    data_wyj date NOT NULL,
    rachunek double(10,2),
    zaliczka double(10,2),
    liczba_osob integer(10),
    sniadanie bit,
    FOREIGN KEY (HotelarzID) references hotelarz(ID)
			ON DELETE CASCADE
			ON UPDATE CASCADE,
    FOREIGN KEY (PokojID) references pokoj(ID)
			ON DELETE CASCADE
			ON UPDATE CASCADE,
    FOREIGN KEY (KlientID) references klient(ID)
			ON DELETE CASCADE
			ON UPDATE CASCADE
);
