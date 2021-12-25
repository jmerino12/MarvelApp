package com.jmb.marvelapp.ui.characterdetail

import android.util.Log
import androidx.lifecycle.*
import com.jmb.domain.aggregates.Character
import com.jmb.usecase.character.FindCharacter
import dagger.assisted.Assisted
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val findCharacter: FindCharacter
) : ViewModel() {
    private val _data = MutableLiveData<Character>()
    val data: LiveData<Character> = _data


    fun getSeries() {
        viewModelScope.launch {
            try {
                _data.value = findCharacter.invoke(savedStateHandle["id"]!!)
            } catch (e: Exception) {
                Log.e("nbvnbv", e.message.toString())
            }
        }

    }
}