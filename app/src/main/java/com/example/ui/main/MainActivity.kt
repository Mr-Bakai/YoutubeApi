package com.example.ui.main
import com.example.base.BaseActivity
import com.example.youtubeapi.databinding.ActivityMainBinding

class MainActivity: BaseActivity<ActivityMainBinding, MainViewModel>(ActivityMainBinding::inflate, MainViewModel::class.java) {

    override fun setUpView() {

    }
}