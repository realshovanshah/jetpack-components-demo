package com.realshovanshah.dynamicdemo.network

import com.realshovanshah.dynamicdemo.model.TeacherDetail
import com.realshovanshah.dynamicdemo.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface LoginService {

    @GET("teacher/isValidUser")
    suspend fun getTeacher(@Query("username") username: String,
                    @Query("pwd") password: String,
                    @Query("passkey") passkey: String):
                List<TeacherDetail>

    companion object {
        fun create(): LoginService {
            return RetrofitInstance.get().create(LoginService::class.java)
        }
    }
}