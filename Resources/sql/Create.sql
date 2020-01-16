DROP DATABASE IF EXISTS netflix

CREATE DATABASE netflix;
GO
USE netflix;
GO

CREATE TABLE Accounts (
    accountId INT NOT NULL PRIMARY KEY IDENTITY(1,1), /* PK */
    accountName VARCHAR(50),
    password VARCHAR(50),
    city VARCHAR(50),
    street VARCHAR(50),
    number INT NULL,
    extension VARCHAR(50),
    phone VARCHAR(12),
    birthdate DATETIME2 NULL
);

CREATE TABLE Programs (
    programId INT NOT NULL PRIMARY KEY IDENTITY(1,1), /* PK */
    title VARCHAR(50),
    lengthInMinutes INT NULL
);

CREATE TABLE Films (
    filmId INT NOT NULL PRIMARY KEY IDENTITY(1,1), /* PK */
    age INT NULL,
    language VARCHAR(50),
    genre VARCHAR(50),
    programId INT NOT NULL FOREIGN KEY REFERENCES Programs(programId) /* FK  */
);

CREATE TABLE Profiles (
    profileId INT NOT NULL PRIMARY KEY IDENTITY(1,1), /* PK */
    profileName VARCHAR(50),
    accountId INT NOT NULL FOREIGN KEY REFERENCES Accounts(accountId) /* FK  */
);

CREATE TABLE Series (
    serieId INT NOT NULL PRIMARY KEY IDENTITY(1,1), /* PK */
    serieName VARCHAR(50),
    recommendedSerie INT NULL, /* virtual FK */
    seasonNumber INT NULL,
    language VARCHAR(50),
    genre VARCHAR(50),
    age INT NULL
);

CREATE TABLE SeriesEpisode (
    seriesEpisodeId INT NOT NULL PRIMARY KEY IDENTITY(1,1), /* PK */
    programId INT NOT NULL FOREIGN KEY REFERENCES Programs(programId), /* FK 1 */
    serieId INT NOT NULL FOREIGN KEY REFERENCES Series(serieId) /* FK 2 */,
    episodeNumber INT NULL /* aflevering */
);

CREATE TABLE WatchedProgram (
    watchedProgramId INT NOT NULL PRIMARY KEY IDENTITY(1,1), /* PK */
    programId INT NOT NULL FOREIGN KEY REFERENCES Programs(programId), /* FK 1 */
    profileId INT NOT NULL FOREIGN KEY REFERENCES Profiles(profileId), /* FK 2 */
    timeWatched INT NULL
);

GO

