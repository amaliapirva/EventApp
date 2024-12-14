package com.example.eventapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class NewAccount : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_newaccount)

        auth = FirebaseAuth.getInstance()

        val nameEditText = findViewById<EditText>(R.id.editTextName)
        val emailEditText = findViewById<EditText>(R.id.editTextEmail)
        val passwordEditText = findViewById<EditText>(R.id.editTextPassword)
        val confirmPasswordEditText = findViewById<EditText>(R.id.editTextConfirmPassword)
        val createAccount = findViewById<Button>(R.id.createAccount)

        createAccount.setOnClickListener {
            val name = nameEditText.text.toString().trim()
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()
            val confirmPassword = confirmPasswordEditText.text.toString().trim()

            if (validateInputs(name, email, password, confirmPassword)) {
                createAccount(email,password)
            }
        }
        fun goBack(view: View) {
            onBackPressed()
        }
    }

    private fun validateInputs(name: String, email: String, password: String, confirmPassword: String): Boolean {
        if (name.isEmpty()) {
            showToast("Please enter your name")
            return false
        }
        if (email.isEmpty()) {
            showToast("Please enter your email")
            return false
        }
        if (password.isEmpty()) {
            showToast("Please enter your password")
            return false
        }
        if (confirmPassword.isEmpty()) {
            showToast("Please confirm your password")
            return false
        }
        if (password != confirmPassword) {
            showToast("Passwords do not match")
            return false
        }
        return true
    }


    private fun createAccount(email: String,password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {

                    showToast("Account created successfully!")
                } else {

                    val exceptionMessage = task.exception?.message ?: "Registration failed"
                    showToast(exceptionMessage)
                }
            }
    }


    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}
