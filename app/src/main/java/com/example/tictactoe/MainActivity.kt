package com.example.tictactoe

import android.annotation.SuppressLint
import android.app.Dialog
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
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

        var anim = AnimationUtils.loadAnimation(this,R.anim.zoom)
        binding.lnrMain.startAnimation(anim)

        binding.txtReset.setOnClickListener {
            resetGame()
        }

        binding.i1.setOnClickListener {
            c1 = addImage(c1, binding.i1)
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
            var zoomAnim = AnimationUtils.loadAnimation(this,R.anim.zoom2)
            if (check % 2 == 0) {
                i1.setImageResource(round)
                i1.startAnimation(zoomAnim)
                cc = 1

            } else {
                i1.setImageResource(cross)
                i1.startAnimation(zoomAnim)
                cc = 2
            }

            check++
        }
        return cc
    }

    private fun checkWin() {

        if (c1 == c2 && c2 == c3) {
            winGame(c1)
        } else if (c4 == c5 && c5 == c6) {
            winGame(c4)
        } else if (c7 == c8 && c8 == c9) {
            winGame(c7)
        } else if (c1 == c4 && c4 == c7) {
            winGame(c1)
        } else if (c2 == c5 && c5 == c8) {
            winGame(c2)
        } else if (c3 == c6 && c6 == c9) {
            winGame(c3)
        } else if (c1 == c5 && c5 == c9) {
            winGame(c1)
        } else if (c3 == c5 && c5 == c7) {
            winGame(c3)
        }

        if (c1 != 0 && c2 != 0 && c3 != 0 && c4 != 0 && c5 != 0 && c6 != 0 && c7 != 0 && c8 != 0 && c9 != 0) {
            binding.txtReset.visibility = View.VISIBLE
        }

    }

    @SuppressLint("ResourceAsColor")
    private fun winGame(c: Int) {

        var dialog = Dialog(this)
        dialog.setContentView(R.layout.win_dialog)
        dialog.window?.setBackgroundDrawable(ColorDrawable(android.R.color.transparent))
        dialog.setCancelable(false)
        var cardWin = dialog.findViewById<CardView>(R.id.cardWin)
        var imgIcon = dialog.findViewById<ImageView>(R.id.imgIcon)
        var txtReset = dialog.findViewById<TextView>(R.id.txtReset)
        var zoomAnim = AnimationUtils.loadAnimation(this,R.anim.move_up)

        if (c == 1) {
            imgIcon.setImageResource(round)
            dialog.show()
            cardWin.startAnimation(zoomAnim)
        } else if (c == 2) {
            imgIcon.setImageResource(cross)
            dialog.show()
            cardWin.startAnimation(zoomAnim)
        }


        txtReset.setOnClickListener {

            resetGame()
            dialog.dismiss()

        }


    }

    private fun resetGame() {
        c1 = 0
        c2 = 0
        c3 = 0
        c4 = 0
        c5 = 0
        c6 = 0
        c7 = 0
        c8 = 0
        c9 = 0
        check = 0
        binding.i1.setImageResource(0)
        binding.i2.setImageResource(0)
        binding.i3.setImageResource(0)
        binding.i4.setImageResource(0)
        binding.i5.setImageResource(0)
        binding.i6.setImageResource(0)
        binding.i7.setImageResource(0)
        binding.i8.setImageResource(0)
        binding.i9.setImageResource(0)
        binding.txtReset.visibility = View.GONE
    }


}