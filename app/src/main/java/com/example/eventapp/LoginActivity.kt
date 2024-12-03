package com.example.eventapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat.startActivity
import com.example.eventapp.R
import com.example.eventapp.NewAccount


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun goToHome(view: View) {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
    fun goToNewAccount(view: View) {
        val intent = Intent(this, NewAccount::class.java)
        startActivity(intent)
    }
    fun goBack(view: View) {
        onBackPressed()
    }



}
