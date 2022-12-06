package com.psi.thrifter.data.item

data class Item(val Name:String, val Description:String,val Shop:String, val Price:String, val Photos:String){
    override fun toString(): String {
        return "$Name---$Description---$Shop---$Price---$Photos"
    }
}
