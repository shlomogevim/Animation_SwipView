package com.example.animation_swipview

import android.view.View
import androidx.viewpager.widget.ViewPager
import androidx.core.view.ViewCompat.setAlpha
import androidx.core.view.ViewCompat.setScaleY
import androidx.core.view.ViewCompat.setScaleX
import androidx.core.view.ViewCompat.setTranslationX
import android.opengl.ETC1.getWidth



class DepthPageTransformer :ViewPager.PageTransformer {
    private val MIN_SCALE = 0.75f

    override fun transformPage(view: View, position: Float) {

        val pageWidth = view.getWidth()

        if (position < -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.


            view.setAlpha(0f)

        } else if (position <= 0) { // [-1,0]
            // Use the default slide transition when moving to the left page
            view.setAlpha(1f)
            view.setTranslationX(0f)
            view.setScaleX(1f)
            view.setScaleY(1f)

        } else if (position <= 1) { // (0,1]
            // Fade the page out.
            view.setAlpha(1 - position)

            // Counteract the default slide transition
            view.setTranslationX(pageWidth * -position)

            // Scale the page down (between MIN_SCALE and 1)
            val scaleFactor = MIN_SCALE + (1 - MIN_SCALE) * (1 - Math.abs(position))
            view.setScaleX(scaleFactor)
            view.setScaleY(scaleFactor)

        } else { // (1,+Infinity]
            // This page is way off-screen to the right.
            view.setAlpha(0f)
        }

    }
}