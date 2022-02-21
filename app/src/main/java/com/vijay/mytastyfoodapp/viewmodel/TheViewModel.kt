package com.vijay.mytastyfoodapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vijay.mytastyfoodapp.model.Repo
import com.vijay.mytastyfoodapp.model.remote.ResultsItem
import javax.inject.Inject

class TheViewModel @Inject constructor(private val repo: Repo):ViewModel() {
    private var data = MutableLiveData<ArrayList<ResultsItem>>()
    fun getDat(){
        data=repo.getData()
    }
    fun getLiveData()=data
    fun getErrors()=repo.getError()
}