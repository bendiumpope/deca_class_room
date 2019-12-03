package com.example.decaclassroom


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import com.example.decaclassroom.R.id.*
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.decaclassroom.R.id.viewPager2


class HomeFragment : Fragment() {

    companion object {
        fun newInstance():HomeFragment{
            return HomeFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val viewPager2=view.findViewById<ViewPager2>(R.id.viewPager2)
        val books = arrayListOf(
            Book("Your Recording"),
            Book("Film"),
            Book("Series"),
            Book("Kids"),
            Book("Sport")
        )

        with(viewPager2) {
            clipToPadding = false
            clipChildren = false
            offscreenPageLimit = 3
        }

        val pageMarginPx = resources.getDimensionPixelOffset(R.dimen.pageMargin)
        val offsetPx = resources.getDimensionPixelOffset(R.dimen.offset)
        viewPager2.setPageTransformer { page, position ->
            val viewPager = page.parent.parent as ViewPager2
            val offset = position * -(2 * offsetPx + pageMarginPx)
            if (viewPager.orientation == ViewPager2.ORIENTATION_HORIZONTAL) {
                if (ViewCompat.getLayoutDirection(viewPager) == ViewCompat.LAYOUT_DIRECTION_RTL) {
                    page.translationX = -offset
                } else {
                    page.translationX = offset
                }
            } else {
                page.translationY = offset
            }
        }


        viewPager2.adapter = ViewAdapter(books)


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


        var recyclerView = view.findViewById<RecyclerView>(homeRecycler)
        recyclerView.layoutManager = LinearLayoutManager(this.activity!!.applicationContext)
        recyclerView.adapter=ArticleAdapter(articleList)

        return view

    }

}