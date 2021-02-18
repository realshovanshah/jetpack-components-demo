package com.realshovanshah.dynamicdemo

import com.realshovanshah.dynamicdemo.R
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.viewpager.widget.ViewPager
import com.realshovanshah.dynamicdemo.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var drawerLayout: DrawerLayout

//    lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val navController = this.findNavController(R.id.navHostFragment)
        NavigationUI.setupWithNavController(binding.drawerNavView, navController)


//        NavigationUI.setupWithNavController()


//        binding.bottomNavView.setOnNavigationItemSelectedListener {
//            when (it.itemId) {
//                R.id.homeFragment -> {
//                    binding.viewPager.currentItem = 0
//                    true
//                }
//                R.id.bookFragment -> {
//                    binding.viewPager.currentItem = 1
//                    true
//                }
//                else -> false
//            }
//        }
    }

}