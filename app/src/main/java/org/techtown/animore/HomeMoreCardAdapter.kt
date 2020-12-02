package org.techtown.animore

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
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
        val outside = itemView.findViewById<CardView>(R.id.past_card_more_view)
        val fail = itemView.findViewById<ImageView>(R.id.past_card_more_fail)
        val success = itemView.findViewById<ImageView>(R.id.past_card_more_success)


        fun bind(HomeMoreCardData: HomeMoreCardData) {

            if(HomeMoreCardData.success_flag === true){
                //성공 카드일 경우
                fail.setVisibility(View.GONE)

                if(HomeMoreCardData.index === 0){

                }else if(HomeMoreCardData.index === 1){

                }else if(HomeMoreCardData.index === 2){

                }else if(HomeMoreCardData.index === 3){

                }else if(HomeMoreCardData.index === 4){

                }

            }else{
                //실패 카드일 경우
                success.setVisibility(View.GONE)

                if(HomeMoreCardData.index === 0){

                }else if(HomeMoreCardData.index === 1){

                }else if(HomeMoreCardData.index === 2){

                }else if(HomeMoreCardData.index === 3){

                }else if(HomeMoreCardData.index === 4){

                }
            }
        }
    }
}