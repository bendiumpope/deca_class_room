package com.example.decaclassroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import com.example.decaclassroom.R.id.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {


    lateinit var bottomNavigationView : BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager.beginTransaction()

        fragmentManager.add(fragment, HomeFragment.newInstance(),"Home fragment").commit()


        bottomNavigationView = findViewById(navigate)

        bottomNavigationView.selectedItemId = nav_home

        bottomNavigationView.setOnNavigationItemSelectedListener(this)



    }


    override fun onNavigationItemSelected(p0: MenuItem): Boolean {

        when (p0.getItemId()){
            nav_home ->{
                getSupportFragmentManager()
                    .beginTransaction()
                    .replace(fragment, HomeFragment()).commit()
                return true
            }
            nav_curriculum ->{
                getSupportFragmentManager()
                    .beginTransaction()
                    .replace(fragment, CurriculumFragment()).commit()
                return true
            }
            nav_resource ->{
                getSupportFragmentManager()
                    .beginTransaction()
                    .replace(fragment, ResourceFragment()).commit()
                return true
            }
            nav_profile ->{
                getSupportFragmentManager()
                    .beginTransaction()
                    .replace(fragment, ProfileFragment()).commit()
                return true
            }
        }

        return true
    }









}
