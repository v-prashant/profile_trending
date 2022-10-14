package com.example.trendingapp.ui.trending

import android.os.Bundle
import com.example.trendingapp.R
import com.example.trendingapp.base.BaseActivity
import com.example.trendingapp.databinding.ActivityTrendingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TrendingActivity : BaseActivity<TrendingVM, ActivityTrendingBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        initToolbar()
        observeData()
    }

    private fun observeData() {
//        viewModel.getTrendingLiveData.observeLiveData {
//            getTrendingResponse()
//            hideProgress()
//        }
    }

    private fun getTrendingResponse() {

    }

    private fun initToolbar() {
//        binding.txnToolbar.navigationIcon =
//            ContextCompat.getDrawable(this, R.drawable.ic_arrow_left_outline)
//        binding.txnToolbar.setNavigationOnClickListener { finish() }
//
//        binding.txnAppBarTitle.text = resources.getString(R.string.nearby_collections)

    }

    private fun initViews() {

    }

    override val layoutId: Int
        get() = R.layout.activity_trending
}
