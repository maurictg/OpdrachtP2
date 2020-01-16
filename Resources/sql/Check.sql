use netflix
GO

/* These queries are needed to check if the data is correct (by a human) */

/* check films */
SELECT Films.*, Programs.* FROM Films
INNER JOIN Programs ON Programs.programId = Films.programId

GO

/* check programs */
SELECT Series.serieName, Series.seasonNumber, SeriesEpisode.episodeNumber, Series.recommendedSerie, Series.age, Series.genre, Series.language, Programs.title, Programs.lengthInMinutes FROM SeriesEpisode
INNER JOIN Series ON Series.serieId = SeriesEpisode.serieId
INNER JOIN Programs ON Programs.programId = SeriesEpisode.programId
