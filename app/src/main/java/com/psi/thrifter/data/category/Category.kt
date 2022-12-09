package com.psi.thrifter.data.category

import android.graphics.Bitmap

data class Category(val Name:String, val Photo:Bitmap){
    override fun toString(): String {
        return "$Name---$Photo"
    }
}
