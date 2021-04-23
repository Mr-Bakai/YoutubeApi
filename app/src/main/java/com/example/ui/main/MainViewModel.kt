package com.example.ui.main
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.`object`.Constant
import com.example.base.BaseViewModel
import com.example.model.PlayList
import com.example.network.RetrofitClient
import com.example.network.YoutubeApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : BaseViewModel() {

    fun fetchPlayList(): LiveData<PlayList?> {
        return fetchYoutubeApiPlayList()
    }

    private var youtubeApi: YoutubeApi? = null

    private fun fetchYoutubeApiPlayList(): LiveData<PlayList?> {
        youtubeApi = RetrofitClient.create()

        val data = MutableLiveData<PlayList?>()

        youtubeApi?.fetchAllPlayList(
            Constant.PART,
            Constant.CHANNEL_ID,
            Constant.API_KEY
        )
            ?.enqueue(object : Callback<PlayList> {

                override fun onResponse(call: Call<PlayList>, response: Response<PlayList>) {
                    data.value = response.body()
                }

                override fun onFailure(call: Call<PlayList>, t: Throwable) {
                    // 404 - не найдено, 403 - токен истек, 401 - нет доступа
                    data.value = null
                }
            })
        return data
    }
}