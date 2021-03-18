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

    private lateinit var repoPicture: ImageView
    private lateinit var repoUsername: TextView
    private lateinit var repositoryNameTextView: TextView
    private lateinit var repositoryDescriptionTextView: TextView
    private lateinit var numStarsTextView: TextView
    private lateinit var programmingLanguageTextView: TextView
    private lateinit var programmingLanguageVector: ImageView

    private lateinit var repoNumber: TextView
    private lateinit var starredNumber: TextView
    private lateinit var organizationNumber: TextView

    companion object {
        const val EXTRA_PROFILE = "extra_profile"
        const val EXTRA_PICTURE = "extra_picture"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_page)

        val profileData = intent.getParcelableExtra<Profiles>(EXTRA_PROFILE) as Profiles
        val pictureData = intent.getIntExtra(EXTRA_PICTURE,0)

        profilePictureDetail = findViewById(R.id.profile_picture_detail)
        profilePictureDetail.setImageResource(pictureData)
        fullNameDetail = findViewById(R.id.full_name_detail)
        fullNameDetail.text = profileData.fullName.toString()
        usernameDetail = findViewById(R.id.username_detail)
        usernameDetail.text = profileData.username.toString()
        bioDetail = findViewById(R.id.bio_detail)
        bioDetail.text = profileData.bio.toString()

        moreButton = findViewById(R.id.more_button)
        moreButton.setOnClickListener(this)
        backToMain = findViewById(R.id.back_to_main)
        backToMain.setOnClickListener(this)
        followButton = findViewById(R.id.following_button)
        followButton.setOnClickListener(this)

        val descDetail: String? = ProfileDetailsObject.descriptionDetail[profileData.username]
        descriptionDetail = findViewById(R.id.description_detail)
        descriptionDetail.text = descDetail
        val compDetail: String? = ProfileDetailsObject.companyDetail[profileData.username]
        companyDetail = findViewById(R.id.company_detail)
        companyDetail.text = compDetail
        val locDetail: String? = ProfileDetailsObject.locationDetail[profileData.username]
        locationDetail = findViewById(R.id.location_detail)
        locationDetail.text = locDetail
        val lkDetail: String? = ProfileDetailsObject.linkDetail[profileData.username]
        linkDetail = findViewById(R.id.link_detail)
        linkDetail.text = lkDetail
        val follStatsDetail: String? = ProfileDetailsObject.followStatsDetail[profileData.username]
        followStatsDetail = findViewById(R.id.follow_stats_detail)
        followStatsDetail.text = follStatsDetail


        repoPicture = findViewById(R.id.repo_picture)
        repoPicture.setImageResource(pictureData)
        repoUsername = findViewById(R.id.username_repo)
        repoUsername.text = profileData.username.toString()
        val repositoryName: String? = ProfileDetailsObject.repositoryNameDetails[profileData.username]
        repositoryNameTextView = findViewById(R.id.repository_name)
        repositoryNameTextView.text = repositoryName
        val repositoryDescription: String? = ProfileDetailsObject.repositoryDescriptionDetails[profileData.username]
        repositoryDescriptionTextView = findViewById(R.id.repository_description)
        repositoryDescriptionTextView.text = repositoryDescription
        val numOfStars: String? = ProfileDetailsObject.starNumberDetails[profileData.username]
        numStarsTextView = findViewById(R.id.number_of_stars)
        numStarsTextView.text = numOfStars
        val programmingLanguage: String? = ProfileDetailsObject.programmingLanguageDetails[profileData.username]
        programmingLanguageTextView = findViewById(R.id.programming_language)
        programmingLanguageTextView.text = programmingLanguage
        val programmingLanguageLogo: Int? = ProfileDetailsObject.programmingLanguageVectorDetails[profileData.username]
        programmingLanguageVector = findViewById(R.id.program_language_vector)
        if (programmingLanguageLogo != null) {
            programmingLanguageVector.setImageResource(programmingLanguageLogo)
        }

        repoNumber = findViewById(R.id.repo_number)
        starredNumber = findViewById(R.id.starred_number)
        organizationNumber = findViewById(R.id.organizations_number)

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