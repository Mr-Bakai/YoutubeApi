package com.example.remote
import com.example.model.playlistItems.PlayListItems
import com.example.model.playlist.PlayList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface YoutubeApi {

    @GET("playlists")
    suspend fun fetchAllPlayList(
        @Query("part") part: String,
        @Query("channelId") channelId: String,
        @Query("maxResults") maxResults: Int,
        @Query("key") apiKey: String,
    ): Response<PlayList>

    @GET("playlistItems")
    suspend fun fetchPlaylistItems(
        @Query("part") part: String,
        @Query("playlistId") playlistId: String,
        @Query("key") apiKey: String,
    ): Response<PlayListItems>
}