package com.example.tictactoe

import android.app.Dialog
import android.content.Context
import android.content.res.Configuration
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.example.tictactoe.R.drawable.*
import xyz.teamgravity.imageradiobutton.GravityImageRadioButton
import xyz.teamgravity.imageradiobutton.GravityRadioGroup


class ImageSelector {

    companion object {

        var imgList = arrayOf(
            emo1,
            emo2,
            emo3,
            emo4,
            emo5,
            emo6,
            emo7,
            emo8,
            emo9,
            emo10,
            emo11,
            emo12,
            emo13,
            emo14,
            emo15,
            emo16,
            emo17,
            emo18,
            emo19,
            emo20,
            emo21,
            emo22,
            emo23,
            emo24,
            emo25,
            emo26,
            emo27,
            emo28,
            emo29,
            emo30,
            emo31,
            emo32,
            emo33,
            emo34,
            emo35,
            emo36,
            emo37,
            emo38,
            emo39,
            emo40,
            emo41,
            emo42,
            emo43,
            emo44,
            emo45,
            emo46,
            emo47,
            emo48
        )

        fun imageSelectorDialog(context: Context) {

            var theme = android.R.style.Theme_Light_NoTitleBar_Fullscreen
            when (context.resources?.configuration?.uiMode?.and(Configuration.UI_MODE_NIGHT_MASK)) {
                Configuration.UI_MODE_NIGHT_YES -> {
                    theme = android.R.style.Theme_Black_NoTitleBar_Fullscreen
                }
                Configuration.UI_MODE_NIGHT_NO -> {
                    theme = android.R.style.Theme_Light_NoTitleBar_Fullscreen
                }
                Configuration.UI_MODE_NIGHT_UNDEFINED -> {
                    Toast.makeText(context, "Other", Toast.LENGTH_SHORT).show()
                }
            }

            var dialog = Dialog(context, theme)
            dialog.setContentView(R.layout.image_selector_dialog)

            var rgPlayer1 = dialog.findViewById<GravityRadioGroup>(R.id.rgPlayer1)
            var rgPlayer2 = dialog.findViewById<GravityRadioGroup>(R.id.rgPlayer2)
            var cardSubmit = dialog.findViewById<CardView>(R.id.cardSubmit)

            cardSubmit.setOnClickListener {

                var rbBtn1 = dialog.findViewById<GravityImageRadioButton>(rgPlayer1.checkedRadioButtonId())
                var rbBtn2 = dialog.findViewById<GravityImageRadioButton>(rgPlayer2.checkedRadioButtonId())
                MainActivity.round = imgList.get(rbBtn1.text().toInt())
                MainActivity.cross = imgList.get(rbBtn2.text().toInt())
                dialog.dismiss()
            }

            rgPlayer1.removeAllViews()
            rgPlayer2.removeAllViews()
            setPlayer(context, rgPlayer1, imgList)
            setPlayer(context, rgPlayer2, imgList)

            dialog.show()
        }

        private fun setPlayer(
            context: Context,
            rgPlayer2: GravityRadioGroup,
            list:Array<Int>
        ) {
            for (pos in 0..list.size-1) {

                val btnShow = GravityImageRadioButton(context)
                btnShow.setLayoutParams(
                    LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                )
                btnShow.setImageResource(list.get(pos))
                btnShow.setText(pos.toString())

                rgPlayer2.addView(btnShow)
                //                rgPlayer2.addView(btnShow)
            }
        }

    }

}