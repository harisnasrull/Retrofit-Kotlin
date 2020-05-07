package com.example.retrofittrial

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PhotoAdapter (val context: Context, var photos: List<Photo>) :
    RecyclerView.Adapter<PhotoAdapter.ViewHolder>(){

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var imageAlbum: ImageView? = null
        var textTittle: TextView? = null
        var textUrl: TextView? = null

        init {
            imageAlbum = itemView.findViewById(R.id.image_album)
            textTittle = itemView.findViewById(R.id.text_title)
            textUrl = itemView.findViewById(R.id.text_url)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view: View = layoutInflater.inflate(R.layout.photo_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textTittle?.text = photos[position].author
        holder.textUrl?.text = photos[position].name
        Glide.with(context)
            .load(photos[position].avatar)
            .into(holder.imageAlbum!!)
    }

    fun setData(photList: List<Photo>){
        this.photos = photList
        notifyDataSetChanged()
    }
}