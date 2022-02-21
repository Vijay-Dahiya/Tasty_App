package com.vijay.mytastyfoodapp.model

import androidx.lifecycle.MutableLiveData
import com.vijay.mytastyfoodapp.model.remote.ApiClient
import com.vijay.mytastyfoodapp.model.remote.ResultsItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class Repo @Inject constructor(private val apiClient: ApiClient){
    private val dataList= MutableLiveData<ArrayList<ResultsItem>>()
    private val liveError=MutableLiveData<String>()

    fun getData():MutableLiveData<ArrayList<ResultsItem>>{
        CoroutineScope(Dispatchers.IO).launch {
            try {
                dataList.postValue(apiClient.getData().results!! as ArrayList<ResultsItem>?)
            }catch (e:Exception){
                liveError.postValue(e.toString())
            }
        }
        return dataList
    }
    fun getError()=liveError
}