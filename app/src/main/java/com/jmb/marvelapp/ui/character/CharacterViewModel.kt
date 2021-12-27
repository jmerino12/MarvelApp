package com.jmb.marvelapp.ui.character

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jmb.domain.aggregates.Character
import com.jmb.marvelapp.ui.common.UiState
import com.jmb.usecase.character.GetCharacters
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(private val getCharacters: GetCharacters) :
    ViewModel() {
    private val _data = MutableLiveData<UiState<List<Character>>>()
    val data: LiveData<UiState<List<Character>>> = _data
    fun getSeries() {
        viewModelScope.launch {
            _data.value = UiState.Loading
            try {
                _data.value = UiState.Success(getCharacters.invoke())
            } catch (e: Exception) {
                _data.value = UiState.Error(e)
            }
        }

    }
}