package com.jmb.marvelapp

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jmb.usecase.serieusecase.GetSeries
import kotlinx.coroutines.launch

class SerieViewModel(private val getSeries: GetSeries) : ViewModel() {
    fun getSeries() {
        try {
            viewModelScope.launch {
                getSeries.invoke()
            }
        } catch (e: Exception) {
            Log.e("error", e.message.toString())
        }

    }
}