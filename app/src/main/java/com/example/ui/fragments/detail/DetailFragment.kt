package com.example.ui.fragments.detail
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.`object`.Constant.KEY_ID
import com.example.core.ui.base.BaseFragment
import com.example.model.playlist.Items
import com.example.youtubeapi.databinding.FragmentDetailBinding
import com.example.youtubeapi.databinding.ScrollingContent2Binding

class   DetailFragment : BaseFragment<FragmentDetailBinding, DetailViewModel>(
    FragmentDetailBinding::inflate,
    DetailViewModel::class.java
), OnPlaylistItemClick {
    private lateinit var bottomBinding: ScrollingContent2Binding

    override fun setupLiveData() {}
    override fun setupUI() {

        bottomBinding = binding.scrollingContent2
        val item: Items = arguments?.getSerializable(KEY_ID) as Items

        binding.textTitle.text = item.snippet.title
        binding.textDescription.text = item.snippet.description

        viewModel.fetchPlayListItems(item.id).observe(viewLifecycleOwner, {
            bottomBinding.recyclerView.apply {
                val adapter = it.data?.let { it1 -> DetailAdapter(this@DetailFragment, it1) }
                layoutManager = LinearLayoutManager(context)
                this.adapter = adapter
            }
        })
    }

    override fun onPlaylistItem(videoId: String) {}
}