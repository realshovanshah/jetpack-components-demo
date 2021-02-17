package com.realshovanshah.dynamicdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.realshovanshah.dynamicdemo.adapter.ViewPagerAdapter
import com.realshovanshah.dynamicdemo.databinding.FragmentViewPagerBinding
import com.realshovanshah.dynamicdemo.screens.BookFragment
import com.realshovanshah.dynamicdemo.screens.HomeFragment
import kotlinx.android.synthetic.main.fragment_view_pager.view.*

class ViewPagerFragment: Fragment() {

    lateinit var binding: FragmentViewPagerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_view_pager, container,false)

        val fragments = arrayListOf(
            BookFragment(),
            HomeFragment()
        )

        val adapter = ViewPagerAdapter(
            fragments,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        binding.viewPager.adapter = adapter

//        binding.bottomNavView.setOnNavigationItemSelectedListener {
//            when (it.itemId) {
//                R.id.homeFragment -> {
//                    binding.viewPager.currentItem = 0
//                    return@setOnNavigationItemSelectdListener true
//                }
//                R.id.bookFragment -> {
//                    binding.viewPager.currentItem = 1
//                    return@setOnNavigationItemSelectdListener true
//                }
//                else -> false
//            }
//        }

        return binding.root

    }

}