package com.example.trendingapp.ui.trending

import android.os.Bundle
import com.example.trendingapp.R
import com.example.trendingapp.api.Status
import com.example.trendingapp.base.BaseActivity
import com.example.trendingapp.databinding.ActivityTrendingBinding
import com.example.trendingapp.network.response.GetRepositoriesResponse
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TrendingActivity : BaseActivity<TrendingVM, ActivityTrendingBinding>() {

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
    }

    private fun onRetry() {

    }

    private fun observeData() {
        viewModel.getRepositoriesLiveData.observe(this){
            when(it.status){
                Status.LOADING->{
                    showProgress()
                }
                Status.SUCCESS->{
                    getRepositoriesResponse(it.data)
                    hideProgress()
                }
                Status.ERROR->{
                    showErrorMessage(it.data.toString())
                    hideProgress()
                }
                Status.THROWABLE -> {
                    val errorBody = it.throwable
                    showErrorMessage(errorBody?.message.toString())
                    hideProgress()
                }
            }
        }
    }

    private fun getRepositoriesResponse(res: GetRepositoriesResponse?) {
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
