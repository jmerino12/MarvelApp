package com.jmb.marvelapp.ui.serie

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jmb.domain.aggregates.Serie
import com.jmb.usecase.serieusecase.GetSeries
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SerieViewModel @Inject constructor(private val getSeries: GetSeries) : ViewModel() {
    private val _data = MutableLiveData<List<Serie>>()
    val data: LiveData<List<Serie>> = _data
    fun getSeries() {
        viewModelScope.launch {
            try {
                _data.value = getSeries.invoke()
            } catch (e: Exception) {
                Log.e("nbvnbv", e.message.toString())
            }
        }

    }
}