package com.psi.thrifter.data.item

import android.graphics.Bitmap

data class Item(
    val Name:String, val Description: String,
    val Shop:String, val Price:String, val Photos: Bitmap){
    override fun toString(): String {
        return "$Name---$Description---$Shop---$Price---$Photos"
    }
}
