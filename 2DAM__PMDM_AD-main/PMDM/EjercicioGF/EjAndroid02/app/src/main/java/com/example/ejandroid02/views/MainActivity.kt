package com.example.ejandroid02.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ejandroid02.databinding.ActivityMainBinding
import com.example.ejandroid02.entities.User
import com.example.ejandroid02.providers.UserProvider

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btLogin.setOnClickListener() {
            var msj = ""

            var name = binding.etName.text.toString()
            var password = binding.etPassword.text.toString()

            if (!name.isNullOrBlank() && !password.isNullOrEmpty()) {
                if (!UserProvider.users.contains(User(name, password))) {
                    msj =
                        "Alguno de los datos que escribistes esta mal introducido.\nNo se encontro el usuario"
                } else {
                    //val intent = Intent(this, MainActivityND::class.java).apply {
                    //    putExtra("user", name)
                    //}
                    startActivity(intent)
                }
            } else {
                msj = "Debes introducir los datos para poder inciar sesion"
            }

            if (!msj.isNullOrEmpty()) {
                Toast.makeText(this, msj, Toast.LENGTH_LONG).show()
            }
        }
    }
}