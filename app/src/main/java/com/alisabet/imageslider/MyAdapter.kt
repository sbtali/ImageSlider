package com.alisabet.imageslider

import android.content.Context
import android.view.ViewGroup
import java.nio.file.Files.size
import android.view.LayoutInflater
import android.support.v4.view.PagerAdapter
import android.view.View
import android.widget.ImageView


/**
 * Created by Ali on 4/11/2018.
 */
class MyAdapter(private val context: Context, private val images: ArrayList<Int>) : PagerAdapter() {

    private var inflater: LayoutInflater

    init {
        inflater = LayoutInflater.from(context)
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun getCount(): Int {
        return images.size
    }

    override fun instantiateItem(view: ViewGroup, position: Int): Any {
        val myImageLayout = inflater.inflate(R.layout.slide, view, false)
        val myImage = myImageLayout.findViewById(R.id.image) as ImageView
        myImage.setImageResource(images[position])
        view.addView(myImageLayout, 0)
        return myImageLayout
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view.equals(`object`)
    }
}