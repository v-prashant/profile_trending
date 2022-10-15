package com.example.trendingapp.ui.trending

import android.os.Bundle
import android.view.View
import com.example.trendingapp.R
import com.example.trendingapp.base.BaseActivity
import com.example.trendingapp.databinding.ActivityTrendingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TrendingActivity : BaseActivity<TrendingVM, ActivityTrendingBinding>() {

    var dataList = ArrayList<TrendingItems>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initData()
        initViews()
        observeData()
        onClickListener()
    }

    private fun onClickListener() {
         binding.noInternet.btnRetry.setOnClickListener {
             onRetry()
         }
    }

    private fun onRetry() {

    }

    private fun initData() {
        dataList.add(TrendingItems(null, "Prashant", "Android Developer", "I am Prashant Verma hji nin kmlknk hnjnfr", "Kotlin", "150", "1500"))
        dataList.add(TrendingItems(null, "Bikki", "Backend Developer", "I am Bikki Verma", "Java", "10", "1100"))
        dataList.add(TrendingItems(null, "Honey", "Android Developer", "I am Honey Verma", "Python", "110", "1300"))
        dataList.add(TrendingItems(null, "Tushar", "Backend Developer", "I am Tushar Verma", "C++", "130", "1200"))
    }

    private fun observeData() {
//        viewModel.getTrendingLiveData.observeLiveData {
//            getTrendingResponse()
//            hideProgress()
//        }
    }

    private fun getTrendingResponse() {

    }

    private fun initViews() {
        binding.rvTrendingList.adapter = TrendingAdapter(this, dataList)
    }

    override val layoutId: Int
        get() = R.layout.activity_trending
}
