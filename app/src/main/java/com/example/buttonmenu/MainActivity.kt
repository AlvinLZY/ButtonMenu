package com.example.buttonmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.buttonmenu.Fragment.FeedbackFragment
import com.example.buttonmenu.Fragment.HomeFragment
import com.example.buttonmenu.Fragment.SettingsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val homeFragment = HomeFragment()
    private val settingsFragment = SettingsFragment()
    private val feedbackFragment = FeedbackFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceFragment(this.homeFragment)
        bottom_navigation.setOnItemSelectedListener{
            when(it.itemId){
                R.id.ic_Home->replaceFragment(homeFragment)
                R.id.ic_Settings->replaceFragment(settingsFragment)
                R.id.ic_Feedback->replaceFragment(feedbackFragment)
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        if(fragment != null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container,fragment)
            transaction.commit()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.overflow_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.info_item->Toast.makeText(this,"Info Clicked",Toast.LENGTH_SHORT).show()
            R.id.exit_item->finish()
        }
        return super.onOptionsItemSelected(item)
    }
}