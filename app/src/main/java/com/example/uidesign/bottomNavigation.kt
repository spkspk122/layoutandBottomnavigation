package com.example.uidesign

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.uidesign.databinding.ActivityBottomNavigationBinding
import com.example.uidesign.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class bottomNavigation : AppCompatActivity() {
    private  lateinit var drawerlayout : DrawerLayout
    private  lateinit var navigationView : NavigationView
    private  lateinit var togglebtn : ActionBarDrawerToggle
    private lateinit var binding : ActivityBottomNavigationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBottomNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(home())



      binding.bottomNavigationView.setOnItemSelectedListener {
          when(it.itemId){
              R.id.dashboard ->replaceFragment(DashBoards())
              R.id.home ->replaceFragment(home())
              R.id.profile -> replaceFragment(profile())
              R.id.settings -> replaceFragment(setting())


              else ->{

              }
          }

          true
      }

        //calling drawerlayout by id
        drawerlayout = findViewById(R.id.main_menu)
//
//        //togglebtn action to listen drawer
//
//
//
        togglebtn = ActionBarDrawerToggle(this,drawerlayout,0,0)
        drawerlayout.addDrawerListener(togglebtn)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        togglebtn.syncState()


        navigationView = findViewById(R.id.nav_view)

        navigationView.setNavigationItemSelectedListener {
//                menuId->
//
            when(it.itemId){
                R.id.home -> {
                    Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()

                }

                R.id.about ->{
                    Toast.makeText(this, " About ", Toast.LENGTH_SHORT).show()

                }

                R.id.settings ->{
                    Toast.makeText(this, " press for more ", Toast.LENGTH_SHORT).show()

                }
            }
            true

//            when(menuId.itemId){
//
//           R.id.home ->{
//               Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
//               true
//           }
//                R.id.dashboard ->{
//                    Toast.makeText(this, "Dashboard", Toast.LENGTH_SHORT).show()
//                    true
//                }
//                R.id.profile ->{
//                    Toast.makeText(this, "profile", Toast.LENGTH_SHORT).show()
//                    true
//                }
//                R.id.settings ->{
//                    Toast.makeText(this, "setting", Toast.LENGTH_SHORT).show()
//                    true
//                }
//
//                else ->{
//                    false
//                }
//            }
        }


    }
    private fun replaceFragment(fragment: Fragment){

        val fragmentManager = supportFragmentManager
        val  fragmentTransitions = fragmentManager.beginTransaction()
        fragmentTransitions.replace(R.id.frame_layout,fragment)
        fragmentTransitions.commit()


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (togglebtn.onOptionsItemSelected(item)){
            true
        }
        return super.onOptionsItemSelected(item)
    }



}