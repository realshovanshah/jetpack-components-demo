package com.realshovanshah.dynamicdemo

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.realshovanshah.dynamicdemo.repository.TeacherRepository
import com.realshovanshah.dynamicdemo.screens.LoginViewModel

//interface LoginFactory<T> {
//    fun create(): T
//}

@Suppress("UNCHECKED_CAST")
class LoginViewModelFactory(
    private val teacherRepository: TeacherRepository,
    private val application: Application
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel(teacherRepository, application) as T

    }

}