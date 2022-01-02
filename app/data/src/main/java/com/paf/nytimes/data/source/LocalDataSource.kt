package com.paf.nytimes.data.source

import com.paf.nytimes.domain.Article

interface LocalDataSource {
    suspend fun isEmpty(): Boolean
    suspend fun saveArticles(articles: List<Article>)
    suspend fun getArticles(): List<Article>
    suspend fun findById(id: Int): Article
}