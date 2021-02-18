package com.realshovanshah.dynamicdemo.repository

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.realshovanshah.dynamicdemo.model.TeacherDetail
import com.realshovanshah.dynamicdemo.network.LoginService
import com.realshovanshah.dynamicdemo.network.RetrofitInstance
import com.realshovanshah.dynamicdemo.utils.Constants

class TeacherRepository(private  var loginService: LoginService) {

    private val TAG = "TeacherRepository"

    private lateinit var teacherData:LiveData<TeacherDetail>

    private var teacher: List<TeacherDetail> = ArrayList()

    suspend fun login(
        _email: String,
        _password: String
    ): List<TeacherDetail> {
        loginService = RetrofitInstance.get().create(LoginService::class.java)
//            repository.login()
            teacher = loginService.getTeacher(_email, _password, Constants.PASS_KEY)
            Log.d(TAG, "onLogin: $teacher")


        Log.d(TAG, "login: ${teacher}")
        return teacher
    }

        fun getTeacher(application: Application):TeacherDetail{
        val sharedPref = application.getSharedPreferences("app",Context.MODE_PRIVATE)
        val teacherJson = sharedPref.getString("teacher", "")

        return Gson().fromJson(teacherJson, TeacherDetail::class.java)
    }

    fun saveTeacher(teacherDetail: TeacherDetail, application: Application){
        val sharedPref = application.getSharedPreferences("app", Context.MODE_PRIVATE) ?: return
        with (sharedPref.edit()) {
            val teacherJson = Gson().toJson(teacherDetail);
            putString("teacher", teacherJson)
            apply()
        }
    }
//    suspend fun login(): Boolean{
//        Log.d(TAG, "login: called")
//        var isSuccessful = false
//        val call: Call<List<TeacherDetail>> = LoginService.create().getTeacher("Ram18", "12345", Constants.PASS_KEY)
//        call.enqueue(object : Callback<List<TeacherDetail>> {
//            override fun onFailure(call: Call<List<TeacherDetail>>, t: Throwable) {
//                Log.d(TAG, "onFailure: Something went wrong")
//            }
//
//            override fun onResponse(
//                call: Call<List<TeacherDetail>>,
//                response: Response<List<TeacherDetail>>
//            ) {
//                Log.d(TAG, "onResponse: Teacher object: ${response.body()!![0]}")
//            }
//        })
//                isSuccessful = true
//
//        return isSuccessful
//    }

}