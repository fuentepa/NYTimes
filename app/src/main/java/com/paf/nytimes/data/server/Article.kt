package com.paf.nytimes.data.server


data class Article(
    val id: Int,
    val url: String,
    val title: String,
    val section: String,
    val publish_date: String,
    val media: String //todo el texto que viene en el nodo 'media' y que habra que parsear para sacar la url de la imagen
    )

