package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import com.example.tictactoe.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lnrMain.startAnimation(AnimationUtils.loadAnimation(this,R.anim.flip))


        Handler().postDelayed({
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        },2000)

    }
}