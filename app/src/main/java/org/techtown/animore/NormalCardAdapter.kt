package org.techtown.animore

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class NormalCardAdapter(private val context : Context,var datas:MutableList<NormalCardData> )
    : RecyclerView.Adapter<NormalCardAdapter.Holder>() {
  //  var datas:MutableList<NormalCardData> = mutableListOf<NormalCardData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.normalcard_layout_bengal, parent,false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {

        holder?.bind(datas[position],context)
    }

    inner class Holder(itemView: View):RecyclerView.ViewHolder(itemView) {

        val mission_name = itemView.findViewById<TextView>(R.id.tv_mission_name)
        val achieve_count = itemView.findViewById<TextView>(R.id.tv_achieve_count)
        val count_num = itemView.findViewById<TextView>(R.id.tv_count_num)
        val start_date = itemView.findViewById<TextView>(R.id.tv_start_date)
        val end_date = itemView.findViewById<TextView>(R.id.tv_end_date)

        val cardview = itemView.findViewById<CardView>(R.id.mainCard_view)
        val cardimg= itemView.findViewById<ImageView>(R.id.bottom_img)


        fun bind(NormalCardData: NormalCardData,context:Context) {
            if (NormalCardData.index ==0) {
                cardview.setCardBackgroundColor(ContextCompat.getColor(context, R.color.back_bengaltiger))
                cardimg.setImageResource(R.drawable.ic_main_card_guanicoe)
            }
            else if(NormalCardData.index==1){

                cardview.setCardBackgroundColor(ContextCompat.getColor(context, R.color.back_guanicoe))
                cardimg.setImageResource(R.drawable.ic_main_card_harpseal)
            }
            mission_name.text = NormalCardData.mission_name;
            //    achieve_count.text = NormalCardData.achieve_count.toString();
            //    count_num.text = NormalCardData.count_num.toString();
            //   start_date.text = NormalCardData.start_date.toString();
            //     end_date.text = NormalCardData.end_date.toString();
        }
    }
}