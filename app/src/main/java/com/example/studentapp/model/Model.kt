package com.example.studentapp.model

import com.google.gson.annotations.SerializedName

//data class Student(
//    var id:String?,
//    var name:String?,
//    var dob:String?,
//    var phone:String?,
//    var photourl:String?
//)

data class Student(
    val id:String?,
    @SerializedName("student_name")
    val name:String?,
    @SerializedName("birth_of_date")
    val dob:String?,
    val phone:String?,
    @SerializedName("photo_url")
    val photourl:String?
)
