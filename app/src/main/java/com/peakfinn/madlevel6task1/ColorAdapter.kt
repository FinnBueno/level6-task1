package com.peakfinn.madlevel6task1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_color.view.*

/**
 * Created by Finn Bon on 13/12/2020.
 */
class ColorAdapter(private val colors: List<ColorItem>, private val onClick: (ColorItem) -> Unit) : RecyclerView.Adapter<ColorAdapter.ViewHolder>() {

    private lateinit var context: Context

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                onClick(colors[adapterPosition])
            }
        }

        fun bind(colorItem: ColorItem) {
            Glide.with(context).load(colorItem.getImageUrl()).into(itemView.ivColor)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorAdapter.ViewHolder {
        context = parent.context

        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_color, parent, false)
        )
    }

    override fun getItemCount() = colors.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(colors[position])

}