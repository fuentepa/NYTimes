package com.paf.nytimes.domain

data class Article(
    val id: Int,
    val url: String,
    val title: String,
    val section: String,
    val publish_date: String,
    val imageUrl: String
)