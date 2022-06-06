package com.doubleclick.roomdatabasekotlin.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.doubleclick.roomdatabasekotlin.DAO.SchoolDao
import com.doubleclick.roomdatabasekotlin.Entities.Application
import com.doubleclick.roomdatabasekotlin.Entities.Student

/**
 * Created By Eslam Ghazy on 6/6/2022
 */
@Database(entities = [Student::class, Application::class], version = 1, exportSchema = false)
abstract class database : RoomDatabase() {

    abstract fun detilsDao(): SchoolDao

    companion object {
        @Volatile
        private var instance: database? = null
        private val lock = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(lock) {

            instance ?: buildDatabase(context).also {
                instance = it
            }

        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, database::class.java, "School")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()
    }

}