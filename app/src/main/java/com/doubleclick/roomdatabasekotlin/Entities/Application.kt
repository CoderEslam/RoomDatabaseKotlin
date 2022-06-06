package com.doubleclick.roomdatabasekotlin.Entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

/**
 * Created By Eslam Ghazy on 6/6/2022
 */
@Entity(
    foreignKeys = [
        ForeignKey(
            entity = Student::class,
            parentColumns = arrayOf("student_id"),
            childColumns = arrayOf("id"),
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Application(
    val id: Int,
    @PrimaryKey val application_id: Long,
    val phone: Int
)
