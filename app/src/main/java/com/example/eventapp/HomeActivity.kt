package com.example.eventapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.eventapp.R
import android.view.View

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }
    fun goBack(view: View) {
        onBackPressed()
    }

}
