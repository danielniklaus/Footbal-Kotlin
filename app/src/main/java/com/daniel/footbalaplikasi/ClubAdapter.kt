package com.daniel.footbalaplikasi

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.android.extensions.LayoutContainer
import org.jetbrains.anko.AnkoContext

class ClubAdapter(val items: List<ItemData>, val listener:(ItemData) ->Unit) : RecyclerView.Adapter<ClubAdapter.ViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int)= ViewHolder(ItemUI().createView(AnkoContext.Companion.create(p0.context,p0)))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position],listener)
    }

    inner class ViewHolder(override val containerView:View) : RecyclerView.ViewHolder(containerView), LayoutContainer {
        val image = itemView.findViewById<ImageView>(ItemUI.CLUB_IMAGE)
        val name = itemView.findViewById<TextView>(ItemUI.CLUB_NAME)

        fun bind(item: ItemData, listener: (ItemData) -> Unit){
            Glide.with(itemView.context)
                .load(item.image)
                .into(image)

            name.text = item.name
            itemView.setOnClickListener { listener(item) }
        }
    }

}