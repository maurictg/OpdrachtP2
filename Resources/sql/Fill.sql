USE netflix
GO

INSERT INTO Programs(title,lengthInMinutes) VALUES ('A Study in Pink',88);
INSERT INTO Programs(title,lengthInMinutes) VALUES ('The Blind Banker',88);
INSERT INTO Programs(title,lengthInMinutes) VALUES ('The Great Game',88);
INSERT INTO Programs(title,lengthInMinutes) VALUES ('A Scandal in Belgravia',88);
INSERT INTO Programs(title,lengthInMinutes) VALUES ('The Hounds of Baskerville',88);
INSERT INTO Programs(title,lengthInMinutes) VALUES ('The Reichenbach Fall',88);
INSERT INTO Programs(title,lengthInMinutes) VALUES ('The Empty Hearse',88);
INSERT INTO Programs(title,lengthInMinutes) VALUES ('The Sign of Three',88);
INSERT INTO Programs(title,lengthInMinutes) VALUES ('His Last Vow',88);
INSERT INTO Programs(title,lengthInMinutes) VALUES ('The Abominable Bride',89);
INSERT INTO Programs(title,lengthInMinutes) VALUES ('Pilot',58);
INSERT INTO Programs(title,lengthInMinutes) VALUES ('Cat’s in the Bag…',48);
INSERT INTO Programs(title,lengthInMinutes) VALUES ('…And the Bag’s in the River',48);
INSERT INTO Programs(title,lengthInMinutes) VALUES ('Cancer Man',48);
INSERT INTO Programs(title,lengthInMinutes) VALUES ('Gray Matter',48);
INSERT INTO Programs(title,lengthInMinutes) VALUES ('Crazy Handful of Nothin’',48);
INSERT INTO Programs(title,lengthInMinutes) VALUES ('A No-Rough-Stuff-Type Deal',48);
INSERT INTO Programs(title,lengthInMinutes) VALUES ('Seven Thirty-Seven',48);
INSERT INTO Programs(title,lengthInMinutes) VALUES ('Grilled',48);
INSERT INTO Programs(title,lengthInMinutes) VALUES ('Bit by a Dead Bee',48);
INSERT INTO Programs(title,lengthInMinutes) VALUES ('Down',48);
INSERT INTO Programs(title,lengthInMinutes) VALUES ('Breakage',48);
INSERT INTO Programs(title,lengthInMinutes) VALUES ('Peekaboo',48);
INSERT INTO Programs(title,lengthInMinutes) VALUES ('Negro Y Azul',48);
INSERT INTO Programs(title,lengthInMinutes) VALUES ('Better Call Saul',48);
INSERT INTO Programs(title,lengthInMinutes) VALUES ('4 Days Out',48);
INSERT INTO Programs(title,lengthInMinutes) VALUES ('Over',48);
INSERT INTO Programs(title,lengthInMinutes) VALUES ('Mandala',48);
INSERT INTO Programs(title,lengthInMinutes) VALUES ('Phoenix',48);
INSERT INTO Programs(title,lengthInMinutes) VALUES ('ABQ',48);
INSERT INTO Programs(title,lengthInMinutes) VALUES ('The Crocodile''s Dilemma',68);
INSERT INTO Programs(title,lengthInMinutes) VALUES ('The Rooster Prince',68);
INSERT INTO Programs(title,lengthInMinutes) VALUES ('A Muddy Road',68);
INSERT INTO Programs(title,lengthInMinutes) VALUES ('Eating the Blame',68);
INSERT INTO Programs(title,lengthInMinutes) VALUES ('The Six Ungraspables',68);
INSERT INTO Programs(title,lengthInMinutes) VALUES ('Buridan''s Ass',68);
INSERT INTO Programs(title,lengthInMinutes) VALUES ('Who Shaves the Barber?',68);
INSERT INTO Programs(title,lengthInMinutes) VALUES ('The Heap',68);
INSERT INTO Programs(title,lengthInMinutes) VALUES ('A Fox, a Rabbit, and a Cabbage',68);
INSERT INTO Programs(title,lengthInMinutes) VALUES ('Morton''s Fork',68);
INSERT INTO Programs(title,lengthInMinutes) VALUES ('The Life of Brian',94);
INSERT INTO Programs(title,lengthInMinutes) VALUES ('Pulp Fiction',154);
INSERT INTO Programs(title,lengthInMinutes) VALUES ('Pruimebloesem',80);
INSERT INTO Programs(title,lengthInMinutes) VALUES ('Reservoir Dogs',99);
INSERT INTO Programs(title,lengthInMinutes) VALUES ('The Good, the Bad and the Ugly',161);
INSERT INTO Programs(title,lengthInMinutes) VALUES ('Andy Warhol''s Dracula',103);
INSERT INTO Programs(title,lengthInMinutes) VALUES ('Waiting for Dutch',68);
INSERT INTO Programs(title,lengthInMinutes) VALUES ('Before the Law',68);
INSERT INTO Programs(title,lengthInMinutes) VALUES ('The Myth of Sisyphus',68);
INSERT INTO Programs(title,lengthInMinutes) VALUES ('The Gift of the Magi',68);
INSERT INTO Programs(title,lengthInMinutes) VALUES ('Fear and Trembling',68);
INSERT INTO Programs(title,lengthInMinutes) VALUES ('Rhinoceros',68);
INSERT INTO Programs(title,lengthInMinutes) VALUES ('Did you do this? No, you did it!',68);
INSERT INTO Programs(title,lengthInMinutes) VALUES ('Loplop',68);
INSERT INTO Programs(title,lengthInMinutes) VALUES ('The Castle',68);
INSERT INTO Programs(title,lengthInMinutes) VALUES ('Palindrome',68);
INSERT INTO Programs(title,lengthInMinutes) VALUES ('Ober',97);
INSERT INTO Programs(title,lengthInMinutes) VALUES ('Der Untergang',178);
INSERT INTO Programs(title,lengthInMinutes) VALUES ('De helaasheid der dingen',108);
INSERT INTO Programs(title,lengthInMinutes) VALUES ('A Clockwork Orange',136);

GO

INSERT INTO Series(serieName,recommendedSerie,seasonNumber,language,genre,age) VALUES ('Sherlock',6,1,'Engels','Detective',12);
INSERT INTO Series(serieName,recommendedSerie,seasonNumber,language,genre,age) VALUES ('Sherlock',6,2,'Engels','Detective',12);
INSERT INTO Series(serieName,recommendedSerie,seasonNumber,language,genre,age) VALUES ('Sherlock',6,3,'Engels','Detective',12);
INSERT INTO Series(serieName,recommendedSerie,seasonNumber,language,genre,age) VALUES ('Breaking Bad',6,1,'Engels-Amerikaans','Spanning',12);
INSERT INTO Series(serieName,recommendedSerie,seasonNumber,language,genre,age) VALUES ('Breaking Bad',6,2,'Engels-Amerikaans','Spanning',16);
INSERT INTO Series(serieName,recommendedSerie,seasonNumber,language,genre,age) VALUES ('Fargo',4,1,'Engels','Spanning',16);
INSERT INTO Series(serieName,recommendedSerie,seasonNumber,language,genre,age) VALUES ('Fargo',4,2,'Engels','Spanning',16);

/* Films */

GO

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

GO

INSERT INTO SeriesEpisode(programId,serieId,episodeNumber) VALUES (1,1,1);
INSERT INTO SeriesEpisode(programId,serieId,episodeNumber) VALUES (2,1,2);
INSERT INTO SeriesEpisode(programId,serieId,episodeNumber) VALUES (3,1,3);
INSERT INTO SeriesEpisode(programId,serieId,episodeNumber) VALUES (4,2,1);
INSERT INTO SeriesEpisode(programId,serieId,episodeNumber) VALUES (5,2,2);
INSERT INTO SeriesEpisode(programId,serieId,episodeNumber) VALUES (6,2,3);
INSERT INTO SeriesEpisode(programId,serieId,episodeNumber) VALUES (7,3,1);
INSERT INTO SeriesEpisode(programId,serieId,episodeNumber) VALUES (8,3,2);
INSERT INTO SeriesEpisode(programId,serieId,episodeNumber) VALUES (9,3,3);
/* 10: The Abominable Bride, film */
INSERT INTO SeriesEpisode(programId,serieId,episodeNumber) VALUES (11,4,1);
INSERT INTO SeriesEpisode(programId,serieId,episodeNumber) VALUES (12,4,2);
INSERT INTO SeriesEpisode(programId,serieId,episodeNumber) VALUES (13,4,3);
INSERT INTO SeriesEpisode(programId,serieId,episodeNumber) VALUES (14,4,4);
INSERT INTO SeriesEpisode(programId,serieId,episodeNumber) VALUES (15,4,5);
INSERT INTO SeriesEpisode(programId,serieId,episodeNumber) VALUES (16,4,6);
INSERT INTO SeriesEpisode(programId,serieId,episodeNumber) VALUES (17,4,7);
INSERT INTO SeriesEpisode(programId,serieId,episodeNumber) VALUES (18,5,1);
INSERT INTO SeriesEpisode(programId,serieId,episodeNumber) VALUES (19,5,2);
INSERT INTO SeriesEpisode(programId,serieId,episodeNumber) VALUES (20,5,3);
INSERT INTO SeriesEpisode(programId,serieId,episodeNumber) VALUES (21,5,4);
INSERT INTO SeriesEpisode(programId,serieId,episodeNumber) VALUES (22,5,5);
INSERT INTO SeriesEpisode(programId,serieId,episodeNumber) VALUES (23,5,6);
INSERT INTO SeriesEpisode(programId,serieId,episodeNumber) VALUES (24,5,7);
INSERT INTO SeriesEpisode(programId,serieId,episodeNumber) VALUES (25,5,8);
INSERT INTO SeriesEpisode(programId,serieId,episodeNumber) VALUES (26,5,9);
INSERT INTO SeriesEpisode(programId,serieId,episodeNumber) VALUES (27,5,10);
INSERT INTO SeriesEpisode(programId,serieId,episodeNumber) VALUES (28,5,11);
INSERT INTO SeriesEpisode(programId,serieId,episodeNumber) VALUES (29,5,12);
INSERT INTO SeriesEpisode(programId,serieId,episodeNumber) VALUES (30,5,13);
INSERT INTO SeriesEpisode(programId,serieId,episodeNumber) VALUES (31,6,1);
INSERT INTO SeriesEpisode(programId,serieId,episodeNumber) VALUES (32,6,2);
INSERT INTO SeriesEpisode(programId,serieId,episodeNumber) VALUES (33,6,3);
INSERT INTO SeriesEpisode(programId,serieId,episodeNumber) VALUES (34,6,4);
INSERT INTO SeriesEpisode(programId,serieId,episodeNumber) VALUES (35,6,5);
INSERT INTO SeriesEpisode(programId,serieId,episodeNumber) VALUES (36,6,6);
INSERT INTO SeriesEpisode(programId,serieId,episodeNumber) VALUES (37,6,7);
INSERT INTO SeriesEpisode(programId,serieId,episodeNumber) VALUES (38,6,8);
INSERT INTO SeriesEpisode(programId,serieId,episodeNumber) VALUES (39,6,9);
INSERT INTO SeriesEpisode(programId,serieId,episodeNumber) VALUES (40,6,10);
/* 41 - 46: films */
INSERT INTO SeriesEpisode(programId,serieId,episodeNumber) VALUES (47,7,1);
INSERT INTO SeriesEpisode(programId,serieId,episodeNumber) VALUES (48,7,2);
INSERT INTO SeriesEpisode(programId,serieId,episodeNumber) VALUES (49,7,3);
INSERT INTO SeriesEpisode(programId,serieId,episodeNumber) VALUES (50,7,4);
INSERT INTO SeriesEpisode(programId,serieId,episodeNumber) VALUES (51,7,5);
INSERT INTO SeriesEpisode(programId,serieId,episodeNumber) VALUES (52,7,6);
INSERT INTO SeriesEpisode(programId,serieId,episodeNumber) VALUES (53,7,7);
INSERT INTO SeriesEpisode(programId,serieId,episodeNumber) VALUES (54,7,8);
INSERT INTO SeriesEpisode(programId,serieId,episodeNumber) VALUES (55,7,9);
INSERT INTO SeriesEpisode(programId,serieId,episodeNumber) VALUES (56,7,10);