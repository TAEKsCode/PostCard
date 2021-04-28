package com.onix.postcard.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import com.onix.postcard.R
import com.onix.postcard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        //AppInitializer.getInstance(this).initializeComponent(KoinInitializer::class.java)
    }

}
