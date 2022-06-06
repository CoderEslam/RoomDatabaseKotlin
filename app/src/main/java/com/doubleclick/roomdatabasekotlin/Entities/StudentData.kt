package com.doubleclick.roomdatabasekotlin.Entities

import androidx.room.Embedded
import androidx.room.Relation
import androidx.room.Transaction

/**
 * Created By Eslam Ghazy on 6/6/2022
 */

data class StudentData(
    @Embedded val student: Student,
    @Relation(parentColumn = "student_id", entityColumn = "id") val application: List<Application>
)