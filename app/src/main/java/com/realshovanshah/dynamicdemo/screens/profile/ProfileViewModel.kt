package com.realshovanshah.dynamicdemo.screens

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.realshovanshah.dynamicdemo.model.TeacherDetail
import com.realshovanshah.dynamicdemo.repository.TeacherRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

class ProfileViewModel(var teacherRepository: TeacherRepository) : ViewModel(){

    private val TAG = "ProfileViewModel"

//    private var _email = MutableLiveData<String>()
//    val email: LiveData<String>
//        get() = _email

//    private var _password = MutableLiveData<String>()
//    val password: LiveData<String>
//        get() = _password

    val teacher = MutableLiveData<TeacherDetail>()

    init {
        getProfile()
    }

    private fun getProfile(){

        Log.d(TAG, "onLogin: called")
//        val user = liveData { emit(userRepository.login() ) }

            val user = teacherRepository.getTeacher(Application())
            teacher.value = user


    }


}