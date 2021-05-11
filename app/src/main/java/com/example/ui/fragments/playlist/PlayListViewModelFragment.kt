package com.example.ui.fragments.playlist
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.YouTubeApp
import com.example.core.network.result.Resource
import com.example.core.ui.base.BaseViewModel
import com.example.model.playlist.PlayList
import com.example.model.playlistItems.PlayListItems
import retrofit2.Response

class PlayListViewModelFragment: BaseViewModel() {

    var loading = MutableLiveData<Boolean>()

    fun fetchPlayList(): LiveData<Resource<PlayList>> {
        return YouTubeApp.repository.fetchYoutubeApiPlayList()
    }
}