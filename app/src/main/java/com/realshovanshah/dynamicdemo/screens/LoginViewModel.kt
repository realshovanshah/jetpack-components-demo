package com.realshovanshah.dynamicdemo.screens

import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.NavHostFragment
import com.realshovanshah.dynamicdemo.model.BookDetail
import com.realshovanshah.dynamicdemo.model.TeacherDetail
import com.realshovanshah.dynamicdemo.network.BookService
import com.realshovanshah.dynamicdemo.network.LoginService
import com.realshovanshah.dynamicdemo.network.RetrofitInstance
import com.realshovanshah.dynamicdemo.repository.UserRepository
import com.realshovanshah.dynamicdemo.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel : ViewModel(){

    private val TAG = "LoginViewModel"

//    private var _email = MutableLiveData<String>()
//    val email: LiveData<String>
//        get() = _email

//    private var _password = MutableLiveData<String>()
//    val password: LiveData<String>
//        get() = _password

    private var repository: UserRepository

    val _email = MutableLiveData<String>("")
    val _password = MutableLiveData<String>("")
    val _loggedIn = MutableLiveData<Boolean>(false)

    init {
        repository = UserRepository()
    }

    fun onLogin(){

        Log.d(TAG, "onLogin: called")

        if(repository.login()){
            _loggedIn.value = true
        }

        //todo: make this async
//        GlobalScope.launch(Dispatchers.Main) {
//            repository.login()
//        }

    }


}