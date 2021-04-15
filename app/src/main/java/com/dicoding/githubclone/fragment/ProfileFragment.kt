package com.dicoding.githubclone.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.dicoding.githubclone.R
import com.dicoding.githubclone.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private lateinit var profPic: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater,container,false)
        setView()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setView(){
        binding.profilePictureDetail.setImageResource(R.drawable.brian_catraguna)
        binding.fullNameDetail.text = "Brian Mohammed Catraguna"
        binding.usernameDetail.text = "briancatraguna"
        binding.descriptionDetail.text = "\uD83D\uDE80"
        binding.bioDetail.text = "Final Year Aerospace Engineering Student | Android Development Enthusiast"
        binding.companyDetail.text = "Institut Teknologi Bandung"
        binding.locationDetail.text = "Jakarta, Indonesia"
        binding.linkDetail.text = "https://www.linkedin.com/in/brian-mohammed-catraguna-160ab833/"
        binding.followStatsDetail.text = "11 followers · 21 following"
        binding.usernameRepo.text = "briancatraguna"
        binding.repositoryName.text = "Tensorflow_Exploration"
        binding.repositoryDescription.text = "Experience of using deep learning library and training on the Fashion MNIST dataset."
        binding.numberOfStars.text = "0"
        binding.programLanguageVector.setImageResource(R.drawable.python)
        binding.programmingLanguage.text = "Python"
        binding.repoNumber.text = "20"
        binding.starredNumber.text = "7"
        binding.organizationsNumber.text = "0"
        binding.repoPicture.setImageResource(R.drawable.brian_catraguna)
    }

}