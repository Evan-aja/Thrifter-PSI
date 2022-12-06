package com.psi.thrifter.data.category

data class Category(val Name:String, val Photo:String){
    override fun toString(): String {
        return "$Name---$Photo"
    }
}
