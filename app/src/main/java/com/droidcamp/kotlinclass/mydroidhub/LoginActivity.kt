package com.droidcamp.kotlinclass.mydroidhub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.EditText
import android.widget.Toast
import com.droidcamp.kotlinclass.mydroidhub.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var emailAddress: EditText
    private lateinit var password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_MyDroidHub)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        // Initialize Firebase Auth
        auth = Firebase.auth

        binding.btnSignUp.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
            finish()
        }
        emailAddress = binding.emailAddressEt
        password = binding.passwordEt

        binding.btnLogin.setOnClickListener {
            doLogin()
        }

    }

    private fun doLogin() {
        if (emailAddress.text.isEmpty()) {
            emailAddress.error = "Please enter your email address"
            emailAddress.requestFocus()
            return
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(emailAddress.text.toString()).matches()) {
            emailAddress.error = "not a valid email"
            emailAddress.requestFocus()
            return
        }

        if (password.text.isEmpty()) {
            password.error = "Please enter your password"
            password.requestFocus()
            return
        }

        auth.signInWithEmailAndPassword(emailAddress.text.toString(), password.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val user = auth.currentUser
                        updateUI(user)
                    } else {

                        updateUI(null)
                    }

                }


    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }

    private fun updateUI(currentUser: FirebaseUser?) {

        if (currentUser != null) {
            if (currentUser.isEmailVerified) {
                startActivity(Intent(this, FilesActivity::class.java))
                finish()
            } else {
                Toast.makeText(
                        baseContext, "Please verify your email address.",
                        Toast.LENGTH_SHORT
                ).show()
            }
        } else {
            Toast.makeText(baseContext, "Login failed.",
                    Toast.LENGTH_SHORT
            ).show()
        }
    }
}