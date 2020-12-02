package org.techtown.animore

import android.content.Context
import android.graphics.Color
import android.media.Image
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
import kotlinx.android.synthetic.main.pastcard_layout.view.*

class PastCardAdapter(private val context : Context, var datas: MutableList<PastCardData>) : RecyclerView.Adapter<PastCardAdapter.Holder>(){
    override fun getItemCount(): Int {
        //Log.w("태그", datas.size.toString())
        return datas.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PastCardAdapter.Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.pastcard_layout, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: PastCardAdapter.Holder, position: Int) {
        holder?.bind(datas[position], context)
        //Log.e("태그", position.toString())
    }

    inner class Holder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val cardview = itemView.findViewById<CardView>(R.id.pastcard_view)
        val fail_cover = itemView.findViewById<ImageView>(R.id.pastcard_fail_cover)
        val success_stroke = itemView.findViewById<ImageView>(R.id.pastcard_success_stroke)
        val img = itemView.findViewById<ImageView>(R.id.pastcard_img_card_category)
        val back = itemView.findViewById<ImageView>(R.id.pastcard_background)

        val successful_flag = itemView.findViewById<TextView>(R.id.pastcard_tv_successFlag)
        val tv_cardName = itemView.findViewById<TextView>(R.id.pastcard_tv_cardName)
        val tv_achieveCount = itemView.findViewById<TextView>(R.id.pastcard_tv_achieveCount)
        val tv_totalCount = itemView.findViewById<TextView>(R.id.pastcard_tv_totalCount)
        val tv_period = itemView.findViewById<TextView>(R.id.pastcard_tv_period)

        fun bind(PastCardData: PastCardData, context: Context) {
            if(PastCardData.success_flag === true){
                //성공 카드일 경우
                successful_flag.text = "COMPLETE"
                fail_cover.setVisibility(View.GONE)

                if(PastCardData.index === 0){
                    back.setImageResource(R.drawable.ic_pastcard_back_guanicoe)
                    successful_flag.setTextColor(ContextCompat.getColor(context, R.color.complete_guanicoe))
                    img.setImageResource(R.drawable.ic_past_card_guanicoe)
                    success_stroke.setImageResource(R.drawable.ic_pastcard_stroke_guanicoe)
                    tv_cardName.setTextColor(ContextCompat.getColor(context, R.color.stroke_guanicoe))
                    tv_achieveCount.setTextColor(ContextCompat.getColor(context, R.color.stroke_guanicoe))
                    tv_totalCount.setTextColor(ContextCompat.getColor(context, R.color.stroke_guanicoe))
                    tv_period.setTextColor(ContextCompat.getColor(context, R.color.stroke_guanicoe))
                }else if(PastCardData.index === 1){
                    back.setImageResource(R.drawable.ic_pastcard_back_illipika)
                    successful_flag.setTextColor(ContextCompat.getColor(context, R.color.complete_illipika))
                    img.setImageResource(R.drawable.ic_past_card_illipika)
                    success_stroke.setImageResource(R.drawable.ic_pastcard_stroke_illipika)
                    tv_cardName.setTextColor(ContextCompat.getColor(context, R.color.stroke_illipika))
                    tv_achieveCount.setTextColor(ContextCompat.getColor(context, R.color.stroke_illipika))
                    tv_totalCount.setTextColor(ContextCompat.getColor(context, R.color.stroke_illipika))
                    tv_period.setTextColor(ContextCompat.getColor(context, R.color.stroke_illipika))
                }else if(PastCardData.index === 2){
                    back.setImageResource(R.drawable.ic_pastcard_back_harpseal)
                    successful_flag.setTextColor(ContextCompat.getColor(context, R.color.complete_harpseal))
                    img.setImageResource(R.drawable.ic_past_card_harpseal)
                    success_stroke.setImageResource(R.drawable.ic_pastcard_stroke_harpseal)
                    tv_cardName.setTextColor(ContextCompat.getColor(context, R.color.stroke_harpseal))
                    tv_achieveCount.setTextColor(ContextCompat.getColor(context, R.color.stroke_harpseal))
                    tv_totalCount.setTextColor(ContextCompat.getColor(context, R.color.stroke_harpseal))
                    tv_period.setTextColor(ContextCompat.getColor(context, R.color.stroke_harpseal))
                }else if(PastCardData.index === 3){
                    back.setImageResource(R.drawable.ic_pastcard_back_java)
                    successful_flag.setTextColor(ContextCompat.getColor(context, R.color.complete_java))
                    img.setImageResource(R.drawable.ic_past_card_java)
                    success_stroke.setImageResource(R.drawable.ic_pastcard_stroke_java)
                    tv_cardName.setTextColor(ContextCompat.getColor(context, R.color.stroke_java))
                    tv_achieveCount.setTextColor(ContextCompat.getColor(context, R.color.stroke_java))
                    tv_totalCount.setTextColor(ContextCompat.getColor(context, R.color.stroke_java))
                    tv_period.setTextColor(ContextCompat.getColor(context, R.color.stroke_java))
                }else if(PastCardData.index === 4){
                    back.setImageResource(R.drawable.ic_pastcard_back_bengal)
                    successful_flag.setTextColor(ContextCompat.getColor(context, R.color.complete_bengaltiger))
                    img.setImageResource(R.drawable.ic_past_card_bengaltiger)
                    success_stroke.setImageResource(R.drawable.ic_pastcard_stroke_bengal)
                    tv_cardName.setTextColor(ContextCompat.getColor(context, R.color.stroke_bengaltiger))
                    tv_achieveCount.setTextColor(ContextCompat.getColor(context, R.color.stroke_bengaltiger))
                    tv_totalCount.setTextColor(ContextCompat.getColor(context, R.color.stroke_bengaltiger))
                    tv_period.setTextColor(ContextCompat.getColor(context, R.color.stroke_bengaltiger))
                }

            }else{
                //실패 카드일 경우
                successful_flag.text = ""
                success_stroke.setVisibility(View.GONE)

                if(PastCardData.index === 0){
                    back.setImageResource(R.drawable.ic_pastcard_back_guanicoe)
                    img.setImageResource(R.drawable.ic_past_card_guanicoe)
                    tv_cardName.setTextColor(ContextCompat.getColor(context, R.color.stroke_guanicoe))
                    tv_achieveCount.setTextColor(ContextCompat.getColor(context, R.color.stroke_guanicoe))
                    tv_totalCount.setTextColor(ContextCompat.getColor(context, R.color.stroke_guanicoe))
                    tv_period.setTextColor(ContextCompat.getColor(context, R.color.stroke_guanicoe))
                }else if(PastCardData.index === 1){
                    back.setImageResource(R.drawable.ic_pastcard_back_illipika)
                    img.setImageResource(R.drawable.ic_past_card_illipika)
                    tv_cardName.setTextColor(ContextCompat.getColor(context, R.color.stroke_illipika))
                    tv_achieveCount.setTextColor(ContextCompat.getColor(context, R.color.stroke_illipika))
                    tv_totalCount.setTextColor(ContextCompat.getColor(context, R.color.stroke_illipika))
                    tv_period.setTextColor(ContextCompat.getColor(context, R.color.stroke_illipika))
                }else if(PastCardData.index === 2){
                    back.setImageResource(R.drawable.ic_pastcard_back_harpseal)
                    img.setImageResource(R.drawable.ic_past_card_harpseal)
                    tv_cardName.setTextColor(ContextCompat.getColor(context, R.color.stroke_harpseal))
                    tv_achieveCount.setTextColor(ContextCompat.getColor(context, R.color.stroke_harpseal))
                    tv_totalCount.setTextColor(ContextCompat.getColor(context, R.color.stroke_harpseal))
                    tv_period.setTextColor(ContextCompat.getColor(context, R.color.stroke_harpseal))
                }else if(PastCardData.index === 3){
                    back.setImageResource(R.drawable.ic_pastcard_back_java)
                    img.setImageResource(R.drawable.ic_past_card_java)
                    tv_cardName.setTextColor(ContextCompat.getColor(context, R.color.stroke_java))
                    tv_achieveCount.setTextColor(ContextCompat.getColor(context, R.color.stroke_java))
                    tv_totalCount.setTextColor(ContextCompat.getColor(context, R.color.stroke_java))
                    tv_period.setTextColor(ContextCompat.getColor(context, R.color.stroke_java))
                }else if(PastCardData.index === 4){
                    back.setImageResource(R.drawable.ic_pastcard_back_bengal)
                    img.setImageResource(R.drawable.ic_past_card_bengaltiger)
                    tv_cardName.setTextColor(ContextCompat.getColor(context, R.color.stroke_bengaltiger))
                    tv_achieveCount.setTextColor(ContextCompat.getColor(context, R.color.stroke_bengaltiger))
                    tv_totalCount.setTextColor(ContextCompat.getColor(context, R.color.stroke_bengaltiger))
                    tv_period.setTextColor(ContextCompat.getColor(context, R.color.stroke_bengaltiger))
                }
            }
        }
    }


}