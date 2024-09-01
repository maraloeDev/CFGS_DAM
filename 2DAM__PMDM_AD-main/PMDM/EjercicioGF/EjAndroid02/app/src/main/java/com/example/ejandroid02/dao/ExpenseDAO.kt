package com.example.ejandroid02.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.ejandroid02.entities.Expense
import com.example.ejandroid02.entities.User

@Dao
interface ExpenseDAO {

    // CRUD operation
    @Query("SELECT * FROM expenses")
    fun getAll(): List<Expense>
    @Update
    fun updateUser(Expense: Expense)
    @Insert
    fun insertUser(vararg Expense: Expense)
    @Delete
    fun deleteUser(vararg Expense: Expense)

    // Other operation
    @Query("SELECT * FROM expenses WHERE userName_Expense IN (:userName)")
    fun getExpenseByUserName(userName: String): List<Expense>
    @Query("SELECT EXISTS(SELECT * FROM expenses WHERE userName_Expense = :userName)")
    fun isUserHaveExpense(userName: String): Boolean
    @Query("SELECT EXISTS(SELECT * FROM expenses)")
    fun isDatabaseEmpty(): Boolean

}