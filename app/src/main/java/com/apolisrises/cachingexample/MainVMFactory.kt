package com.apolisrises.cachingexample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.apolisrises.cachingexample.data.IRepository

class MainVMFactory(val repository: IRepository): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}