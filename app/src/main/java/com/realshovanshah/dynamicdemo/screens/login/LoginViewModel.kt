package com.realshovanshah.dynamicdemo.screens.login

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.realshovanshah.dynamicdemo.repository.TeacherRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

class LoginViewModel(var teacherRepository: TeacherRepository, application: Application) : AndroidViewModel(
    application
){

    private val TAG = "LoginViewModel"

//    private var _email = MutableLiveData<String>()
//    val email: LiveData<String>
//        get() = _email

//    private var _password = MutableLiveData<String>()
//    val password: LiveData<String>
//        get() = _password

    val _email = MutableLiveData<String>("Ram18")
    val _password = MutableLiveData<String>("12345")
    val _loggedIn = MutableLiveData<Boolean>(false)

    fun onLogin(){

        Log.d(TAG, "onLogin: called")
//        val user = liveData { emit(userRepository.login() ) }

        CoroutineScope(Main).launch{
            val user = teacherRepository.login(_email.value!!, _password.value!!)
            if (user.isNotEmpty()){

                teacherRepository.saveTeacher(user[0], getApplication())
                _loggedIn.value = true
            }

        }

    }


}