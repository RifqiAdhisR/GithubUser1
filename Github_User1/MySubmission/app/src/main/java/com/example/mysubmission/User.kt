package com.example.mysubmission

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class User(
    var name: String,
    var company: String,
    var location: String,
    var followers: Int,
    var following: Int,
    var repository: Int,
    var username: String,
    var avatar: Int
):Parcelable
