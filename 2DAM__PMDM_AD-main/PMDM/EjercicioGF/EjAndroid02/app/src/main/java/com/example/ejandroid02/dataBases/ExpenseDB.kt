package com.example.ejandroid02.dataBases

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ejandroid02.dao.ExpenseDAO
import com.example.ejandroid02.entities.Expense

@Database(entities = [Expense::class], version = 1)
abstract class ExpenseDB : RoomDatabase() {
    abstract fun expenseDAO(): ExpenseDAO
}