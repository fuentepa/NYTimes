package com.paf.nytimes.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Articles")
data class Article(
    @PrimaryKey val id: Int, //no necesita ser autogenerada pues nos viene ya un id unico del servidor por cada articulo
    val url: String,
    val title: String,
    val section: String,
    val publish_date: String,
    val imageUrl: String
)
