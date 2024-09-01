package com.example.ejandroid02.dataBases

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ejandroid02.dao.UserDAO
import com.example.ejandroid02.entities.User

@Database(entities = [User::class], version = 1)
abstract class UserDB : RoomDatabase() {
    abstract fun userDAO():UserDAO
}