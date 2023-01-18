package com.example.noteapp.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.noteapp.data.paging.RecentReleasePagingSource
import com.example.noteapp.network.AnimeAPI
import javax.inject.Inject

class AnimeRepository @Inject constructor(val animeAPI: AnimeAPI) {
    fun getRecentRelease() = Pager(
        config = PagingConfig(20),
        pagingSourceFactory = {RecentReleasePagingSource(animeAPI)})

}