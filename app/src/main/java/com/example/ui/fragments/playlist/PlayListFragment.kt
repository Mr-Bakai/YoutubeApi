package com.example.ui.fragments.playlist
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.`object`.Constant.KEY_ID
import com.example.core.network.result.Status
import com.example.core.ui.base.BaseFragment
import com.example.extensions.visible
import com.example.model.playlist.Items
import com.example.ui.connection.NetworkConnection
import com.example.youtubeapi.R
import com.example.youtubeapi.databinding.FragmentPlayListBinding
import com.example.youtubeapi.databinding.ScrollingContent1Binding
import com.google.android.material.bottomsheet.BottomSheetBehavior

class PlayListFragment : BaseFragment<FragmentPlayListBinding, PlayListViewModelFragment>(
    FragmentPlayListBinding::inflate,
    PlayListViewModelFragment::class.java
), OnPlaylistClick {


    private lateinit var bottomSheetBehavior: BottomSheetBehavior<LinearLayout>
    private lateinit var bottomBinding: ScrollingContent1Binding

    override fun setupLiveData(){}

    override fun setupUI() {

        bottomBinding = binding.scrolling1Content
        bottomSheetBehavior = BottomSheetBehavior.from(bottomBinding.baatyr)

        bottomSheetBehavior.addBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {}
            override fun onStateChanged(bottomSheet: View, newState: Int) {}
        })


        (activity as AppCompatActivity).supportActionBar?.hide()

        val networkConnection = context?.let { NetworkConnection(it) }
        networkConnection?.observe(this, Observer {
            bottomBinding.connectionContainer.visible = !it
        })


        bottomBinding.recyclerView.apply {
            viewModel.loading.observe(viewLifecycleOwner, {
                bottomBinding.progressBar.visible = it
            })


            viewModel.fetchPlayList().observe(viewLifecycleOwner, {
                when (it.status) {
                    Status.LOADING -> {
                        viewModel.loading.postValue(true)
                    }

                    Status.SUCCESS -> {
                        viewModel.loading.postValue(false)
                        val adapter: PlaylistAdapter? =
                            it.data?.let { it1 -> PlaylistAdapter(this@PlayListFragment, it1) }
                        layoutManager = LinearLayoutManager(context)
                        this.adapter = adapter
                    }

                    Status.ERROR -> {
                        viewModel.loading.postValue(true)
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                    }
                }
            })
        }
    }

    override fun onPlaylist(item: Items) {
        val b = Bundle();
        b.putSerializable(KEY_ID, item)
        view?.let { Navigation.findNavController(it).navigate(R.id.detailFragment, b) }
    }
}