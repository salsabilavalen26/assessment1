package org.d3if2092.assessment1

import androidx.lifecycle.ViewModel
import org.d3if2092.assessment1.model.HasilNilai

class MainViewModel : ViewModel() {

    fun rataNilai(nilaiSmtr1: Float, nilaiSmtr2: Float) : HasilNilai {
        val rataNilai = (nilaiSmtr1 + nilaiSmtr2) / 2
        return HasilNilai(rataNilai)
    }

}