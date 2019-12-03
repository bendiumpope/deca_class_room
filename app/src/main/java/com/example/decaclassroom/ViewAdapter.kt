package com.example.decaclassroom

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView



class ViewAdapter(var book: ArrayList<Book>): RecyclerView.Adapter<ViewAdapter.BookViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BookViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.book_view, parent, false)

        return BookViewHolder(view)
    }

    override fun getItemCount(): Int {
        return book.size
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {

        val books = book.get(position)
        holder.namText.text= books.bookName


    }

    class BookViewHolder(view: View): RecyclerView.ViewHolder(view){

        var namText : TextView


        init{
            namText=view.findViewById(R.id.texname)
        }
    }
}