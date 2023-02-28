package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import com.example.tictactoe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    var round = R.drawable.emo1
    var cross = R.drawable.emo2
    private val TAG = "MainActivity"
    var check = 0
    var c1 = 0
    var c2 = 0
    var c3 = 0
    var c4 = 0
    var c5 = 0
    var c6 = 0
    var c7 = 0
    var c8 = 0
    var c9 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.i1.setOnClickListener {
            c1 = addImage(c1,binding.i1)
            checkWin()
        }

        binding.i2.setOnClickListener {
            c2 = addImage(c2, binding.i2)
            checkWin()
        }

        binding.i3.setOnClickListener {
            c3 = addImage(c3, binding.i3)
            checkWin()
        }

        binding.i4.setOnClickListener {
            c4 = addImage(c4, binding.i4)
            checkWin()
        }

        binding.i5.setOnClickListener {
            c5 = addImage(c5, binding.i5)
            checkWin()
        }

        binding.i6.setOnClickListener {
            c6 = addImage(c6, binding.i6)
            checkWin()
        }

        binding.i7.setOnClickListener {
            c7 = addImage(c7, binding.i7)
            checkWin()
        }

        binding.i8.setOnClickListener {
            c8 = addImage(c8, binding.i8)
            checkWin()
        }

        binding.i9.setOnClickListener {
            c9 = addImage(c9, binding.i9)
            checkWin()
        }

    }

    private fun addImage(c: Int, i1: ImageView): Int {
        var cc = c
        if (cc == 0) {

            if (check % 2 == 0) {
                i1.setImageResource(round)
                cc = 1

            } else {
                i1.setImageResource(cross)
                cc = 2
            }

            check++
        }
        return cc
    }

    private fun checkWin() {

        if(c1==c2 && c2==c3){
            winGame(c1)
        } else if (c4==c5 && c5==c6) {
            winGame(c4)
        } else if (c7==c8 && c8==c9) {
            winGame(c7)
        } else if (c1==c4 && c4==c7) {
            winGame(c1)
        } else if (c2==c5 && c5==c8) {
            winGame(c2)
        } else if (c3==c6 && c6==c9) {
            winGame(c3)
        } else if (c1==c5 && c5==c9) {
            winGame(c1)
        } else if (c3==c5 && c5==c7) {
            winGame(c3)
        }

    }

    private fun winGame(c: Int) {

        if (c==1) {
            Log.e(TAG, "winGame: WIN ROUND")
        }else if (c==2) {
            Log.e(TAG, "winGame: WIN CROSS")
        }

    }


}