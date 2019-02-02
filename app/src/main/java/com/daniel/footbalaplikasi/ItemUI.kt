package com.daniel.footbalaplikasi

import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import org.jetbrains.anko.*

class ItemUI : AnkoComponent<ViewGroup> {
    companion object {
        val CLUB_IMAGE = 1
        val CLUB_NAME = 2
    }
    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        verticalLayout {
            orientation = LinearLayout.HORIZONTAL
            padding = dip(16)

            imageView{
                id = CLUB_IMAGE
            }.lparams(width = 50, height = 50)

            textView {
                id = CLUB_NAME
            }.lparams(wrapContent, wrapContent){
                gravity = Gravity.CENTER_VERTICAL
                margin = dip(10)
            }
        }
    }

}