package com.example.controlgastos

import java.util.Date

data class Gasto(var categoria: String, var concepto: String, var fecha: Date, var precio: Double) {
    override fun toString(): String {
        return super.toString()
    }
}
