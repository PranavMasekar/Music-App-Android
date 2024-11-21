package com.example.songsapi.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.io.Serializable

@JsonClass(generateAdapter = true)
data class LyricsResponse(
    @Json(name = "message")
    val message: LyricsMessage?
)

@JsonClass(generateAdapter = true)
data class LyricsMessage(
    @Json(name = "body")
    val body: LyricsBody?,
    @Json(name = "header")
    val header: Header?
)

@JsonClass(generateAdapter = true)
data class LyricsBody(
    @Json(name = "lyrics")
    val lyrics: Lyrics?
)

@JsonClass(generateAdapter = true)
data class Lyrics(
    @Json(name = "explicit")
    val explicit: Int?,
    @Json(name = "lyrics_body")
    val lyricsBody: String?,
    @Json(name = "lyrics_copyright")
    val lyricsCopyright: String?,
    @Json(name = "lyrics_id")
    val lyricsId: Int?,
    @Json(name = "pixel_tracking_url")
    val pixelTrackingUrl: String?,
    @Json(name = "script_tracking_url")
    val scriptTrackingUrl: String?,
    @Json(name = "updated_time")
    val updatedTime: String?
) : Serializable
