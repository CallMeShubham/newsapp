package com.example.wallmart.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wallmart.R
import com.example.wallmart.models.response.Article
import com.nostra13.universalimageloader.core.ImageLoader

/**
 * Adapter class for handling the display of list of headlines
 */
class NewsListAdapter(private val mList: List<Article>) : RecyclerView.Adapter<NewsListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.article_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = mList[position]
        ImageLoader.getInstance().displayImage(article.urlToImage, holder.imageView)
        holder.titleText.text = article.title
        holder.descriptionText.text = article.description
        holder.sourceText.text = article.source.name
        holder.datetimeText.text = article.publishedAt
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.image_iv)
        val titleText: TextView = itemView.findViewById(R.id.title_tv)
        val descriptionText: TextView = itemView.findViewById(R.id.description_tv)
        val sourceText: TextView = itemView.findViewById(R.id.source_tv)
        val datetimeText: TextView = itemView.findViewById(R.id.date_tv)
    }
}