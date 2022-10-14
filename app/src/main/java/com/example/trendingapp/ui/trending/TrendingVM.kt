package com.example.trendingapp.ui.trending

import com.example.trendingapp.base.BaseViewModel
import javax.inject.Inject

class TrendingVM @Inject constructor(val repository: TrendingRepository) :
    BaseViewModel() {

  //  val getTrendingLiveData = MutableLiveData<Resource<GetCollectionDetailsResponse>>()

    fun getNearbyCollection(latitude: String, longitude: String) {
//        val request = GetCollectionDetailsRequest(HdfcApplication.getInstance())
//
//        repository.getNearbyCollections(request).responseSuscriber(nearbyCollectionLiveData)
    }

}