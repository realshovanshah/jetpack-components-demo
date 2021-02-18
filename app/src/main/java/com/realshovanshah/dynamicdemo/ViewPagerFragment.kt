package com.realshovanshah.dynamicdemo

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.realshovanshah.dynamicdemo.adapter.ViewPagerAdapter
import com.realshovanshah.dynamicdemo.databinding.FragmentViewPagerBinding
import com.realshovanshah.dynamicdemo.screens.book.BookFragment
import com.realshovanshah.dynamicdemo.screens.HomeFragment

class ViewPagerFragment: Fragment() {

    lateinit var binding: FragmentViewPagerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_view_pager, container,false)

        val fragments = arrayListOf(
            HomeFragment(),
            BookFragment()
        )

        val adapter = ViewPagerAdapter(
            fragments,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            val titles = arrayListOf<String>(
                "Home",
                "Books"
            )
            binding.tabLayout.setBackgroundColor(Color.parseColor("#6200EE"))
            tab.text = titles[position]
        }.attach()

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