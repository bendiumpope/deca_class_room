package com.example.decaclassroom

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ArticleAdapter(var articles: ArrayList<Article>): RecyclerView.Adapter<ArticleAdapter.ContactViewHolder>() {

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): ContactViewHolder {

            val view = LayoutInflater.from(parent.context).inflate(R.layout.article_list, parent, false)

            return ContactViewHolder(view)
        }

        override fun getItemCount(): Int {
            return articles.size
        }

        override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {

            val article = articles.get(position)
            holder.dateText.text= article.date
            holder.titleText.text=article.articleTitle
            holder.authorText.text=article.author

        }

        class ContactViewHolder(view: View): RecyclerView.ViewHolder(view){

             var dateText : TextView
             var titleText:TextView
             var authorText:TextView

            init{
                dateText=view.findViewById(R.id.date_text)
                titleText=view.findViewById(R.id.article_title_text)
                authorText=view.findViewById(R.id.author)
            }
        }
}