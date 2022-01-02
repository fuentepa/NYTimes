package com.paf.nytimes.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Article::class], version = 1)
abstract class ArticleDataBase: RoomDatabase() {
    companion object {
        fun build(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            ArticleDataBase::class.java,
            "article-db"
        ).build()
    }

    abstract fun articleDao(): ArticleDao
}