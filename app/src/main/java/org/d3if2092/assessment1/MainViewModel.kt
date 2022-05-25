package org.d3if2092.assessment1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val data = MutableLiveData<FormFragment?>()

    fun getData(): LiveData<FormFragment?> = data

}