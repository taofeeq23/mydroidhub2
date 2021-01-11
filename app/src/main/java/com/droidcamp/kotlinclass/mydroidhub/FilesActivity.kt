package com.droidcamp.kotlinclass.mydroidhub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.droidcamp.kotlinclass.mydroidhub.databinding.ActivityFilesBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class FilesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFilesBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_MyDroidHub)
        binding = ActivityFilesBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        auth = Firebase.auth

//        binding.btnLogout.setOnClickListener {
//            auth.signOut()
//            startActivity(Intent(this, LoginActivity::class.java))
//            finish()
//        }



    }
}