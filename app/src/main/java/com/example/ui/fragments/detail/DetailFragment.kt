package com.example.ui.fragments.detail
import android.widget.Toast
import com.example.`object`.Constant.KEY_ID
import com.example.base.BaseFragment
import com.example.youtubeapi.databinding.FragmentDetailBinding

class DetailFragment : BaseFragment<FragmentDetailBinding, DetailViewModel>(
    FragmentDetailBinding::inflate,
    DetailViewModel::class.java
) {

    override fun setupLiveData() {}

    override fun setupUI() {
        val text: String? = arguments?.getString(KEY_ID)
        Toast.makeText(context, text.toString(), Toast.LENGTH_SHORT).show()
    }
}