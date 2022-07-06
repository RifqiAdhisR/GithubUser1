package com.example.mysubmission

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvUser: RecyclerView
    private val list = ArrayList<User>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = "Github"
        rvUser = findViewById(R.id.rv_user)
        rvUser.setHasFixedSize(true)
        list.addAll(listUser)
        showRecyclerList()
    }
    private val listUser: ArrayList<User>
    get(){
        val dataName = resources.getStringArray(R.array.name)
        val dataCompany = resources.getStringArray(R.array.company)
        val dataLocation = resources.getStringArray(R.array.location)
        val dataAvatar = resources.obtainTypedArray(R.array.avatar)
        val dataFollower = resources.getIntArray(R.array.followers)
        val dataFollowing = resources.getIntArray(R.array.following)
        val dataRepository = resources.getIntArray(R.array.repository)
        val dataUsername = resources.getStringArray(R.array.username)
        val listUser = ArrayList<User>()
        for (i in dataName.indices){
            val user = User(dataName[i], dataCompany[i],dataLocation[i], dataFollower[i], dataFollowing[i], dataRepository[i], dataUsername[i], dataAvatar.getResourceId(i,-1))
            listUser.add(user)
        }
        return listUser
    }
    private fun showRecyclerList() {
        if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rvUser.layoutManager = GridLayoutManager(this, 2)
        } else {
            rvUser.layoutManager = LinearLayoutManager(this)
        }
        val listUserAdapter = ListUserAdapter(list)
        rvUser.adapter = listUserAdapter
        listUserAdapter.setOnItemClickCallback(object : ListUserAdapter.OnItemClickCallback {
            override fun onItemClicked(data: User) {
                val moveWithObjectIntent = Intent(this@MainActivity,DetailActivity::class.java)
                moveWithObjectIntent.putExtra(DetailActivity.EXTRA_PERSON, data)
                startActivity(moveWithObjectIntent)
            }
        })
    }
}