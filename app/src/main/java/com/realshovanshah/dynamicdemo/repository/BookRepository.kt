package com.realshovanshah.dynamicdemo.repository

import android.util.Log
import com.realshovanshah.dynamicdemo.model.BookDetail
import com.realshovanshah.dynamicdemo.network.BookService
import com.realshovanshah.dynamicdemo.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BookRepository {

    private val TAG = "BookRepository"
    private val bookList = ArrayList<BookDetail>()

    fun getBooks(){

        BookService.create().getBooks(Constants.PASS_KEY, "18").enqueue(object :
            Callback<List<BookDetail>> {
            override fun onFailure(call: Call<List<BookDetail>>, t: Throwable) {
                Log.d(TAG, "onFailure: books retrieving failed")
            }

            override fun onResponse(
                call: Call<List<BookDetail>>,
                response: Response<List<BookDetail>>
            ) {
                Log.d(TAG, "onResponse: ${response.body()!![0]}")

            }

        })
    }
}