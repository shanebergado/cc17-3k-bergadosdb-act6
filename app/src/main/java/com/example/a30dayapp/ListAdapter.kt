package com.example.a30dayapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView // Import statement
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(private val context: Context, private val days: List<Day>) :
    RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val day = days[position]
        holder.dayIndicator.text = "Day ${day.number}"
        holder.header.text = day.title
        holder.image.setImageResource(day.imageResId) // Set image resource
        holder.caption.text = day.description
    }

    override fun getItemCount(): Int {
        return days.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dayIndicator: TextView = itemView.findViewById(R.id.day_indicator)
        val header: TextView = itemView.findViewById(R.id.header)
        val image: ImageView = itemView.findViewById(R.id.image)
        val caption: TextView = itemView.findViewById(R.id.caption)
    }
}
