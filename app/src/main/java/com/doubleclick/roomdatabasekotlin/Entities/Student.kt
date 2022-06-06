package com.doubleclick.roomdatabasekotlin.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created By Eslam Ghazy on 6/6/2022
 */
@Entity
data class Student(
    @PrimaryKey val student_id: Int,
    val name: String,
    val age: Int
)
