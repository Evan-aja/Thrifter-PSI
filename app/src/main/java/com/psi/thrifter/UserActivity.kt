package com.psi.thrifter

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.psi.thrifter.controller.InjectorUtils
import com.psi.thrifter.controller.user.UserViewModel
import com.psi.thrifter.data.user.User

class UserActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)
        initializeUi()
    }

    private fun initializeUi() {
        val factory = InjectorUtils.provideUsersViewModelFactory()
        val viewModel = ViewModelProvider(this@UserActivity, factory)[UserViewModel::class.java]
        val textView = findViewById<TextView>(R.id.textView)
        viewModel.getUsers().observe(this, Observer { users ->
            val stringBuilder = StringBuilder()
            users.forEach { user ->
                stringBuilder.append("$user\n\n")
            }
            textView.text = stringBuilder.toString()
        })
        val button=findViewById<Button>(R.id.button)
        val name=findViewById<TextView>(R.id.editTextTextPersonName)
        val password=findViewById<TextView>(R.id.editTextTextPassword)
        button.setOnClickListener {
            val user = User(name.text.toString(), password.text.toString())
            viewModel.addUser(user)
            name.text = ""
            password.text = ""
        }
    }
}