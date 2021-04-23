package com.example.ui.fragments.playlist
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.`object`.Constant.KEY_ID
import com.example.base.BaseFragment
import com.example.extensions.visible
import com.example.ui.connection.NetworkConnection
import com.example.ui.main.MainViewModel
import com.example.youtubeapi.R
import com.example.youtubeapi.databinding.FragmentPlayListBinding

class PlayListFragment : BaseFragment<FragmentPlayListBinding, MainViewModel>(
    FragmentPlayListBinding::inflate,
    MainViewModel::class.java
), OnPlaylistClick {

    override fun setupLiveData() {}

    override fun setupUI() {

        (activity as AppCompatActivity).supportActionBar?.hide()

        val networkConnection = context?.let { NetworkConnection(it) }
        networkConnection?.observe(this, Observer {
            binding.connectionContainer.visible = !it
        })

        binding.recyclerView.apply {

            viewModel.fetchPlayList().observe(viewLifecycleOwner, {

                val adapter: PlaylistAdapter? = it?.let { it1 -> PlaylistAdapter(this@PlayListFragment, it1)}
                layoutManager = LinearLayoutManager(context)
                this.adapter = adapter

            })
        }
    }

    override fun onPlaylist(id: String) {
        val b = Bundle(); b.putString(KEY_ID, id)
        view?.let { Navigation.findNavController(it).navigate(R.id.detailFragment, b) }
    }
}