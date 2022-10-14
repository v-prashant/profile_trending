package com.example.trendingapp.ui.trending

import androidx.lifecycle.MutableLiveData
import com.example.trendingapp.api.APIService
import io.reactivex.SingleObserver
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class TrendingRepository @Inject constructor(private val apiService: APIService) {

  //   fun getNearbyCollections(request: GetCollectionDetailsRequest) = apiService.getCollectionDetails(request)

}