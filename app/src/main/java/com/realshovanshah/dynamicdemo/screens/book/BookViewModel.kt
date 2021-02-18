package com.realshovanshah.dynamicdemo.screens.book

import android.app.Application
import android.util.Log
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.realshovanshah.dynamicdemo.model.BookDetail
import com.realshovanshah.dynamicdemo.repository.BookRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlin.math.log

class BookViewModel(val bookRepository: BookRepository, application: Application) : AndroidViewModel(application) {

    private val TAG = "BookViewModel"

    var bookList = MutableLiveData<ArrayList<BookDetail>>()


    init {
        Log.d(TAG, "init: book view model")
        getBooks()
    }

    private fun getBooks(){
        CoroutineScope(Main).launch{
            val books = bookRepository.getBooks()
            Log.d(TAG, "getBooks: $books")
            bookList.value = books
        }
    }
}