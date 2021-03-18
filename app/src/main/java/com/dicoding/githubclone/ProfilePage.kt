package com.dicoding.githubclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast

class ProfilePage : AppCompatActivity(),View.OnClickListener {
    private lateinit var moreButton: ImageView
    private lateinit var backToMain: RelativeLayout
    private lateinit var followButton: RelativeLayout

    private lateinit var profilePictureDetail: ImageView
    private lateinit var fullNameDetail: TextView
    private lateinit var usernameDetail: TextView
    private lateinit var descriptionDetail: TextView
    private lateinit var bioDetail: TextView
    private lateinit var companyDetail: TextView
    private lateinit var locationDetail: TextView
    private lateinit var linkDetail: TextView
    private lateinit var followStatsDetail: TextView

    companion object {
        const val EXTRA_FULL_NAME = "extra_full_name"
        const val EXTRA_USERNAME = "extra_username"
        const val EXTRA_BIO = "extra_bio"
        const val EXTRA_PICTURE = "extra_picture"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_page)

        val profilePicture = intent.getIntExtra(EXTRA_PICTURE,0)
        val fullName = intent.getStringExtra(EXTRA_FULL_NAME)
        val username = intent.getStringExtra(EXTRA_USERNAME)
        val bio = intent.getStringExtra(EXTRA_BIO)

        profilePictureDetail = findViewById(R.id.profile_picture_detail)
        profilePictureDetail.setImageResource(profilePicture)
        fullNameDetail = findViewById(R.id.full_name_detail)
        fullNameDetail.text = fullName.toString()
        usernameDetail = findViewById(R.id.username_detail)
        usernameDetail.text = username.toString()
        bioDetail = findViewById(R.id.bio_detail)
        bioDetail.text = bio.toString()

        moreButton = findViewById(R.id.more_button)
        moreButton.setOnClickListener(this)
        backToMain = findViewById(R.id.back_to_main)
        backToMain.setOnClickListener(this)
        followButton = findViewById(R.id.following_button)
        followButton.setOnClickListener(this)


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
            R.id.following_button -> {
                Toast.makeText(applicationContext,"Unable to change following status.",Toast.LENGTH_SHORT).show()
            }
        }
    }
}