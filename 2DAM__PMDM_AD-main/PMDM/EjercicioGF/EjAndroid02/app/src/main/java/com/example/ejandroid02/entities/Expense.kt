package com.example.ejandroid02.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import java.util.Date

@Entity(tableName = "expenses")
data class Expense(@ColumnInfo(name = "category_Expense")var category: String,
                   @ColumnInfo(name = "concept_Expense")var concept: String,
                   @ColumnInfo(name = "date_Expense")var date: Date,
                   @ColumnInfo(name = "price_Expense")var price: Int,
                   @ColumnInfo(name = "userName_Expense")var userName:String)
