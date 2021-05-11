package com.example.repository
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.model.playlistItems.PlayListItems
import com.example.model.playlist.PlayList
import com.example.core.network.result.Resource
import com.example.remote.RemoteDataSource
import kotlinx.coroutines.Dispatchers
import retrofit2.Response

class Repository(private val dataSource: RemoteDataSource) {

    fun fetchYoutubeApiPlayList(): LiveData<Resource<PlayList>> = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        val response = dataSource.fetchAllPlaylist()
        emit(response)
    }

 fun fetchYoutubeApiPlaylistItems(id: String): LiveData<Resource<PlayListItems>> = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        val response = dataSource.fetchPlaylistItems(id)
        emit(response)
    }
}