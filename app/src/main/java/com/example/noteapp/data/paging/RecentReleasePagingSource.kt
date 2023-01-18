package com.example.noteapp.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.noteapp.data.RecentReleaseDataItem
import com.example.noteapp.network.AnimeAPI
import javax.inject.Inject

class RecentReleasePagingSource(val animeAPI: AnimeAPI) : PagingSource<Int,RecentReleaseDataItem>() {


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, RecentReleaseDataItem> {

     try {
         val position = params.key ?: 1
         val response = animeAPI.getRecentReleases(position)
         return LoadResult.Page(
             data = response,
             prevKey = if (position ==1) null else position - 1,
             nextKey = position +1
         )
     }catch (e : java.lang.Exception){
        return LoadResult.Error(e)
     }
    }
    override fun getRefreshKey(state: PagingState<Int, RecentReleaseDataItem>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }
}