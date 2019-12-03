package com.example.decaclassroom


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * A simple [Fragment] subclass.
 */
class ArticlesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_articles, container, false)

        val paper1 = Article("21, oct 2019","Electronics defaults", "Ama Benedict")
        val paper2 = Article("21, oct 2019","Electronics defaults", "Ama Benedict")
        val paper3 = Article("21, oct 2019","Electronics defaults", "Ama Benedict")
        val paper4 = Article("21, oct 2019","Electronics defaults", "Ama Benedict")
        val paper5 = Article("21, oct 2019","Electronics defaults", "Ama Benedict")
        val paper6 = Article("21, oct 2019","Electronics defaults", "Ama Benedict")
        val paper7 = Article("21, oct 2019","Electronics defaults", "Ama Benedict")
        val paper8 = Article("21, oct 2019","Electronics defaults", "Ama Benedict")
        val paper9 = Article("21, oct 2019","Electronics defaults", "Ama Benedict")
        val paper10 = Article("21, oct 2019","Electronics defaults", "Ama Benedict")

        var articleList =  arrayListOf<Article>()

        articleList.add(paper1)
        articleList.add(paper2)
        articleList.add(paper3)
        articleList.add(paper4)
        articleList.add(paper5)
        articleList.add(paper6)
        articleList.add(paper7)
        articleList.add(paper8)
        articleList.add(paper9)
        articleList.add(paper10)


        var recyclerView = view.findViewById<RecyclerView>(R.id.articleRecycler)
        recyclerView.layoutManager = LinearLayoutManager(this.activity!!.applicationContext)
        recyclerView.adapter=ArticleAdapter(articleList)

        return view
    }


}
