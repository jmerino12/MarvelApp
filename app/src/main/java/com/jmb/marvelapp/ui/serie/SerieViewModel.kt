package com.jmb.marvelapp.ui.serie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jmb.domain.aggregates.Serie
import com.jmb.marvelapp.ui.common.UiState
import com.jmb.usecase.serie.GetSeries
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SerieViewModel @Inject constructor(private val getSeries: GetSeries) : ViewModel() {
    private val _data = MutableLiveData<UiState<List<Serie>>>()
    val data: LiveData<UiState<List<Serie>>> = _data

    fun getSeries() {
        viewModelScope.launch {
            _data.value = UiState.Loading
            try {
                _data.value = UiState.Success(getSeries.invoke())
            } catch (e: Exception) {
                _data.value = UiState.Error(e)
            }
        }
    }

}