package com.realshovanshah.dynamicdemo.repository

import android.app.Application
import android.util.Log
import com.realshovanshah.dynamicdemo.model.TeacherDetail
import com.realshovanshah.dynamicdemo.network.LoginService
import com.realshovanshah.dynamicdemo.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.FutureTask

class UserRepository() {
    private val TAG = "UserRepository"

    fun login(): Boolean{
        Log.d(TAG, "login: called")
        var isSuccessful = false
        val call: Call<List<TeacherDetail>> = LoginService.create().getTeacher("Ram18", "12345", Constants.PASS_KEY)
        call.enqueue(object : Callback<List<TeacherDetail>> {
            override fun onFailure(call: Call<List<TeacherDetail>>, t: Throwable) {
                Log.d(TAG, "onFailure: Something went wrong")
            }

            override fun onResponse(
                call: Call<List<TeacherDetail>>,
                response: Response<List<TeacherDetail>>
            ) {
                Log.d(TAG, "onResponse: Teacher object: ${response.body()!![0].toString()}")
            }
        })
                isSuccessful = true

        return isSuccessful
    }

}