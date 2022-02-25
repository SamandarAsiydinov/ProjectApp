package com.example.amazonuiclone.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.amazonuiclone.model.Essential
import com.example.projectforexam.R

class FavouriteAdapter(val context: Context, val items: ArrayList<Essential>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed, parent, false)
        return EessantionalViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]

        if (holder is EessantionalViewHolder) {

            var tv_tiitle = holder.tv_tittle
            var image = holder.image

            image.setImageResource(item.img)
            tv_tiitle.text = item.tittle

        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class EessantionalViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tv_tittle = view.findViewById<TextView>(R.id.tv_tittle)
        val image = view.findViewById<ImageView>(R.id.iv_img)


    }
}