package com.example.trendingapp.ui.trending

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.trendingapp.R
import com.example.trendingapp.api.Status
import com.example.trendingapp.base.BaseActivity
import com.example.trendingapp.databinding.ActivityTrendingBinding
import com.example.trendingapp.network.response.GetRepositoriesResponse
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TrendingActivity : BaseActivity<TrendingVM, ActivityTrendingBinding>() {

  //  var skeletonScreen = Sk
    var dataList = ArrayList<TrendingItems>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeData()
        initViews()
        callRepositoriesApi()
        onClickListener()
    }

    private fun callRepositoriesApi() {
         viewModel.getRepositories()
    }

    private fun onClickListener() {
        binding.noInternet.btnRetry.setOnClickListener {
            onRetry()
        }
        binding.swipeRefreshLayout.setOnRefreshListener {
            onRefresh()
        }
    }

    private fun onRefresh() {
        viewModel.getRepositories()
        binding.swipeRefreshLayout.isRefreshing = false
    }

    private fun observeData() {
        viewModel.getRepositoriesLiveData.observe(this){
            when(it.status){
                Status.LOADING->{
                    showSkeltonLoading()
                }
                Status.SUCCESS->{
                    getRepositoriesResponse(it.data)
                    hideSkeltonLoading()
                }
                Status.ERROR->{
                    showErrorMessage(it.data.toString())
                    hideSkeltonLoading()
                }
                Status.THROWABLE -> {
                    showNoInternetMessage()
                    hideSkeltonLoading()
                }
            }
        }
    }

    private fun showSkeltonLoading() {
        with(binding){
            noInternet.root.visibility = View.GONE
            rvTrendingList.visibility = View.GONE
            shimmerLayout.visibility = View.VISIBLE
            shimmerLayout.startShimmerAnimation()
        }
    }

    private fun hideSkeltonLoading() {
        with(binding){
            rvTrendingList.visibility = View.VISIBLE
            shimmerLayout.visibility = View.GONE
            shimmerLayout.stopShimmerAnimation()
        }
    }

    private fun showNoInternetMessage() {
        showErrorMessage(getString(R.string.server_error))
         with(binding){
             rvTrendingList.visibility = View.GONE
             noInternet.root.visibility = View.VISIBLE
         }
    }

    private fun onRetry() {
         viewModel.getRepositories()
    }

    private fun getRepositoriesResponse(res: GetRepositoriesResponse?) {
        with(binding){
            rvTrendingList.visibility = View.VISIBLE
            noInternet.root.visibility = View.GONE
        }
        dataList.clear()
        if(res?.items != null)
            for(item in res.items!!)
                dataList.add(TrendingItems(null, item.name, item.htmlUrl, item.description, item.language, item.watchersCount, item.forksCount))

        binding.rvTrendingList.adapter = TrendingAdapter(this, dataList)
    }

    private fun initViews() {

    }

    override val layoutId: Int
        get() = R.layout.activity_trending
}
