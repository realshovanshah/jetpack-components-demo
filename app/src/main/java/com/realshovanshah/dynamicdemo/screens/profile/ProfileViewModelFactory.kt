package com.realshovanshah.dynamicdemo.screens.profile

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.realshovanshah.dynamicdemo.repository.TeacherRepository
import com.realshovanshah.dynamicdemo.screens.login.LoginViewModel

//interface Factory<T> {
//    fun create(): T
//}

@Suppress("UNCHECKED_CAST")
class ProfileViewModelFactory(
    private val teacherRepository: TeacherRepository,
    private val application: Application
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProfileViewModel(
            teacherRepository,
            application
        ) as T

    }

}