package com.example.trendingapp.ui.trending

import androidx.lifecycle.MutableLiveData
import com.example.trendingapp.api.Resource
import com.example.trendingapp.base.BaseViewModel
import com.example.trendingapp.network.response.GetRepositoriesResponse
import com.example.trendingapp.utils.responseSubscribe
import javax.inject.Inject

class TrendingVM @Inject constructor(val repository: TrendingRepository) :
    BaseViewModel() {

    val getRepositoriesLiveData = MutableLiveData<Resource<GetRepositoriesResponse>>()

    fun getRepositories() {
        repository.getRepositories()
            .responseSubscribe(getRepositoriesLiveData)
    }

}