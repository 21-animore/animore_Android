package org.techtown.animore

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class NormalCardAdapter(private val context: Context, var datas: MutableList<NormalCardData>) : RecyclerView.Adapter<NormalCardAdapter.Holder>() {

    override fun getItemCount(): Int {
        //Log.w("태그", datas.size.toString())
        return datas.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.normalcard_layout, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bind(datas[position], context)
        //Log.e("태그", position.toString())
    }

    inner class Holder(itemView: View):RecyclerView.ViewHolder(itemView) {

        val cardview = itemView.findViewById<CardView>(R.id.mainCard_view)

        val mission_name = itemView.findViewById<TextView>(R.id.tv_mission_name)
        val tv_normal = itemView.findViewById<TextView>(R.id.tv_normal)
        val mission_category_eng = itemView.findViewById<TextView>(R.id.tv_mission_category_eng)
        val tv_mission_category_kor = itemView.findViewById<TextView>(R.id.tv_mission_category_kor)
        val tv_achieve_count = itemView.findViewById<TextView>(R.id.tv_achieve_count)
        val tv_totalCount = itemView.findViewById<TextView>(R.id.tv_totalCount)
        val tv_count_num = itemView.findViewById<TextView>(R.id.tv_count_num)
        val tv_start_date = itemView.findViewById<TextView>(R.id.tv_start_date)
        val tv_end_date = itemView.findViewById<TextView>(R.id.tv_end_date)
        val tv_bottom = itemView.findViewById<TextView>(R.id.tv_bottom)

        val normal_index = itemView.findViewById<ImageView>(R.id.normal_index)
        val progressbar = itemView.findViewById<ImageView>(R.id.progressbar)
        val bottom_img = itemView.findViewById<ImageView>(R.id.bottom_img)

        val dailyCheckBtn = itemView.findViewById<ImageButton>(R.id.dailyCheckBtn)
        //android:backgroundTint="@color/complete_bengaltiger"
        //android:textColor="@color/back_bengaltiger"

        fun bind(NormalCardData1: NormalCardData, context: Context) {

            if (NormalCardData1.index ==0) {
                cardview.setCardBackgroundColor(ContextCompat.getColor(context, R.color.back_guanicoe))

                mission_name.setTextColor(ContextCompat.getColor(context, R.color.stroke_guanicoe))
                tv_normal.setTextColor(ContextCompat.getColor(context, R.color.stroke_guanicoe))
                mission_category_eng.setTextColor(ContextCompat.getColor(context, R.color.stroke_guanicoe))
                tv_mission_category_kor.setTextColor(ContextCompat.getColor(context, R.color.stroke_guanicoe))
                tv_achieve_count.setTextColor(ContextCompat.getColor(context, R.color.stroke_guanicoe))
                tv_totalCount.setTextColor(ContextCompat.getColor(context, R.color.stroke_guanicoe))
                tv_count_num.setTextColor(ContextCompat.getColor(context, R.color.back_guanicoe))
                tv_start_date.setTextColor(ContextCompat.getColor(context, R.color.stroke_guanicoe))
                tv_end_date.setTextColor(ContextCompat.getColor(context, R.color.stroke_guanicoe))
                tv_bottom.setTextColor(ContextCompat.getColor(context, R.color.stroke_guanicoe))

                normal_index.setImageResource(R.drawable.ic_normal_index_guanicoe)
                progressbar.setImageResource(R.drawable.ic_progressbar_stroke_guanicoe)
                bottom_img.setImageResource(R.drawable.ic_main_card_guanicoe)
                dailyCheckBtn.setBackgroundResource(R.drawable.ic_checkbtn_guanicoe)

            } else if(NormalCardData1.index==1){
                cardview.setCardBackgroundColor(ContextCompat.getColor(context, R.color.back_illipika))

                mission_name.setTextColor(ContextCompat.getColor(context, R.color.stroke_illipika))
                tv_normal.setTextColor(ContextCompat.getColor(context, R.color.stroke_illipika))
                mission_category_eng.setTextColor(ContextCompat.getColor(context, R.color.stroke_illipika))
                tv_mission_category_kor.setTextColor(ContextCompat.getColor(context, R.color.stroke_illipika))
                tv_achieve_count.setTextColor(ContextCompat.getColor(context, R.color.stroke_illipika))
                tv_totalCount.setTextColor(ContextCompat.getColor(context, R.color.stroke_illipika))
                tv_count_num.setTextColor(ContextCompat.getColor(context, R.color.back_illipika))
                tv_start_date.setTextColor(ContextCompat.getColor(context, R.color.stroke_illipika))
                tv_end_date.setTextColor(ContextCompat.getColor(context, R.color.stroke_illipika))
                tv_bottom.setTextColor(ContextCompat.getColor(context, R.color.stroke_illipika))

                normal_index.setImageResource(R.drawable.ic_normal_index_illipika)
                progressbar.setImageResource(R.drawable.ic_progressbar_stroke_illipika)
                bottom_img.setImageResource(R.drawable.ic_main_card_illipika)
                dailyCheckBtn.setBackgroundResource(R.drawable.ic_checkbtn_illipika)

            } else if(NormalCardData1.index==2){
                cardview.setCardBackgroundColor(ContextCompat.getColor(context, R.color.back_harpseal))

                mission_name.setTextColor(ContextCompat.getColor(context, R.color.stroke_harpseal))
                tv_normal.setTextColor(ContextCompat.getColor(context, R.color.stroke_harpseal))
                mission_category_eng.setTextColor(ContextCompat.getColor(context, R.color.stroke_harpseal))
                tv_mission_category_kor.setTextColor(ContextCompat.getColor(context, R.color.stroke_harpseal))
                tv_achieve_count.setTextColor(ContextCompat.getColor(context, R.color.stroke_harpseal))
                tv_totalCount.setTextColor(ContextCompat.getColor(context, R.color.stroke_harpseal))
                tv_count_num.setTextColor(ContextCompat.getColor(context, R.color.back_harpseal))
                tv_start_date.setTextColor(ContextCompat.getColor(context, R.color.stroke_harpseal))
                tv_end_date.setTextColor(ContextCompat.getColor(context, R.color.stroke_harpseal))
                tv_bottom.setTextColor(ContextCompat.getColor(context, R.color.stroke_harpseal))

                normal_index.setImageResource(R.drawable.ic_normal_index_harpseal)
                progressbar.setImageResource(R.drawable.ic_progressbar_stroke_harpseal)
                bottom_img.setImageResource(R.drawable.ic_main_card_harpseal)
                dailyCheckBtn.setBackgroundResource(R.drawable.ic_checkbtn_harpseal)

            }else if(NormalCardData1.index==3){
                cardview.setCardBackgroundColor(ContextCompat.getColor(context, R.color.back_java))

                mission_name.setTextColor(ContextCompat.getColor(context, R.color.stroke_java))
                tv_normal.setTextColor(ContextCompat.getColor(context, R.color.stroke_java))
                mission_category_eng.setTextColor(ContextCompat.getColor(context, R.color.stroke_java))
                tv_mission_category_kor.setTextColor(ContextCompat.getColor(context, R.color.stroke_java))
                tv_achieve_count.setTextColor(ContextCompat.getColor(context, R.color.stroke_java))
                tv_totalCount.setTextColor(ContextCompat.getColor(context, R.color.stroke_java))
                tv_count_num.setTextColor(ContextCompat.getColor(context, R.color.back_java))
                tv_start_date.setTextColor(ContextCompat.getColor(context, R.color.stroke_java))
                tv_end_date.setTextColor(ContextCompat.getColor(context, R.color.stroke_java))
                tv_bottom.setTextColor(ContextCompat.getColor(context, R.color.stroke_java))

                normal_index.setImageResource(R.drawable.ic_normal_index_java)
                progressbar.setImageResource(R.drawable.ic_progressbar_stroke_java)
                bottom_img.setImageResource(R.drawable.ic_main_card_java)
                dailyCheckBtn.setBackgroundResource(R.drawable.ic_checkbtn_java)

            }else if(NormalCardData1.index==4){
                cardview.setCardBackgroundColor(ContextCompat.getColor(context, R.color.back_bengaltiger))

                mission_name.setTextColor(ContextCompat.getColor(context, R.color.stroke_bengaltiger))
                tv_normal.setTextColor(ContextCompat.getColor(context, R.color.stroke_bengaltiger))
                mission_category_eng.setTextColor(ContextCompat.getColor(context, R.color.stroke_bengaltiger))
                tv_mission_category_kor.setTextColor(ContextCompat.getColor(context, R.color.stroke_bengaltiger))
                tv_achieve_count.setTextColor(ContextCompat.getColor(context, R.color.stroke_bengaltiger))
                tv_totalCount.setTextColor(ContextCompat.getColor(context, R.color.stroke_bengaltiger))
                tv_count_num.setTextColor(ContextCompat.getColor(context, R.color.back_bengaltiger))
                tv_start_date.setTextColor(ContextCompat.getColor(context, R.color.stroke_bengaltiger))
                tv_end_date.setTextColor(ContextCompat.getColor(context, R.color.stroke_bengaltiger))
                tv_bottom.setTextColor(ContextCompat.getColor(context, R.color.stroke_bengaltiger))

                normal_index.setImageResource(R.drawable.ic_normal_index_bengaltiger)
                progressbar.setImageResource(R.drawable.ic_progressbar_stroke_bengaltiger)
                bottom_img.setImageResource(R.drawable.ic_main_card_bengaltiger)
                dailyCheckBtn.setBackgroundResource(R.drawable.ic_checkbtn_bengal)

            }

            mission_name.text = NormalCardData1.mission_name;
            //mission_category_eng.text = NormalCardData.mission_category_eng;

        /*
        val achieve_count = itemView.findViewById<TextView>(R.id.tv_achieve_count)
        val count_num = itemView.findViewById<TextView>(R.id.tv_count_num)
        val start_date = itemView.findViewById<TextView>(R.id.tv_start_date)
        val end_date = itemView.findViewById<TextView>(R.id.tv_end_date)

        achieve_count.text = NormalCardData.achieve_count.toString();
        count_num.text = NormalCardData.count_num.toString();
        start_date.text = NormalCardData.start_date.toString();
        end_date.text = NormalCardData.end_date.toString();
        */

        }
    }
}