package org.d3if2092.assessment1

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if2092.assessment1.model.Dosen
import org.d3if2092.assessment1.model.HasilNilai
import org.d3if2092.assessment1.network.ApiStatus
import org.d3if2092.assessment1.network.DosenApi
import org.d3if2092.assessment1.network.UpdateWorker
import java.util.concurrent.TimeUnit

class MainViewModel : ViewModel() {

    private val data = MutableLiveData<List<Dosen>>()
    private val status = MutableLiveData<ApiStatus>()

    init {
        retrieveData()
    }

    fun rataNilai(nilaiSmtr1: Float, nilaiSmtr2: Float) : HasilNilai {
        val rataNilai = (nilaiSmtr1 + nilaiSmtr2) / 2
        return HasilNilai(rataNilai)
    }

    private fun retrieveData() {
        viewModelScope.launch (Dispatchers.IO) {
            status.postValue(ApiStatus.LOADING)
            try {
                data.postValue(DosenApi.service.getDosen())
                status.postValue(ApiStatus.SUCCESS)
            } catch (e: Exception) {
                Log.d("MainViewModel", "Failure: ${e.message}")
                status.postValue(ApiStatus.FAILED)
            }
        }
    }

    fun getData(): LiveData<List<Dosen>> = data
    fun getStatus(): LiveData<ApiStatus> = status

    fun scheduleUpdater(app: Application) {
        val request = OneTimeWorkRequestBuilder<UpdateWorker>()
            .setInitialDelay(1, TimeUnit.MINUTES)
            .build()
        WorkManager.getInstance(app).enqueueUniqueWork(
            DosenActivity.CHANNEL_ID,
            ExistingWorkPolicy.REPLACE,
            request
        )
    }
}