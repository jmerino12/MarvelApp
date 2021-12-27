package com.jmb.marvelapp.ui.characterdetail

import androidx.lifecycle.*
import com.jmb.domain.aggregates.Character
import com.jmb.marvelapp.ui.common.UiState
import com.jmb.usecase.character.FindCharacter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val findCharacter: FindCharacter
) : ViewModel() {
    private val _data = MutableLiveData<UiState<Character>>()
    val data: LiveData<UiState<Character>> = _data


    fun getSeries() {
        viewModelScope.launch {
            _data.value = UiState.Loading
            try {
                _data.value = UiState.Success(findCharacter.invoke(savedStateHandle["id"]!!))
            } catch (e: Exception) {
                _data.value = UiState.Error(e)
            }
        }

    }
}