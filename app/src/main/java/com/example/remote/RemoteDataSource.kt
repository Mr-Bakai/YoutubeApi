package com.example.remote

import com.example.`object`.Constant
import com.example.core.network.BaseDataSource
import com.example.core.network.RetrofitClient

class RemoteDataSource: BaseDataSource() {

    private var apiService: YoutubeApi = RetrofitClient.create()

    suspend fun fetchAllPlaylist() = getResult {
        apiService.fetchAllPlayList(
            Constant.PART,
            Constant.CHANNEL_ID,
            Constant.MAX_RESULT,
            Constant.API_KEY)
    }

    suspend fun fetchPlaylistItems(id: String) = getResult {
        apiService.fetchPlaylistItems(
            Constant.PART,
            id,
            Constant.API_KEY)
    }
}