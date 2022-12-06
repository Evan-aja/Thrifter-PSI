package com.psi.thrifter.data.user

data class User(val Username:String,val Password:String){
    override fun toString(): String {
        return Username
    }
}
