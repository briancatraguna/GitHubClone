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
                val mFragmentManager = supportFragmentManager
                val optionDialogFragment = OptionDialogFragment()
                val fragment =
                    mFragmentManager.findFragmentByTag(OptionDialogFragment::class.java.simpleName)
                if (fragment !is OptionDialogFragment) {
                    mFragmentManager
                        .beginTransaction()
                        .add(R.id.frame_container, optionDialogFragment, OptionDialogFragment::class.java.simpleName)
                        .commit()
                }
            }
            R.id.back_to_main -> {
                val backToMainIntent: Intent = Intent(this,MainActivity::class.java)
                startActivity(backToMainIntent)
            }
        }
    }
}