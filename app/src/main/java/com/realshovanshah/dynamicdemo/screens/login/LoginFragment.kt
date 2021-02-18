package com.realshovanshah.dynamicdemo.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.realshovanshah.dynamicdemo.LoginViewModelFactory
import com.realshovanshah.dynamicdemo.R
import com.realshovanshah.dynamicdemo.databinding.FragmentLoginBinding
import com.realshovanshah.dynamicdemo.network.LoginService
import com.realshovanshah.dynamicdemo.repository.TeacherRepository

class LoginFragment : Fragment() {

    private lateinit var viewModel: LoginViewModel

    private lateinit var binding: FragmentLoginBinding

    private var TAG = "LoginFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container,false)

        val service = LoginService.create()
        val repository= TeacherRepository(service)
        val factory= LoginViewModelFactory(repository, requireActivity().application)

        viewModel = ViewModelProvider(this, factory).get(LoginViewModel::class.java)

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