package com.realshovanshah.dynamicdemo.network

import com.realshovanshah.dynamicdemo.model.BookDetail
import com.realshovanshah.dynamicdemo.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.POST
import retrofit2.http.Query

interface BookService {

        @POST("teacher/getELibraryType?passKey=5C497DBD-27E3-4746-8F65-9EA1CDB1933F&EmployeeId=18")
        suspend fun getBooks(@Query("passKey") passkey: String,
                     @Query("employeeId") employeeId: String):
                List<BookDetail>

        companion object {
            fun create(): BookService {
                return RetrofitInstance.get().create(BookService::class.java)
            }
        }
}