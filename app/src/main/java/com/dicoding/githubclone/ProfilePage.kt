package com.dicoding.githubclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.Toast

class ProfilePage : AppCompatActivity(),View.OnClickListener {
    private lateinit var moreButton: ImageView
    private lateinit var backToMain: RelativeLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_page)

        moreButton = findViewById(R.id.more_button)
        moreButton.setOnClickListener(this)

        backToMain = findViewById(R.id.back_to_main)
        backToMain.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.more_button -> {
                val myDialogFragment: OptionDialogFragment = OptionDialogFragment()
                myDialogFragment.show(supportFragmentManager,"My Fragment")
            }
            R.id.back_to_main -> {
                finish()
            }
        }
    }
}