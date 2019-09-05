package com.example.animation_swipview

import android.os.Bundle
import android.util.Log
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.animation_swipview.ui.main.SectionsPagerAdapter

class MainActivity : AppCompatActivity() {
    lateinit var  viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        viewPager = findViewById(R.id.view_pager)



        //*****************
       // viewPager.setPageTransformer(true,DepthPageTransformer())
        viewPager.setPageTransformer(true,ZoomOutPageTransformer())
        //********


        viewPager.adapter = sectionsPagerAdapter

        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
        val fab: FloatingActionButton = findViewById(R.id.fab)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

    }

    override fun onBackPressed() {
        Log.d("clima","viewPager.currentItem=${viewPager.currentItem}")
        if (viewPager.currentItem==0) {
            super.onBackPressed()
        }else{
            viewPager.currentItem=(viewPager.currentItem-1)
        }
    }


}