package com.example.network
import com.example.model.PlayList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface YoutubeApi {
    @GET("playlists")
    fun fetchAllPlayList(
        @Query("part") part: String,
        @Query("channelId") channelId: String,
        @Query("key") apiKey: String,
    ): Call<PlayList>

    //https://www.googleapis.com/youtube/v3/channelId?id=7lCDEYXw3mM&key=AIzaSyDvL084UCGeQv3LnYBB1V6ts8_lL4RpHZs&part=snippet,contentDetails
}