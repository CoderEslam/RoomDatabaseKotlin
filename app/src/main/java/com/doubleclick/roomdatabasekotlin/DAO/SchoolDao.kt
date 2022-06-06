package com.doubleclick.roomdatabasekotlin.DAO

import androidx.room.*
import com.doubleclick.roomdatabasekotlin.Entities.Application
import com.doubleclick.roomdatabasekotlin.Entities.Student
import com.doubleclick.roomdatabasekotlin.Entities.StudentData

/**
 * Created By Eslam Ghazy on 6/4/2022
 */
@Dao
interface SchoolDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: List<Student>)


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertApplication(application: List<Application>)


    @Query("SELECT * from Student inner join Application on Student.student_id = Application.id")
    fun getApplicationbyStudent(): List<StudentData>


    @Query("SELECT * from Student WHERE student_id=:id")
    @Transaction
    fun getById(id: Int): List<Student>

    @Query("SELECT * from Student")
    fun getStudent(): List<Student>

    @Query("SELECT * from Application")
    fun getApplicationt(): List<Application>

}