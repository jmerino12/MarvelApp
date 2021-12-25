package com.jmb.marvelapp.ui.character

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jmb.domain.aggregates.Character
import com.jmb.usecase.character.GetCharacters
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


class CharacterViewModel constructor(private val getCharacters: GetCharacters) :
    ViewModel() {
    private val _data = MutableLiveData<List<Character>>()
    val data: LiveData<List<Character>> = _data
    fun getSeries() {
        viewModelScope.launch {
            try {
                _data.value = getCharacters.invoke()
            } catch (e: Exception) {
                Log.e("nbvnbv", e.message.toString())
            }
        }

    }
}