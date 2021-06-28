package com.venturus.basicrecycler2.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.venturus.basicrecycler2.R
import com.venturus.basicrecycler2.data.DataEntity

class ItemAdapter (private val ctx: Context) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    var listarRecycle = listOf<DataEntity>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_recycle, parent, false)
        return ItemViewHolder(view)


    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val drinkItem = listarRecycle[position]
        holder.bind(drinkItem)
    }

    // essa e a classe get item que vai adicionar os itens a recycler + gladi caso tenha uma imagem
    override fun getItemCount(): Int = listarRecycle.size
    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameContainer: TextView = itemView.findViewById(R.id.name)
        private val imageContainer: ImageView = itemView.findViewById(R.id.img_imagen)


        fun bind(dataItem: DataEntity) {
            nameContainer.text = dataItem.strDrink
            Glide.with(ctx)
                .load(dataItem.strDrinkThumb)
                .into(imageContainer)
        }
    }
}

