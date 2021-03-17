package com.dicoding.githubclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast

class ProfilePage : AppCompatActivity(),View.OnClickListener {
    private lateinit var moreButton: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_page)

        moreButton = findViewById(R.id.more_button)
        moreButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        Toast.makeText(applicationContext,"App under construction", Toast.LENGTH_SHORT).show()
    }
}