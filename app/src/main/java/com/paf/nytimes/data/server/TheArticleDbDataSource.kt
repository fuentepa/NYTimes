package com.paf.nytimes.data.server



import com.paf.nytimes.data.source.RemoteDataSource



class TheArticleDbDataSource(private val theArticleDb: TheArticleDb) : RemoteDataSource {

    override suspend fun getArticles(): List<com.paf.nytimes.domain.Article> {
        TODO("aqui consultamos y convertimos a objetos nuestos cada articulo")
    }
}


