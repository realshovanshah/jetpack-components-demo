package com.realshovanshah.dynamicdemo.screens.book

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.realshovanshah.dynamicdemo.repository.BookRepository
import com.realshovanshah.dynamicdemo.repository.TeacherRepository

//interface LoginFactory<T> {
//    fun create(): T
//}

@Suppress("UNCHECKED_CAST")
class BookViewModelFactory(
    private val bookRepository: BookRepository,
    private val application: Application
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return BookViewModel(
            bookRepository,
            application
        ) as T

    }

}