package com.ugo.datplace

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView

class SplashActivity : AppCompatActivity() {
    lateinit var backgroundImage: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // This is used to hide the status bar and make
        // the splash screen as a full screen activity.
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        // HERE WE ARE TAKING THE REFERENCE OF OUR IMAGE
        // SO THAT WE CAN PERFORM ANIMATION USING THAT IMAGE
        backgroundImage = findViewById(R.id.SplashScreenImage)

        val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 2f)
        val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 2f)

//        val slideAnimation = AnimationUtils.loadAnimation(this, R.anim.side_slide)
//        backgroundImage.startAnimation(slideAnimation)
        val slideAnimator = ObjectAnimator.ofFloat(backgroundImage, View.TRANSLATION_X, 200f)
        slideAnimator.repeatCount = 1
        slideAnimator.duration = 2000
        slideAnimator.repeatMode = ObjectAnimator.REVERSE


//        val animator = ObjectAnimator.ofPropertyValuesHolder(backgroundImage, scaleX, scaleY)
//        animator.repeatCount = 1
//        animator.repeatMode = ObjectAnimator.REVERSE

        val animator = ObjectAnimator.ofFloat(backgroundImage, View.ROTATION, -360f, 0f)


        animator.duration = 1000
//        animator.start()

        val set = AnimatorSet()
        set.playSequentially(slideAnimator, animator)
        set.start()

        // we used the postDelayed(Runnable, time) method
        // to send a message with a delayed time.
        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 6000) // 6000 is the delayed time in milliseconds.
    }

}