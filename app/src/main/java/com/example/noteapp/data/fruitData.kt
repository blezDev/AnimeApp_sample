package com.example.noteapp.data

data class fruitData(
    val color: String,
    val fruit: String,
    val size: String
)class FruitList : ArrayList<FruitListItem>()

data class FruitListItem(
    val color: String,
    val value: String
)