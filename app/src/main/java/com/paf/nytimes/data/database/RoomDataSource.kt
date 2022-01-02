package com.paf.nytimes.data.database

import com.paf.nytimes.data.source.LocalDataSource
import com.paf.nytimes.data.toDomainArticle
import com.paf.nytimes.data.toRoomArticle
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.paf.nytimes.domain.Article

class RoomDataSource(db: ArticleDataBase) : LocalDataSource {

    private val articleDao = db.articleDao()

    override suspend fun isEmpty(): Boolean =
        withContext(Dispatchers.IO) { articleDao.count() <= 0 }

    override suspend fun saveArticles(articles: List<Article>) =
        withContext(Dispatchers.IO) { articleDao.insertArticle(articles.map { it.toRoomArticle() }) }

    override suspend fun getArticles() =
        withContext(Dispatchers.IO) { articleDao.getAll().map { it.toDomainArticle() } }

    override suspend fun findById(id: Int) =
        withContext(Dispatchers.IO) { articleDao.findById(id).toDomainArticle() }

}