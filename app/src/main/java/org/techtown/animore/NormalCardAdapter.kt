package org.techtown.animore

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class NormalCardAdapter(private val context : Context) : RecyclerView.Adapter<NormalCardViewHolder>() {
    var datas:MutableList<NormalCardData> = mutableListOf<NormalCardData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NormalCardViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.normal_card_layout, parent,false)
        return NormalCardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: NormalCardViewHolder, position: Int) {
        holder.bind(datas[position])
    }

}