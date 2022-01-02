package com.paf.nytimes.data

import com.paf.nytimes.data.database.Article as DataBaseArticle
import com.paf.nytimes.data.server.Article as ServerArticle
import com.paf.nytimes.domain.Article


fun Article.toRoomArticle(): DataBaseArticle =
    DataBaseArticle(
        id,
        url,
        title,
        section,
        publish_date,
        imageUrl
    )


fun DataBaseArticle.toDomainArticle(): Article =
    Article(
        id,
        url,
        title,
        section,
        publish_date,
        imageUrl
    )

fun ServerArticle.toDomainArticle(): Article =
    Article(
        id,
        url,
        title,
        section,
        publish_date,
        media2url(media)
    )

private fun media2url(media: String): String{
    //TODO parsear media para sacar el image url
    return "aun sin parsear"
}