package com.realshovanshah.dynamicdemo.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.realshovanshah.dynamicdemo.LoginViewModelFactory
//import com.realshovanshah.dynamicdemo.ProfileViewModelFactory
import com.realshovanshah.dynamicdemo.R
import com.realshovanshah.dynamicdemo.databinding.FragmentProfileBinding
import com.realshovanshah.dynamicdemo.network.LoginService
import com.realshovanshah.dynamicdemo.repository.TeacherRepository

class ProfileFragment : Fragment() {

    lateinit var binding: FragmentProfileBinding

    private lateinit var viewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container,false)

        val service = LoginService.create()
        val repository= TeacherRepository(service)
        val factory= LoginViewModelFactory(repository, requireActivity().application)

        viewModel = ViewModelProvider(this, factory).get(ProfileViewModel::class.java)
        binding.profileViewModel = viewModel
        binding.lifecycleOwner = this

        return binding.root
    }

}