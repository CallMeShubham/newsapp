package com.example.wallmart.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wallmart.R
import com.example.wallmart.models.response.Article
import com.example.wallmart.utils.Constants
import com.nostra13.universalimageloader.core.ImageLoader
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration

/**
 * Adapter class for handling the display of list of headlines
 */
class NewsListAdapter(private val mList: List<Article>, private var context : Context,
                      private val onCardClickListener: OnCardClickListener) :
                      RecyclerView.Adapter<NewsListAdapter.ViewHolder>() {
    private var imageLoader : ImageLoader = ImageLoader.getInstance()
    private val cardClickListener = onCardClickListener

    init {
        imageLoader.init(ImageLoaderConfiguration.createDefault(context))
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.article_layout, parent, false)
        return ViewHolder(view, cardClickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = mList[position]
        imageLoader.displayImage(article.urlToImage, holder.imageView)
        holder.titleText.text = article.title
        holder.descriptionText.text = article.description
        holder.sourceText.text = Constants.source + article.source.name
        holder.datetimeText.text = article.publishedAt
        holder.bindArticle(article)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(itemView: View, onCardClickListener : OnCardClickListener) : RecyclerView.ViewHolder(itemView) {

        private val cardClickListener = onCardClickListener
        val imageView: ImageView = itemView.findViewById(R.id.image_iv)
        val titleText: TextView = itemView.findViewById(R.id.title_tv)
        val descriptionText: TextView = itemView.findViewById(R.id.description_tv)
        val sourceText: TextView = itemView.findViewById(R.id.source_tv)
        val datetimeText: TextView = itemView.findViewById(R.id.date_tv)
        fun bindArticle(article: Article) {
            val click = itemView.setOnClickListener {
                cardClickListener.onCardClick(article)
            }
        }
    }

    /**
     * This interface allows to perform a click on card
     */
    interface OnCardClickListener {
        fun onCardClick(article: Article)
    }
}