package com.example.ejandroid02.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.ejandroid02.entities.User

@Dao
interface UserDAO {

    // CRUD operation
    @Query("SELECT * FROM users")
    fun getAll(): List<User>
    @Update
    fun updateUser(user: User)
    @Insert
    fun insertUser(vararg User: User)
    @Delete
    fun deleteUser(vararg User: User)

    // Other operation
    @Query("SELECT * FROM users WHERE userName_User IN (:userName)")
    fun getUserByUserName(userName: String): User
    @Query("SELECT EXISTS(SELECT * FROM users WHERE userName_User = :userName)")
    fun isUserExistByUserName(userName: String): Boolean
    @Query("SELECT EXISTS(SELECT * FROM users)")
    fun isDatabaseEmpty(): Boolean
    @Query("SELECT password_User FROM users WHERE userName_User IN (:userName)")
    fun getPassWordByUserName(userName: String): String

}