package com.alisabet.imageslider

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import me.relex.circleindicator.CircleIndicator
import android.support.v4.view.ViewPager
import android.view.View
import java.util.*

//1.add 'me.relex:circleindicator:1.2.2@aar' library to project

class ImageSlider : AppCompatActivity() {

    private var mPager: ViewPager? = null
    private var currentPage = 0
    private val XMEN = arrayOf<Int>(R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5)
    private val XMENArray = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_slider)
        init()
    }

    private fun init() {
        for (i in XMEN.indices)
            XMENArray.add(XMEN[i])

        mPager = findViewById<ViewPager>(R.id.pager)
        mPager!!.adapter = MyAdapter(this, XMENArray)
        val indicator = findViewById<CircleIndicator>(R.id.indicator)
        indicator.setViewPager(mPager)

        // Auto start of viewpager
        val handler = Handler()
        val Update = Runnable {
            if (currentPage == XMEN.size) {
                currentPage = 0
            }
            mPager!!.setCurrentItem(currentPage++, true)
        }
        val swipeTimer = Timer()
        swipeTimer.schedule(object : TimerTask() {
            override fun run() {
                handler.post(Update)
            }
        }, 2500, 2500)
    }
}
