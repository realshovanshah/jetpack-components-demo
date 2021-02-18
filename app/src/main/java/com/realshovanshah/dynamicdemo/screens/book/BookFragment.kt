package com.realshovanshah.dynamicdemo.screens.book

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.Observable
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.realshovanshah.dynamicdemo.R
import com.realshovanshah.dynamicdemo.adapter.RecyclerViewAdapter
import com.realshovanshah.dynamicdemo.databinding.FragmentBookBinding
import com.realshovanshah.dynamicdemo.model.BookDetail
import com.realshovanshah.dynamicdemo.model.TeacherDetail
import com.realshovanshah.dynamicdemo.network.BookService
import com.realshovanshah.dynamicdemo.network.LoginService
import com.realshovanshah.dynamicdemo.repository.BookRepository
import com.realshovanshah.dynamicdemo.repository.TeacherRepository
import com.realshovanshah.dynamicdemo.screens.login.LoginViewModel
import com.realshovanshah.dynamicdemo.screens.login.LoginViewModelFactory

class BookFragment : Fragment() {

    private val countries: ArrayList<BookDetail> = ArrayList()
    private lateinit var binding: FragmentBookBinding
    private val TAG = "BookFragment"

    private lateinit var viewModel: BookViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_book, container,false)

        val service = BookService.create()
        val repository= BookRepository(service)
        val factory=
            BookViewModelFactory(
                repository,
                requireActivity().application
            )

        viewModel = ViewModelProvider(this, factory).get(BookViewModel::class.java)


        Log.d(TAG, "onCreateView: ${viewModel.bookList}")



        viewModel.bookList.observe(viewLifecycleOwner,Observer{
            if (it.isNotEmpty()){
                binding.recyclerview.adapter= RecyclerViewAdapter(viewModel.bookList.value!!)
            }
        })


        return binding.root
    }

}
