package com.example.recyclerviewkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycle_example_item.view.*

class AdapterExampleRecycler(private val exampleList: List<ExampleItem>) :
    RecyclerView.Adapter<AdapterExampleRecycler.AdapterExampleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterExampleViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycle_example_item, parent, false)
        return AdapterExampleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AdapterExampleViewHolder, position: Int) {
        val currentItem = exampleList[position]

        holder.imageViw.setImageResource(currentItem.imageResource)
        holder.textview1.text = currentItem.text1
        holder.textview2.text = currentItem.text2
    }

    override fun getItemCount() = exampleList.size

    class AdapterExampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageViw = itemView.image_view
        val textview1 = itemView.text_view_1
        val textview2 = itemView.text_view_2

    }
}