package com.example.wallmart.models.response

/**
 * domain class for holding the list of news headlines
 */
data class News(
    var status: String,
    var totalResult: Int,
    var listOfArticles: List<ArticleList>
)