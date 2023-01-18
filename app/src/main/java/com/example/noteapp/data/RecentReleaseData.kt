package com.example.noteapp.data


class RecentReleaseData : ArrayList<RecentReleaseDataItem>()

data class RecentReleaseDataItem(
    val animeId: String,
    val animeImg: String,
    val animeTitle: String,
    val episodeId: String,
    val episodeNum: String,
    val episodeUrl: String,
    val subOrDub: String
)