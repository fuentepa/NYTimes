package com.paf.nytimes.data.repository

import com.paf.nytimes.data.source.LocalDataSource
import com.paf.nytimes.data.source.RemoteDataSource
import com.paf.nytimes.domain.Article


class ArticlesRepository(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
) {

    suspend fun getArticles(): List<Article> {
        if (localDataSource.isEmpty()) {
            //TODO(Si es vacio entonces pido al servidor y lo que traiga lo guardo en bbdd local)
        }

        return localDataSource.getArticles()
    }

    suspend fun findById(id: Int): Article = localDataSource.findById(id)
}