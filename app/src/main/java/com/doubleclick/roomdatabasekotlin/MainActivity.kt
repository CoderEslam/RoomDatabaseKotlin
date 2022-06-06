package com.doubleclick.roomdatabasekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.doubleclick.roomdatabasekotlin.Database.database
import com.doubleclick.roomdatabasekotlin.Entities.Application
import com.doubleclick.roomdatabasekotlin.Entities.Student
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // https://www.youtube.com/watch?v=8FPru_C5vAY&list=PLN6I_UJ53IwTi3eJrnbLSWOMLp4itwqTB&ab_channel=CodetDistro
        val student: List<Student> = arrayListOf(
            Student(111, "eslam", 23),
            Student(112, "ghazy", 25),
            Student(113, "ali", 24),
            Student(114, "osama", 12)
        )

        val application: List<Application> = arrayListOf(
            Application(111, 1, 5334323),
            Application(112, 2, 2553435),
            Application(111, 3, 2433543),
            Application(113, 4, 1234311)
        )


        val db = database(this)

        CoroutineScope(Dispatchers.Default).launch {
            db.detilsDao().insertStudent(student)
            db.detilsDao().insertApplication(application)


            val data = db.detilsDao().getApplicationbyStudent()

            Log.e("Data", data.toString());

            for (d in db.detilsDao().getById(111)) {
                Log.e("Single_Row", d.toString())
            }

//            Log.e("Data", db.detilsDao().getStudent().toString());

//            Log.e("Data", db.detilsDao().getApplicationt().toString());
        }

    }
}