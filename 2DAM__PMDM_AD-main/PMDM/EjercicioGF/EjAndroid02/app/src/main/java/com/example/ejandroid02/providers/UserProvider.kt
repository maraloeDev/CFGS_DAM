package com.example.ejandroid02.providers

import com.example.ejandroid02.entities.User

class UserProvider {
    companion object {
        val users: ArrayList<User> = arrayListOf(
            User("juan", "hola_mundo"),
            User("pedro", "hola_mundo2"),
            User("maria", "hola_mundo3")
        )
    }
}