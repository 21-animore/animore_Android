package org.techtown.animore

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class MoreCardTopBarAdapter(private val context : Context, var dataPasts: MutableList<MoreCardTopBarData>) : RecyclerView.Adapter<MoreCardTopBarAdapter.Holder>(){
    override fun getItemCount(): Int {
        //Log.w("태그", datas.size.toString())
        return dataPasts.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoreCardTopBarAdapter.Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.pastcard_layout, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: MoreCardTopBarAdapter.Holder, position: Int) {
        holder?.bind(dataPasts[position], context)
        //Log.e("태그", position.toString())
    }

    inner class Holder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val cardview = itemView.findViewById<CardView>(R.id.more_card_back_view)

        //배경이미지
        //글씨 이름
        //글씨 내용
        //버튼 색(이미지)


        fun bind(MoreCardTopBar: MoreCardTopBarData, context: Context) {

                if(MoreCardTopBar.index === 0){

                }else if(MoreCardTopBar.index === 1){

                }else if(MoreCardTopBar.index === 2){

                }else if(MoreCardTopBar.index === 3){

                }else if(MoreCardTopBar.index === 4){

                }
        }
    }


}