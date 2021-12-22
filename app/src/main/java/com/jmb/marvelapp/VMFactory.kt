package com.jmb.marvelapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jmb.usecase.serieusecase.GetSeries

class VMFactory(private val getSeries: GetSeries) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(GetSeries::class.java).newInstance(getSeries)
    }
}