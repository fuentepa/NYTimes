package com.paf.nytimes.data.server

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TheArticleDbService {
    @GET("articles")
    fun listArticles(): Call<List<Article>> //TODO: faltan los parametros
}