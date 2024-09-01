package com.example.controlgastos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.controlgastos.databinding.ActivityMainBinding

class Login : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




    }
}