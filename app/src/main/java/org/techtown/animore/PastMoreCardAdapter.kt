package org.techtown.animore

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class PastMoreCardAdapter() : RecyclerView.Adapter<PastMoreCardAdapter.Holder>(){
    var dataPasts = mutableListOf<PastMoreCardData>()

    override fun getItemCount(): Int {
        Log.e("길이", dataPasts.size.toString());
        return dataPasts.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.past_more_card_layout, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bind(dataPasts[position])
        //Log.e("태그", position.toString())
    }

    inner class Holder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val cardview = itemView.findViewById<CardView>(R.id.past_card_more_insdie_view)
        val fail = itemView.findViewById<ImageView>(R.id.past_card_more_fail)
        val success = itemView.findViewById<ImageView>(R.id.past_card_more_success)

        val img = itemView.findViewById<ImageView>(R.id.past_card_more_img)
        val stroke = itemView.findViewById<ImageView>(R.id.past_card_more_stroke)

        val tv_top_category = itemView.findViewById<TextView>(R.id.past_card_more_tv_top_category)
        val tv_count_num_behind = itemView.findViewById<TextView>(R.id.past_card_more_tv_count_num_behind)
        val tv_mission_name = itemView.findViewById<TextView>(R.id.past_card_more_tv_mission_name)
        val tv_mission_total_count = itemView.findViewById<TextView>(R.id.past_card_more_tv_mission_total_count)
        val tv_mission_category_eng = itemView.findViewById<TextView>(R.id.past_card_more_tv_mission_category_eng)
        val tv_mission_category_kor = itemView.findViewById<TextView>(R.id.past_card_more_tv_mission_category_kor)
        val tv_achieve_count = itemView.findViewById<TextView>(R.id.past_card_more_tv_achieve_count)
        val tv_start_date_title = itemView.findViewById<TextView>(R.id.past_card_more_tv_start_date_title)
        val tv_end_date_title = itemView.findViewById<TextView>(R.id.past_card_more_tv_end_date_title)
        val tv_achieve_count_num = itemView.findViewById<TextView>(R.id.past_card_more_tv_achieve_count_num)
        val tv_times = itemView.findViewById<TextView>(R.id.past_card_more_tv_times)
        val tv_start_date = itemView.findViewById<TextView>(R.id.past_card_more_tv_start_date)
        val tv_end_date = itemView.findViewById<TextView>(R.id.past_card_more_tv_end_date)
        val tv_process = itemView.findViewById<TextView>(R.id.past_card_more_tv_process)
        val tv_process_count = itemView.findViewById<TextView>(R.id.past_card_more_tv_process_count)
        val tv_count_slash = itemView.findViewById<TextView>(R.id.past_card_more_tv_count_slash)
        val tv_total_count = itemView.findViewById<TextView>(R.id.past_card_more_tv_total_count)
        val tv_mission_content = itemView.findViewById<TextView>(R.id.past_card_more_tv_mission_content)
        val tv_bottom_sentence = itemView.findViewById<TextView>(R.id.past_card_more_tv_bottom_sentence)

        val progressbar = itemView.findViewById<ProgressBar>(R.id.past_card_more_progressbar)


        fun bind(PastMoreCardData: PastMoreCardData) {

            /*----------------------------------미션마다 다른 정보 우선 배정--------------------------------------------*/
            //카드에 보이게 되는 정보들
            tv_mission_name.text = PastMoreCardData.mission_name
            tv_mission_total_count.text = PastMoreCardData.dayDuring.toString()
            tv_start_date.text = PastMoreCardData.start_date
            tv_end_date.text = PastMoreCardData.end_date
            tv_achieve_count_num.text = PastMoreCardData.count.toString()
            tv_process_count.text = PastMoreCardData.count.toString()
            tv_total_count.text = PastMoreCardData.dayDuring.toString()
            tv_mission_content.text = PastMoreCardData.mission_expression
            tv_count_num_behind.text = PastMoreCardData.dayDuring.toString()

            var count_for_progressbar = PastMoreCardData.count.toFloat()/PastMoreCardData.dayDuring*100
            var int = count_for_progressbar.toInt()
            progressbar.progress = int


            if(PastMoreCardData.success_flag === true){
                //성공 카드일 경우
                fail.setVisibility(View.GONE)
            }else{
                //실패 카드일 경우
                success.setVisibility(View.GONE)
            }


            if(PastMoreCardData.index === 0){
                cardview.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.back_guanicoe))
                tv_mission_category_eng.text="Spending Habit"
                tv_mission_category_kor.text="소비 습관 개선"
                tv_bottom_sentence.text="Think one more"

                tv_top_category.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                tv_count_num_behind.setTextColor(ContextCompat.getColor(itemView.context, R.color.blur_guanicoe))
                tv_mission_name.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                tv_mission_total_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.back_guanicoe))
                tv_mission_category_eng.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                tv_mission_category_kor.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                tv_achieve_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                tv_start_date_title.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                tv_end_date_title.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                tv_achieve_count_num.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                tv_times.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                tv_start_date.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                tv_end_date.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                tv_process.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                tv_process_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                tv_count_slash.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                tv_total_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                tv_mission_content.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                tv_bottom_sentence.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))

                progressbar.setProgressDrawableTiled(ContextCompat.getDrawable(itemView.context, R.drawable.progressbar_guanicoe))

                if(PastMoreCardData.flag === true) {
                    if(PastMoreCardData.dayDuring === 7) {
                        img.setImageResource(R.drawable.ic_home_more_card_back_7_guanicoe)
                        stroke.visibility = View.GONE;
                        tv_top_category.text = "연속 7일"
                    }else if(PastMoreCardData.dayDuring === 14) {
                        img.setImageResource(R.drawable.ic_home_more_card_back_14_guanicoe)
                        stroke.visibility = View.GONE;
                        tv_top_category.text = "연속 14일"
                    }else if(PastMoreCardData.dayDuring === 21) {
                        img.setImageResource(R.drawable.ic_home_more_card_back_21_guanicoe)
                        stroke.setImageResource(R.drawable.ic_home_more_card_stroke_guanicoe)
                        tv_top_category.text = "연속 21일"
                    }
                }else {
                    img.setImageResource(R.drawable.ic_home_more_card_back_0_guanicoe)
                    stroke.visibility = View.GONE;
                    tv_top_category.text = "일반"
                    tv_count_num_behind.visibility = View.GONE;
                }



            }else if(PastMoreCardData.index === 1){
                cardview.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.back_illipika))
                tv_mission_category_eng.text="Saving Electricity"
                tv_mission_category_kor.text="전기 절약"
                tv_bottom_sentence.text="Not yours, Ours"


                tv_top_category.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                tv_count_num_behind.setTextColor(ContextCompat.getColor(itemView.context, R.color.blur_illipika))
                tv_mission_name.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                tv_mission_total_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.back_illipika))
                tv_mission_category_eng.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                tv_mission_category_kor.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                tv_achieve_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                tv_start_date_title.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                tv_end_date_title.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                tv_achieve_count_num.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                tv_times.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                tv_start_date.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                tv_end_date.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                tv_process.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                tv_process_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                tv_count_slash.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                tv_total_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                tv_mission_content.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                tv_bottom_sentence.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))

                progressbar.setProgressDrawableTiled(ContextCompat.getDrawable(itemView.context, R.drawable.progressbar_illipika))

                if(PastMoreCardData.flag === true) {
                    if(PastMoreCardData.dayDuring === 7) {
                        img.setImageResource(R.drawable.ic_home_more_card_back_7_illipika)
                        stroke.visibility = View.GONE;
                        tv_top_category.text = "연속 7일"
                    }else if(PastMoreCardData.dayDuring === 14) {
                        img.setImageResource(R.drawable.ic_home_more_card_back_14_illipika)
                        stroke.visibility = View.GONE;
                        tv_top_category.text = "연속 14일"
                    }else if(PastMoreCardData.dayDuring === 21) {
                        img.setImageResource(R.drawable.ic_home_more_card_back_21_illipika)
                        stroke.setImageResource(R.drawable.ic_home_more_card_stroke_illipika)
                        tv_top_category.text = "연속 21일"
                    }
                }else {
                    img.setImageResource(R.drawable.ic_home_more_card_back_0_illipika)
                    stroke.visibility = View.GONE;
                    tv_top_category.text = "일반"
                    tv_count_num_behind.visibility = View.GONE;
                }


            }else if(PastMoreCardData.index === 2){
                cardview.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.back_harpseal))
                tv_mission_category_eng.text="Reduce Trash"
                tv_mission_category_kor.text="쓰레기 배출량 감소"
                tv_bottom_sentence.text="Our Planet"


                tv_top_category.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                tv_count_num_behind.setTextColor(ContextCompat.getColor(itemView.context, R.color.blur_harpseal))
                tv_mission_name.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                tv_mission_total_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.back_harpseal))
                tv_mission_category_eng.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                tv_mission_category_kor.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                tv_achieve_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                tv_start_date_title.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                tv_end_date_title.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                tv_achieve_count_num.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                tv_times.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                tv_start_date.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                tv_end_date.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                tv_process.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                tv_process_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                tv_count_slash.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                tv_total_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                tv_mission_content.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                tv_bottom_sentence.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))

                progressbar.setProgressDrawableTiled(ContextCompat.getDrawable(itemView.context, R.drawable.progressbar_harpseal))

                if(PastMoreCardData.flag === true) {
                    if(PastMoreCardData.dayDuring === 7) {
                        img.setImageResource(R.drawable.ic_home_more_card_back_7_harpseal)
                        stroke.visibility = View.GONE;
                        tv_top_category.text = "연속 7일"
                    }else if(PastMoreCardData.dayDuring === 14) {
                        img.setImageResource(R.drawable.ic_home_more_card_back_14_harpseal)
                        stroke.visibility = View.GONE;
                        tv_top_category.text = "연속 14일"
                    }else if(PastMoreCardData.dayDuring === 21) {
                        img.setImageResource(R.drawable.ic_home_more_card_back_21_harpseal)
                        stroke.setImageResource(R.drawable.ic_home_more_card_stroke_harpseal)
                        tv_top_category.text = "연속 21일"
                    }
                }else {
                    img.setImageResource(R.drawable.ic_home_more_card_back_0_harpseal)
                    stroke.visibility = View.GONE;
                    tv_top_category.text = "일반"
                    tv_count_num_behind.visibility = View.GONE;
                }



            }else if(PastMoreCardData.index === 3){
                cardview.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.back_java))
                tv_mission_category_eng.text="Paperless"
                tv_mission_category_kor.text="페이퍼리스"
                tv_bottom_sentence.text="For treeeeeee"

                tv_top_category.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                tv_count_num_behind.setTextColor(ContextCompat.getColor(itemView.context, R.color.blur_java))
                tv_mission_name.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                tv_mission_total_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.back_java))
                tv_mission_category_eng.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                tv_mission_category_kor.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                tv_achieve_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                tv_start_date_title.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                tv_end_date_title.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                tv_achieve_count_num.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                tv_times.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                tv_start_date.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                tv_end_date.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                tv_process.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                tv_process_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                tv_count_slash.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                tv_total_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                tv_mission_content.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                tv_bottom_sentence.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))

                progressbar.setProgressDrawableTiled(ContextCompat.getDrawable(itemView.context, R.drawable.progressbar_java))

                if(PastMoreCardData.flag === true) {
                    if(PastMoreCardData.dayDuring === 7) {
                        img.setImageResource(R.drawable.ic_home_more_card_back_7_java)
                        stroke.visibility = View.GONE;
                        tv_top_category.text = "연속 7일"
                    }else if(PastMoreCardData.dayDuring === 14) {
                        img.setImageResource(R.drawable.ic_home_more_card_back_14_java)
                        stroke.visibility = View.GONE;
                        tv_top_category.text = "연속 14일"
                    }else if(PastMoreCardData.dayDuring === 21) {
                        img.setImageResource(R.drawable.ic_home_more_card_back_21_java)
                        stroke.setImageResource(R.drawable.ic_home_more_card_stroke_java)
                        tv_top_category.text = "연속 21일"
                    }
                }else {
                    img.setImageResource(R.drawable.ic_home_more_card_back_0_java)
                    stroke.visibility = View.GONE;
                    tv_top_category.text = "일반"
                    tv_count_num_behind.visibility = View.GONE;
                }


            }else if(PastMoreCardData.index === 4){
                cardview.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.back_bengaltiger))
                tv_mission_category_eng.text="Living Habit"
                tv_mission_category_kor.text="생활 습관 개선"
                tv_bottom_sentence.text="YOU&I"

                tv_top_category.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                tv_count_num_behind.setTextColor(ContextCompat.getColor(itemView.context, R.color.blur_bengal))
                tv_mission_name.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                tv_mission_total_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.back_bengaltiger))
                tv_mission_category_eng.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                tv_mission_category_kor.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                tv_achieve_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                tv_start_date_title.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                tv_end_date_title.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                tv_achieve_count_num.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                tv_times.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                tv_start_date.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                tv_end_date.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                tv_process.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                tv_process_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                tv_count_slash.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                tv_total_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                tv_mission_content.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                tv_bottom_sentence.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))

                progressbar.setProgressDrawableTiled(ContextCompat.getDrawable(itemView.context, R.drawable.progressbar_bengal))

                if(PastMoreCardData.flag === true) {
                    if(PastMoreCardData.dayDuring === 7) {
                        img.setImageResource(R.drawable.ic_home_more_card_back_7_bengal)
                        stroke.visibility = View.GONE;
                        tv_top_category.text = "연속 7일"
                    }else if(PastMoreCardData.dayDuring === 14) {
                        img.setImageResource(R.drawable.ic_home_more_card_back_14_bengal)
                        stroke.visibility = View.GONE;
                        tv_top_category.text = "연속 14일"
                    }else if(PastMoreCardData.dayDuring === 21) {
                        img.setImageResource(R.drawable.ic_home_more_card_back_21_bengal)
                        stroke.setImageResource(R.drawable.ic_home_more_card_stroke_bengal)
                        tv_top_category.text = "연속 21일"
                    }
                }else {
                    img.setImageResource(R.drawable.ic_home_more_card_back_0_bengal)
                    stroke.visibility = View.GONE;
                    tv_top_category.text = "일반"
                    tv_count_num_behind.visibility = View.GONE;
                }
            }
        }
    }
}