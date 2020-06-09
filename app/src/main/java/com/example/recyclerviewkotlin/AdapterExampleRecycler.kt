package com.example.recyclerviewkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.recycle_example_item.view.*


class AdapterExampleRecycler(private val exampleList: List<ExampleItem>,  val onItemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<AdapterExampleRecycler.AdapterExampleViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterExampleViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycle_example_item, parent, false)
        return AdapterExampleViewHolder(itemView, onItemClickListener)
    }

    override fun onBindViewHolder(holder: AdapterExampleViewHolder, position: Int) {
        val currentItem = exampleList[position]
        holder.bind(currentItem)
    }

    override fun getItemCount() = exampleList.size

    class AdapterExampleViewHolder(itemView: View, onItemClickListener: OnItemClickListener) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener {
                onItemClickListener.onClick(adapterPosition)
            }

            itemView.setOnLongClickListener {
                onItemClickListener.onLongClick(adapterPosition)
                return@setOnLongClickListener true

            }

            itemView.image_view.setOnClickListener {
                val snack: String = "Image: $adapterPosition"
                Snackbar.make(itemView, snack, Snackbar.LENGTH_SHORT).show()
            }
        }

        fun bind(currentItem: ExampleItem) {
            itemView.image_view.setImageResource(currentItem.imageResource)
            itemView.text_view_1.text = currentItem.text1
            itemView.text_view_2.text = currentItem.text2
        }
    }

    interface OnItemClickListener {
        fun onClick(position: Int)
        fun onLongClick(position: Int)
    }
}
