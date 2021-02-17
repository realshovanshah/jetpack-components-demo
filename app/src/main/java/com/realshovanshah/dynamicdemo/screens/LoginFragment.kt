package com.realshovanshah.dynamicdemo.screens

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.realshovanshah.dynamicdemo.R
import com.realshovanshah.dynamicdemo.databinding.FragmentLoginBinding
import com.realshovanshah.dynamicdemo.model.BookDetail
import com.realshovanshah.dynamicdemo.network.BookService
import com.realshovanshah.dynamicdemo.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginFragment : Fragment() {

    private lateinit var viewModel: LoginViewModel

    private lateinit var binding: FragmentLoginBinding

    private var TAG = "LoginFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container,false)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        binding.loginViewModel = viewModel
        binding.lifecycleOwner= this

        viewModel._loggedIn.observe(viewLifecycleOwner, Observer { v ->
            if (v==true){
                onLoginComplete()
            }
        })
        
        return binding.root
    }

    private fun onLoginComplete(){
        val action= LoginFragmentDirections.actionLoginFragmentToViewPagerFragment()
        NavHostFragment.findNavController(this).navigate(action)
        Toast.makeText(context,"User Key: $",Toast.LENGTH_LONG ).show()
    }

}