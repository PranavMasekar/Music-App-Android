package com.example.songsapi.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.io.Serializable

@JsonClass(generateAdapter = true)
data class TracksResponse(
    @Json(name = "message")
    val message: Message?
)

@JsonClass(generateAdapter = true)
data class Message(
    @Json(name = "body")
    val body: Body?,
    @Json(name = "header")
    val header: Header?
)

@JsonClass(generateAdapter = true)
data class Body(
    @Json(name = "track_list")
    val trackList: List<TrackListItem?>?
)

@JsonClass(generateAdapter = true)
data class TrackListItem(
    @Json(name = "track")
    val track: Track?
)

@JsonClass(generateAdapter = true)
data class Track(
    @Json(name = "album_id")
    val albumId: Int? = null,
    @Json(name = "album_name")
    val albumName: String? = null,
    @Json(name = "artist_id")
    val artistId: Int? = null,
    @Json(name = "artist_name")
    val artistName: String? = null,
    @Json(name = "commontrack_id")
    val commontrackId: Int? = null,
    @Json(name = "explicit")
    val explicit: Int? = null,
    @Json(name = "has_lyrics")
    val hasLyrics: Int? = null,
    @Json(name = "has_richsync")
    val hasRichsync: Int? = null,
    @Json(name = "has_subtitles")
    val hasSubtitles: Int? = null,
    @Json(name = "instrumental")
    val instrumental: Int? = null,
    @Json(name = "num_favourite")
    val numFavourite: Int? = null,
    @Json(name = "primary_genres")
    val primaryGenres: PrimaryGenres? = null,
    @Json(name = "restricted")
    val restricted: Int? = null,
    @Json(name = "track_edit_url")
    val trackEditUrl: String? = null,
    @Json(name = "track_id")
    val trackId: Int? = null,
    @Json(name = "track_name")
    val trackName: String? = null,
    @Json(name = "track_name_translation_list")
    val trackNameTranslationList: List<TrackNameTranslation?>? = null,
    @Json(name = "track_rating")
    val trackRating: Int? = null,
    @Json(name = "track_share_url")
    val trackShareUrl: String? = null,
    @Json(name = "updated_time")
    val updatedTime: String? = null
) : Serializable

@JsonClass(generateAdapter = true)
data class PrimaryGenres(
    @Json(name = "music_genre_list")
    val musicGenreList: List<MusicGenreListItem?>?
)

@JsonClass(generateAdapter = true)
data class MusicGenreListItem(
    @Json(name = "music_genre")
    val musicGenre: MusicGenre?
)

@JsonClass(generateAdapter = true)
data class MusicGenre(
    @Json(name = "music_genre_id")
    val musicGenreId: Int?,
    @Json(name = "music_genre_name")
    val musicGenreName: String?,
    @Json(name = "music_genre_name_extended")
    val musicGenreNameExtended: String?,
    @Json(name = "music_genre_parent_id")
    val musicGenreParentId: Int?,
    @Json(name = "music_genre_vanity")
    val musicGenreVanity: String?
)

@JsonClass(generateAdapter = true)
data class TrackNameTranslation(
    @Json(name = "track_name_translation")
    val trackNameTranslation: TrackNameTranslationDetails?
)

@JsonClass(generateAdapter = true)
data class TrackNameTranslationDetails(
    @Json(name = "language")
    val language: String?,
    @Json(name = "translation")
    val translation: String?
)

@JsonClass(generateAdapter = true)
data class Header(
    @Json(name = "execute_time")
    val executeTime: Double?,
    @Json(name = "status_code")
    val statusCode: Int?
)