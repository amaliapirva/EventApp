package com.example.eventapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.example.eventapp.R
import com.example.eventapp.NewAccount
import com.google.firebase.auth.FirebaseAuth


class LoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()

        val emailInput: EditText = findViewById(R.id.emailInput)
        val passwordInput: EditText = findViewById(R.id.passwordInput)
        val loginButton: Button = findViewById(R.id.loginButton)

        loginButton.setOnClickListener {
            val email = emailInput.text.toString()
            val password = passwordInput.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                loginUser(email, password)
            } else {
                Toast.makeText(this, "Completează toate câmpurile!", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun loginUser(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {

                    Toast.makeText(this, "Autentificare reușită!", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {

                    Toast.makeText(this, "Autentificare eșuată: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
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

