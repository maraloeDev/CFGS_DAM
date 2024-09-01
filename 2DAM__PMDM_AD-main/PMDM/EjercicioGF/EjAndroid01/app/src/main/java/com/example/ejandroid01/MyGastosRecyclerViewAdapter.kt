package com.example.ejandroid01

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ejandroid01.databinding.FragmentItemBinding
import com.example.controlgastos.GastosProvider

class MyGastosRecyclerViewAdapter : RecyclerView.Adapter<MyGastosRecyclerViewAdapter.ViewHolder>() {

    private val gastosList: List<GastosProvider.Gastos> = GastosProvider.gastos

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            FragmentItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = gastosList[position]
        holder.concepto.text = item.concepto
        holder.categoria.text = item.categoria
    }

    override fun getItemCount(): Int = gastosList.size

    inner class ViewHolder(binding: FragmentItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val concepto: TextView = binding.tvConcepto
        val categoria: TextView = binding.tvCategoria

        init {
            itemView.setOnClickListener {
                // Aquí puedes agregar lógica para manejar clics en elementos individuales si es necesario
            }
        }
    }
}
