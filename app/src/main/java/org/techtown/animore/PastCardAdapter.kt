package org.techtown.animore

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PastCardAdapter(private val context : Context) : RecyclerView.Adapter<PastCardViewHolder>(){
    var datas:MutableList<PastCardData> = mutableListOf<PastCardData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PastCardViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.pastcard_layout, parent,false)
        return PastCardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: PastCardViewHolder, position: Int) {
        holder.bind(datas[position])
    }
}