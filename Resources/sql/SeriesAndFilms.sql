USE netflix
GO

INSERT INTO Series(serieName,recommendedSerie,seasonNumber,language,genre,age) VALUES ('Sherlock',6,1,'Engels','Detective',12);
INSERT INTO Series(serieName,recommendedSerie,seasonNumber,language,genre,age) VALUES ('Sherlock',6,2,'Engels','Detective',12);
INSERT INTO Series(serieName,recommendedSerie,seasonNumber,language,genre,age) VALUES ('Sherlock',6,3,'Engels','Detective',12);
INSERT INTO Series(serieName,recommendedSerie,seasonNumber,language,genre,age) VALUES ('Breaking Bad',6,1,'Engels-Amerikaans','Spanning',12);
INSERT INTO Series(serieName,recommendedSerie,seasonNumber,language,genre,age) VALUES ('Breaking Bad',6,2,'Engels-Amerikaans','Spanning',16);
INSERT INTO Series(serieName,recommendedSerie,seasonNumber,language,genre,age) VALUES ('Fargo',4,1,'Engels','Spanning',16);
INSERT INTO Series(serieName,recommendedSerie,seasonNumber,language,genre,age) VALUES ('Fargo',4,2,'Engels','Spanning',16);

/* Films */

INSERT INTO Films(language,genre,age,programId) VALUES ('Nederlands','Humor',6,57);
INSERT INTO Films(language,genre,age,programId) VALUES ('Duits','Oorlog',6,58);
INSERT INTO Films(language,genre,age,programId) VALUES ('Vlaams','Humor',12,59);
INSERT INTO Films(language,genre,age,programId) VALUES ('Engels','Sciencefiction',12,60);
INSERT INTO Films(language,genre,age,programId) VALUES ('Engels','Humor',12,41);
INSERT INTO Films(language,genre,age,programId) VALUES ('Engels-Amerikaans','Misdaad',16,42);
INSERT INTO Films(language,genre,age,programId) VALUES ('Nederlands','Erotiek',18,43);
INSERT INTO Films(language,genre,age,programId) VALUES ('Engels-Amerikaans','Misdaad',16,44);
INSERT INTO Films(language,genre,age,programId) VALUES ('Engels-Amerikaans','Western',12,45);
INSERT INTO Films(language,genre,age,programId) VALUES ('Engels-Amerikaans','Humor',16,46);
INSERT INTO Films(language,genre,age,programId) VALUES ('Engels','Detective',12,10);