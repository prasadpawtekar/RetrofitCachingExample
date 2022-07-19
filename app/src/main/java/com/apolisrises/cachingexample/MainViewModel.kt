package com.apolisrises.cachingexample

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apolisrises.cachingexample.data.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MainViewModel(val repository: IRepository): ViewModel() {

    val searchResult = MutableLiveData<List<Result>>()
    val error = MutableLiveData<String>()

    fun search(term: String) {
        viewModelScope.launch(IO) {
            try {
                val response = repository.search(term)
                if(response.isSuccessful) {
                    searchResult.postValue(response.body()?.results ?: emptyList())
                } else {
                    error.postValue("Unknown error. Please retry.")
                }
            } catch (e: Exception) {
                error.postValue("Error is : ${e.toString()}")
            }
        }
    }

}