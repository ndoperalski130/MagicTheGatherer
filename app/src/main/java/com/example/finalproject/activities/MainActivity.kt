package com.example.finalproject.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.Fragment
import com.example.finalproject.R
import com.example.finalproject.view.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        supportFragmentManager.beginTransaction()
            .add(R.id.fcvContainer, HomeFragment())
            .commit()
    }

    override fun onDestroy() {
        val bundle = Bundle()
        bundle.putParcelable("frag", supportFragmentManager.saveFragmentInstanceState(HomeFragment()))

        super.onDestroy()
    }
}