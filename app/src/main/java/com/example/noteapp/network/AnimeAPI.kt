package com.example.noteapp.network

import com.example.noteapp.data.RecentReleaseDataItem
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimeAPI {
    @GET("/recent-release")
    suspend fun getRecentReleases(@Query("page")page : Int ) : List<RecentReleaseDataItem>
}