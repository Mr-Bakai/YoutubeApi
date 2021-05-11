package com.example.ui.fragments.detail
import androidx.lifecycle.LiveData
import com.example.YouTubeApp
import com.example.core.network.result.Resource
import com.example.core.ui.base.BaseViewModel
import com.example.model.playlistItems.PlayListItems
import retrofit2.Response

class DetailViewModel: BaseViewModel() {

    fun fetchPlayListItems(id: String): LiveData<Resource<PlayListItems>> {
        return YouTubeApp.repository.fetchYoutubeApiPlaylistItems(id)
    }
}