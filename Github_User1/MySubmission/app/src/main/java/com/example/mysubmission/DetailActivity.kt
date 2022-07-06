package com.example.mysubmission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.mysubmission.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    companion object {
        const val EXTRA_PERSON = "extra_person"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "Github User"
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val user = intent.getParcelableExtra<User>(EXTRA_PERSON) as User
        Glide.with(binding.imgItemPhoto.context)
            .load(user.avatar)
            .circleCrop()
            .into(binding.imgItemPhoto)
        binding.tvItemName.text = "Name : ${user.name}"
        binding.tvItemLocation.text = "Location : ${user.location}"
        binding.tvItemCompany.text = "Company : ${user.company}"
        binding.tvFollower.text  = " ${user.followers} "
        binding.tvFollowing.text = " ${user.following} "
        binding.tvReposory.text = "Repository : ${user.repository}"
        binding.tvItemUsername.text = "@${user.username}"
    }
}