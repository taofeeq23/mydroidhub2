package com.droidcamp.kotlinclass.mydroidhub

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.droidcamp.kotlinclass.mydroidhub.databinding.ActivityUploadBinding
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import dmax.dialog.SpotsDialog

class UploadActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUploadBinding
    lateinit var alertDialog:android.app.AlertDialog
    lateinit var storageReference:StorageReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_MyDroidHub)
        binding = ActivityUploadBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //Initiatlize alert dialog
        alertDialog = SpotsDialog.Builder().setContext(this).build();
        storageReference = FirebaseStorage.getInstance().getReference("image_upload"); //file name

        //Eveng

        binding.btnUpload.setOnClickListener {  }


    }
}