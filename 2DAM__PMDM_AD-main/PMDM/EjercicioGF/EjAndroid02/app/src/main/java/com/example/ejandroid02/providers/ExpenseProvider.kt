package com.example.ejandroid02.providers

import com.example.ejandroid02.entities.Expense
import java.util.Date

class ExpenseProvider {
    companion object {
        val gastos: ArrayList<Expense> = arrayListOf(
            Expense("Comida", "Pizza", Date(), 100, "juan"),
            Expense("Comida", "Hamburguesa", Date(), 10, "juan"),
            Expense("Comida", "Tacos", Date(), 30, "juan"),
            Expense("Estudios", "Libro", Date(), 200, "juan"),
            Expense("Ocio", "Cine", Date(), 7, "juan"),
            Expense("Ocio", "Cine", Date(), 7, "pedro"),
            Expense("Comida", "Pizza", Date(), 100, "pedro"),
            Expense("Comida", "Hamburguesa", Date(), 20, "pedro")
        )
    }
}