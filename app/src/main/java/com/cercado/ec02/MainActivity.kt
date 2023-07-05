package com.cercado.ec02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.cercado.ec02.R.id.fragment_container_view_tag
import com.cercado.ec02.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var navigationView: BottomNavigationView
    private lateinit var binding: ActivityMainBinding
    private val mOnNavToolBar = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.profile -> {
                supportFragmentManager.commit {

                    replace<CameraFragment> (fragment_container_view_tag)
                    setReorderingAllowed(true)
                    addToBackStack("replacement")
                }
                return@OnNavigationItemSelectedListener true
            }

            R.id.maps -> {
                supportFragmentManager.commit {

                    replace<MapsFragment> (fragment_container_view_tag)
                    setReorderingAllowed(true)
                    addToBackStack("replacement")
                }
                return@OnNavigationItemSelectedListener true
            }

            R.id.information -> {
                supportFragmentManager.commit {

                    replace<InformationFragment> (fragment_container_view_tag)
                    setReorderingAllowed(true)
                    addToBackStack("replacement")
                }
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbarMenu.setOnNavigationItemSelectedListener (mOnNavToolBar)

        supportFragmentManager.commit {

            replace<CameraFragment> (fragment_container_view_tag)
            setReorderingAllowed(true)
            addToBackStack("replacement")
        }
    }
}