package com.example.noteapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.noteapp.repository.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.distinctUntilChanged
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor (val animeRepository: AnimeRepository) : ViewModel() {
    val list = animeRepository.getRecentRelease().flow.distinctUntilChanged().cachedIn(viewModelScope)


}