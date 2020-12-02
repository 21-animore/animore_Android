package org.techtown.animore

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class HomeMoreCardAdapter: RecyclerView.Adapter<HomeMoreCardAdapter.Holder>(){
    var homemoreitems = mutableListOf<HomeMoreCardData>()

    override fun getItemCount(): Int {
        return homemoreitems.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.more_card_front_layout, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(homemoreitems[position])
    }

    inner class Holder(itemView: View):RecyclerView.ViewHolder(itemView) {

        fun bind(HomeMoreCardData: HomeMoreCardData) {

            //유형별 달라지는 부분
            if(HomeMoreCardData.index === 0){

            }else if(HomeMoreCardData.index === 1){

            }else if(HomeMoreCardData.index === 2){

            }else if(HomeMoreCardData.index === 3){

            }else if(HomeMoreCardData.index === 4){

            }
        }
    }
}