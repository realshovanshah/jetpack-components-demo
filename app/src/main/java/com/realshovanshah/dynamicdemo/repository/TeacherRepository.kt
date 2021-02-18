package com.realshovanshah.dynamicdemo.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.realshovanshah.dynamicdemo.model.TeacherDetail
import com.realshovanshah.dynamicdemo.network.LoginService
import com.realshovanshah.dynamicdemo.network.RetrofitInstance
import com.realshovanshah.dynamicdemo.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.FutureTask

class UserRepository(private  var loginService: LoginService) {

    private val TAG = "UserRepository"

    private lateinit var teacherData:LiveData<TeacherDetail>

    private var teacher: List<TeacherDetail> = ArrayList()

    suspend fun login(): List<TeacherDetail> {
        loginService = RetrofitInstance.get().create(LoginService::class.java)
//            repository.login()
            teacher = loginService.getTeacher("Ram18", "12345", Constants.PASS_KEY)
            Log.d(TAG, "onLogin: $teacher")


        Log.d(TAG, "login: ${teacher}")
        return teacher
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