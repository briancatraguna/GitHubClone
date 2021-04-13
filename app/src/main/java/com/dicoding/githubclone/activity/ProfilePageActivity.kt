package com.dicoding.githubclone.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.dicoding.githubclone.fragment.OptionDialogFragment
import com.dicoding.githubclone.localdata.ProfileDetailsObject
import com.dicoding.githubclone.data.Profiles
import com.dicoding.githubclone.R
import com.dicoding.githubclone.databinding.ActivityProfilePageBinding

class ProfilePageActivity : AppCompatActivity(),View.OnClickListener {

    private lateinit var username: String
    private lateinit var repositories: String
    private lateinit var stars: String
    private lateinit var organizations: String

    private lateinit var binding: ActivityProfilePageBinding

    companion object {
        const val EXTRA_PROFILE = "extra_profile"
        const val EXTRA_PICTURE = "extra_picture"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfilePageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val profileData = intent.getParcelableExtra<Profiles>(EXTRA_PROFILE) as Profiles
        val pictureData = intent.getIntExtra(EXTRA_PICTURE,0)

        val profilePictureDetail = binding.profilePictureDetail
        profilePictureDetail.setImageResource(pictureData)
        val fullNameDetail = binding.fullNameDetail
        fullNameDetail.text = profileData.fullName.toString()
        val usernameDetail = binding.usernameDetail
        usernameDetail.text = profileData.username.toString()
        val bioDetail = binding.bioDetail
        bioDetail.text = profileData.bio.toString()

        val moreButton = binding.toolbar.moreButton
        moreButton.setOnClickListener(this)
        val backToMain = binding.toolbar.backToMain
        backToMain.setOnClickListener(this)
        val followButton = binding.followingButton
        followButton.setOnClickListener(this)

        val descDetail: String? = ProfileDetailsObject.descriptionDetail[profileData.username]
        val descriptionDetail = binding.descriptionDetail
        descriptionDetail.text = descDetail
        val compDetail: String? = ProfileDetailsObject.companyDetail[profileData.username]
        val companyDetail = binding.companyDetail
        companyDetail.text = compDetail
        val locDetail: String? = ProfileDetailsObject.locationDetail[profileData.username]
        val locationDetail = binding.locationDetail
        locationDetail.text = locDetail
        val lkDetail: String? = ProfileDetailsObject.linkDetail[profileData.username]
        val linkDetail = binding.linkDetail
        linkDetail.text = lkDetail
        val follStatsDetail: String? = ProfileDetailsObject.followStatsDetail[profileData.username]
        val followStatsDetail = binding.followStatsDetail
        followStatsDetail.text = follStatsDetail

        val repoPicture = binding.repoPicture
        repoPicture.setImageResource(pictureData)
        val repoUsername = binding.usernameRepo
        repoUsername.text = profileData.username.toString()
        val repositoryName: String? = ProfileDetailsObject.repositoryNameDetails[profileData.username]
        val repositoryNameTextView = binding.repositoryName
        repositoryNameTextView.text = repositoryName
        val repositoryDescription: String? = ProfileDetailsObject.repositoryDescriptionDetails[profileData.username]
        val repositoryDescriptionTextView = binding.repositoryDescription
        repositoryDescriptionTextView.text = repositoryDescription
        val numOfStars: String? = ProfileDetailsObject.starNumberDetails[profileData.username]
        val numStarsTextView = binding.numberOfStars
        numStarsTextView.text = numOfStars
        val programmingLanguage: String? = ProfileDetailsObject.programmingLanguageDetails[profileData.username]
        val programmingLanguageTextView = binding.programmingLanguage
        programmingLanguageTextView.text = programmingLanguage
        val programmingLanguageLogo: Int? = ProfileDetailsObject.programmingLanguageVectorDetails[profileData.username]
        val programmingLanguageVector = binding.programLanguageVector
        if (programmingLanguageLogo != null) {
            programmingLanguageVector.setImageResource(programmingLanguageLogo)
        }

        val repoNumber = binding.repoNumber
        val repoNumberString = ProfileDetailsObject.repositoriesNumber[profileData.username]
        repoNumber.text = repoNumberString
        val starredNumber = binding.starredNumber
        val starredNumberString = ProfileDetailsObject.starredNumber[profileData.username]
        starredNumber.text = starredNumberString
        val organizationNumber = binding.organizationsNumber
        val organizationNumberString = ProfileDetailsObject.organizationsNumber[profileData.username]
        organizationNumber.text = organizationNumberString

        val repositoriesButton = binding.repositoriesButton
        repositoriesButton.setOnClickListener(this)
        val starredButton = binding.starredButton
        starredButton.setOnClickListener(this)
        val organizationsButton = binding.organizationsButton
        organizationsButton.setOnClickListener(this)

        username = profileData.username.toString()
        repositories = repoNumberString.toString()
        stars = starredNumberString.toString()
        organizations = organizationNumberString.toString()
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
            R.id.repositories_button -> {
                val message1: String = "$username has $repositories repositories!"
                Toast.makeText(applicationContext,message1,Toast.LENGTH_SHORT).show()
            }
            R.id.starred_button -> {
                val message2: String = "$username has $stars stars!"
                Toast.makeText(applicationContext,message2,Toast.LENGTH_SHORT).show()
            }
            R.id.organizations_button -> {
                val message3: String = "$username is in $organizations organizations!"
                Toast.makeText(applicationContext,message3,Toast.LENGTH_SHORT).show()
            }
        }
    }
}