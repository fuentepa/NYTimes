package com.paf.nytimes.data.source


import com.paf.nytimes.domain.Article

interface RemoteDataSource {
    suspend fun getArticles(): List<Article> //TODO habra que ver los paremetros que necesita segun la busqueda
}