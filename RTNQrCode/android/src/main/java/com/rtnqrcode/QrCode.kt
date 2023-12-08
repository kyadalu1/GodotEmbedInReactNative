package com.rtnqrcode

import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.FragmentActivity
import com.facebook.react.bridge.ReactContext
import org.godotengine.godot.GodotFragment


class QrCode(context: Context) : LinearLayout(context) {

    private val frameLayout: FrameLayout

    init {
        layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        frameLayout = FrameLayout(context)
        frameLayout.id = View.generateViewId()


        addView(frameLayout)

        frameLayout.apply {
            frameLayout.layoutParams.height = 300

            val fragmentTransaction = ((context as ReactContext).currentActivity as AppCompatActivity).supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(frameLayout.id, GodotFragment())
            fragmentTransaction.commit()
        }
    }

}