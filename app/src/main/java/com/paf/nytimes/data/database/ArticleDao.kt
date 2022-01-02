package com.paf.nytimes.data.database

import androidx.room.*

@Dao
interface ArticleDao {
    @Query("SELECT * FROM Articles")
    fun getAll(): List<Article>

    @Query("SELECT * FROM Articles WHERE id = :id")
    fun findById(id: Int): Article

    @Query("SELECT COUNT(id) FROM Articles")
    fun count(): Int

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertArticle(article: List<Article>)
}