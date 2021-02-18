package com.realshovanshah.dynamicdemo.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.realshovanshah.dynamicdemo.model.BookDetail
import com.realshovanshah.dynamicdemo.model.TeacherDetail
import com.realshovanshah.dynamicdemo.network.BookService
import com.realshovanshah.dynamicdemo.network.RetrofitInstance
import com.realshovanshah.dynamicdemo.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BookRepository(private var bookService: BookService) {

    private val TAG = "BookRepository"
    private var bookList = ArrayList<BookDetail>()

    suspend fun getBooks(): ArrayList<BookDetail>{
       bookService = RetrofitInstance.get().create(BookService::class.java)
//            repository.login()
            bookList = bookService.getBooks(Constants.PASS_KEY, Constants.EMP_ID) as ArrayList<BookDetail>
//            bookList = teacher as ArrayList<BookDetail>

            Log.d(TAG, "getBooks: complete")
        return bookList
    }


//    suspend fun getBooks(){
//        bookService.getBooks(Constants.PASS_KEY, Constants.EMP_ID).enqueue(object :
//            Callback<List<BookDetail>> {
//            override fun onFailure(call: Call<List<BookDetail>>, t: Throwable) {
//                Log.d(TAG, "onFailure: books retrieving failed")
//            }
//
//            override fun onResponse(
//                call: Call<List<BookDetail>>,
//                response: Response<List<BookDetail>>
//            ) {
//                Log.d(TAG, "onResponse: ${response.body()!![0]}")
//
//            }

//        })
    }