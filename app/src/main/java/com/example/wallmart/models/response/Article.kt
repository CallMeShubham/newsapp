package com.example.wallmart.models.response

/**
 * domain class for holding the article details
 */
data class Article(var source: NewsSource, var title : String, var description : String,
var url : String, var urlToImage : String, var publishedAt : String)

/**
 * domain class for holding article source
 */
data class NewsSource(var id : String, var name: String)