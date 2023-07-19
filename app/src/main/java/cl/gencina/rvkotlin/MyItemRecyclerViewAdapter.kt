package cl.gencina.rvkotlin

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.gencina.rvkotlin.databinding.ItemBinding
import com.bumptech.glide.Glide

class MyItemRecyclerViewAdapter() : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {
    var listaPokemon:List<Pokemon> = mutableListOf()
    lateinit var context:Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return ViewHolder(
            ItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listaPokemon[position]
        holder.bind(item)
        //holder. = item.nombre
    }

    override fun getItemCount(): Int {
        return listaPokemon.size
    }

    fun setData(pokedex: List<Pokemon>) {
        this.listaPokemon = pokedex
    }

    inner class ViewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Pokemon) {
            binding.tvNombre.text = item.nombre
            binding.tvTipo.text = item.tipo
            binding.tvId.text = item.id
            Glide.with(context)
                .load(item.imgUrl)
                .into(binding.ivImagen)
        }
    }
}