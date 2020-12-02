package org.techtown.animore

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MainCardAdapter : RecyclerView.Adapter<MainCardAdapter.Holder>() {
    var datas = mutableListOf<MainCardData>()

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.maincard_layout, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(datas[position])
    }

    inner class Holder(itemView: View):RecyclerView.ViewHolder(itemView) {

        //캘린더
        val calendarView: RecyclerView = itemView.findViewById(R.id.maincard_calendar_normalcard_layout)
        val calendarRvAdapter = CalendarAdapter()

        fun createCalendar(dayDuring: Int){
            val calendar = Calendar.getInstance()
            var date = calendar.get(Calendar.DATE)
            //해당 월 마지막 날
            val day = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
            val dayday = calendar.get(Calendar.DAY_OF_WEEK).toString()
            Log.d("오늘은", date.toString() +"일입니다! 마지막날:"+ day.toString() +"데이데이" + dayday)

            var count = 0

            for(i in 1 until dayday.toInt()){
                calendarRvAdapter.items.add(0)
                count++
            }

            //총 입력받은 기간 수(7/14/21) 번 반복해야 함
            for(i in 1..dayDuring){
                calendarRvAdapter.items.add(date)
                date += 1
                if(date > day){
                    date = 1
                }
            }

            for(i in 1..7-count){
                calendarRvAdapter.items.add(0)
            }
            calendarView.adapter = calendarRvAdapter
        }

        //사용할 변수 선언
        val cardview = itemView.findViewById<CardView>(R.id.maincard_view)

        val tv_mission_name = itemView.findViewById<TextView>(R.id.maincard_tv_mission_name)
        val tv_top_category = itemView.findViewById<TextView>(R.id.maincard_tv_top_category)
        val tv_mission_category_eng = itemView.findViewById<TextView>(R.id.maincard_tv_mission_category_eng)
        val tv_mission_category_kor = itemView.findViewById<TextView>(R.id.maincard_tv_mission_category_kor)
        val tv_achieve_count = itemView.findViewById<TextView>(R.id.maincard_tv_achieve_count)
        val tv_totalCount = itemView.findViewById<TextView>(R.id.maincard_tv_totalCount)
        val tv_index_count_num = itemView.findViewById<TextView>(R.id.maincard_tv_index_count_num)
        val tv_start_date = itemView.findViewById<TextView>(R.id.maincard_tv_start_date)
        val tv_end_date = itemView.findViewById<TextView>(R.id.maincard_tv_end_date)
        val tv_bottom = itemView.findViewById<TextView>(R.id.maincard_tv_bottom)
        val dailyCheckBtn = itemView.findViewById<ImageButton>(R.id.maincard_dailyCheckBtn)

        val normal_index = itemView.findViewById<ImageView>(R.id.maincard_normal_index)
        val progressbar = itemView.findViewById<ImageView>(R.id.maincard_progressbar)
        val bottom_img = itemView.findViewById<ImageView>(R.id.maincard_bottom_img)

        val mon = itemView.findViewById<TextView>(R.id.maincard_tv_day_mon)
        val tue = itemView.findViewById<TextView>(R.id.maincard_tv_day_tue)
        val wed = itemView.findViewById<TextView>(R.id.maincard_tv_day_wed)
        val thu = itemView.findViewById<TextView>(R.id.maincard_tv_day_thu)
        val fri = itemView.findViewById<TextView>(R.id.maincard_tv_day_fri)
        val sat = itemView.findViewById<TextView>(R.id.maincard_tv_day_sat)
        val sun = itemView.findViewById<TextView>(R.id.maincard_tv_day_sun)

        val stroke21 = itemView.findViewById<ImageView>(R.id.maincard_continue_21_stroke)

        fun bind(MainCardData: MainCardData) {

            if(MainCardData.flag){
                //연속 카드라면
                
                //일반 카드 요소들 숨기기
                progressbar.visibility = View.GONE
                tv_totalCount.visibility = View.GONE;
                tv_achieve_count.visibility = View.GONE;
                normal_index.visibility = View.GONE;
                tv_index_count_num.visibility = View.GONE;
                tv_start_date.visibility = View.GONE;
                tv_end_date.visibility = View.GONE;

                //캘린더 그리기
                createCalendar(MainCardData.dayDuring)

                /*----------------------------------연속 카드 일수별로 다른 요소 변경--------------------------------------------*/
                
                if (MainCardData.index ==0) {

                    //유형 변경
                    tv_mission_category_eng.text="Spending Habit"
                    tv_mission_category_kor.text="소비 습관 개선"
                    tv_bottom.text="Think one more"

                    //색 변경
                    cardview.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.back_guanicoe))
                    tv_mission_name.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))     //내용변경
                    tv_top_category.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                    tv_mission_category_eng.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                    tv_mission_category_kor.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                    tv_bottom.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                    mon.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                    tue.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                    wed.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                    thu.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                    fri.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                    sat.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                    sun.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                    dailyCheckBtn.setImageResource(R.drawable.ic_checkbtn_guanicoe)

                    //나중에 캘린더 점선 실선 글씨 색 바꾸기

                } else if(MainCardData.index==1){

                    //유형 변경
                    tv_mission_category_eng.text="Saving Electricity"
                    tv_mission_category_kor.text="전기 절약"
                    tv_bottom.text="Not yours, Ours"

                    //색 변경
                    cardview.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.back_illipika))
                    tv_mission_name.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))     //내용변경
                    tv_top_category.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                    tv_mission_category_eng.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                    tv_mission_category_kor.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                    tv_bottom.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                    mon.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                    tue.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                    wed.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                    thu.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                    fri.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                    sat.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                    sun.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                    dailyCheckBtn.setImageResource(R.drawable.ic_checkbtn_illipika)

                    //나중에 캘린더 점선 실선 글씨 색 바꾸기


                } else if(MainCardData.index==2){

                    //유형 변경
                    tv_mission_category_eng.text="Reduce Trash"
                    tv_mission_category_kor.text="쓰레기 배출량 감소"
                    tv_bottom.text="Our Planet"

                    //색 변경
                    cardview.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.back_harpseal))
                    tv_mission_name.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))     //내용변경
                    tv_top_category.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                    tv_mission_category_eng.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                    tv_mission_category_kor.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                    tv_bottom.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                    mon.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                    tue.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                    wed.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                    thu.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                    fri.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                    sat.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                    sun.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                    dailyCheckBtn.setImageResource(R.drawable.ic_checkbtn_harpseal)

                    //나중에 캘린더 점선 실선 글씨 색 바꾸기


                }else if(MainCardData.index==3){

                    //유형 변경
                    tv_mission_category_eng.text="Paperless"
                    tv_mission_category_kor.text="페이퍼리스"
                    tv_bottom.text="For treeeeeee"

                    //색 변경
                    cardview.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.back_java))
                    tv_mission_name.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))     //내용변경
                    tv_top_category.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                    tv_mission_category_eng.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                    tv_mission_category_kor.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                    tv_bottom.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                    mon.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                    tue.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                    wed.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                    thu.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                    fri.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                    sat.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                    sun.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                    dailyCheckBtn.setImageResource(R.drawable.ic_checkbtn_java)

                    //나중에 캘린더 점선 실선 글씨 색 바꾸기


                }else if(MainCardData.index==4){

                    //유형 변경
                    tv_mission_category_eng.text="Living Habit"
                    tv_mission_category_kor.text="생활 습관 개선"
                    tv_bottom.text="YOU&I"

                    //색 변경
                    cardview.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.back_bengaltiger))
                    tv_mission_name.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))     //내용변경
                    tv_top_category.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                    tv_mission_category_eng.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                    tv_mission_category_kor.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                    tv_bottom.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                    mon.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                    tue.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                    wed.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                    thu.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                    fri.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                    sat.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                    sun.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                    dailyCheckBtn.setImageResource(R.drawable.ic_checkbtn_bengal)

                    //나중에 캘린더 점선 실선 글씨 색 바꾸기

                }

                /*------------------------------------------일수별로 다른 요소 변경--------------------------------------------*/

                if(MainCardData.dayDuring === 7){
                    //7일이라면

                    //카테고리 7일로 변경
                    tv_top_category.text="연속 7일"

                    //테두리 가리기
                    stroke21.visibility = View.GONE

                    //유형별 분류
                    if (MainCardData.index ==0) {
                        bottom_img.setImageResource(R.drawable.ic_maincard_img_continue_7_guanicoe)
                    } else if(MainCardData.index==1){
                        bottom_img.setImageResource(R.drawable.ic_maincard_img_continue_7_illipika)
                    } else if(MainCardData.index==2){
                        bottom_img.setImageResource(R.drawable.ic_maincard_img_continue_7_harpseal)
                    }else if(MainCardData.index==3){
                        bottom_img.setImageResource(R.drawable.ic_maincard_img_continue_7_java)
                    }else if(MainCardData.index==4){
                        bottom_img.setImageResource(R.drawable.ic_maincard_img_continue_7_bengal)
                    }

                }else if(MainCardData.dayDuring === 14){
                    //14일이라면

                    //카테고리 14일로 변경
                    tv_top_category.text="연속 14일"

                    //테두리 가리기
                    stroke21.visibility = View.GONE

                    //유형별 분류
                    if (MainCardData.index ==0) {
                        bottom_img.setImageResource(R.drawable.ic_maincard_img_continue_14_guanicoe)
                    } else if(MainCardData.index==1){
                        bottom_img.setImageResource(R.drawable.ic_maincard_img_continue_14_illipika)
                    } else if(MainCardData.index==2){
                        bottom_img.setImageResource(R.drawable.ic_maincard_img_continue_14_harpseal)
                    }else if(MainCardData.index==3){
                        bottom_img.setImageResource(R.drawable.ic_maincard_img_continue_14_java)
                    }else if(MainCardData.index==4){
                        bottom_img.setImageResource(R.drawable.ic_maincard_img_continue_14_bengal)
                    }

                }else{
                    //21일이라면

                    //카테고리 21일로 변경
                    tv_top_category.text="연속 21일"

                    //유형별 분류
                    if (MainCardData.index ==0) {
                        stroke21.setImageResource(R.drawable.ic_maincard_stroke_continue_21_guanicoe)
                        bottom_img.setImageResource(R.drawable.ic_maincard_img_continue_21_guanicoe)
                    } else if(MainCardData.index==1){
                        stroke21.setImageResource(R.drawable.ic_maincard_stroke_continue_21_illipika)
                        bottom_img.setImageResource(R.drawable.ic_maincard_img_continue_21_illipika)
                    } else if(MainCardData.index==2){
                        stroke21.setImageResource(R.drawable.ic_maincard_stroke_continue_21_harpseal)
                        bottom_img.setImageResource(R.drawable.ic_maincard_img_continue_21_harpseal)
                    }else if(MainCardData.index==3){
                        stroke21.setImageResource(R.drawable.ic_maincard_stroke_continue_21_java)
                        bottom_img.setImageResource(R.drawable.ic_maincard_img_continue_21_java)
                    }else if(MainCardData.index==4){
                        stroke21.setImageResource(R.drawable.ic_maincard_stroke_continue_21_bengal)
                        bottom_img.setImageResource(R.drawable.ic_maincard_img_continue_21_bengal)
                    }
                }

            }else {
                //일반 카드라면

                //요일 및 캘린더 가리기
                mon.visibility = View.GONE
                tue.visibility = View.GONE
                wed.visibility = View.GONE
                thu.visibility = View.GONE
                fri.visibility = View.GONE
                sat.visibility = View.GONE
                sun.visibility = View.GONE
                calendarView.visibility = View.GONE

                //카테고리 일반으로 변경
                tv_top_category.text="일반"

                //테두리 가리기
                stroke21.visibility = View.GONE

                //이후 유형별 이미지 및 글씨 바꿔주기
                if (MainCardData.index ==0) {

                    //유형 변경
                    tv_mission_category_eng.text="Spending Habit"
                    tv_mission_category_kor.text="소비 습관 개선"
                    tv_bottom.text="Think one more"

                    //색 변경
                    cardview.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.back_guanicoe))
                    tv_mission_name.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))     //내용변경
                    tv_top_category.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                    tv_mission_category_eng.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                    tv_mission_category_kor.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                    tv_achieve_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))   //내용변경
                    tv_totalCount.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                    tv_index_count_num.setTextColor(ContextCompat.getColor(itemView.context, R.color.back_guanicoe))  //내용변경
                    tv_start_date.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))   //내용변경
                    tv_end_date.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe)) //내용변경
                    tv_bottom.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))

                    //이미지 변경
                    dailyCheckBtn.setImageResource(R.drawable.ic_checkbtn_guanicoe)
                    normal_index.setImageResource(R.drawable.ic_normal_index_guanicoe)
                    progressbar.setImageResource(R.drawable.ic_progressbar_stroke_guanicoe)
                    bottom_img.setImageResource(R.drawable.ic_maincard_img_normal_guanicoe)

                } else if(MainCardData.index==1){

                    //유형 변경
                    tv_mission_category_eng.text="Saving Electricity"
                    tv_mission_category_kor.text="전기 절약"
                    tv_bottom.text="Not yours, Ours"

                    //색 변경
                    cardview.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.back_illipika))
                    tv_mission_name.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))     //내용변경
                    tv_top_category.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                    tv_mission_category_eng.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                    tv_mission_category_kor.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                    tv_achieve_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))   //내용변경
                    tv_totalCount.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                    tv_index_count_num.setTextColor(ContextCompat.getColor(itemView.context, R.color.back_illipika))  //내용변경
                    tv_start_date.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))   //내용변경
                    tv_end_date.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika)) //내용변경
                    tv_bottom.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))

                    //이미지 변경
                    dailyCheckBtn.setImageResource(R.drawable.ic_checkbtn_illipika)
                    normal_index.setImageResource(R.drawable.ic_normal_index_illipika)
                    progressbar.setImageResource(R.drawable.ic_progressbar_stroke_illipika)
                    bottom_img.setImageResource(R.drawable.ic_maincard_img_normal_illipika)

                } else if(MainCardData.index==2){

                    //유형 변경
                    tv_mission_category_eng.text="Reduce Trash"
                    tv_mission_category_kor.text="쓰레기 배출량 감소"
                    tv_bottom.text="Our Planet"

                    //색 변경
                    cardview.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.back_harpseal))
                    tv_mission_name.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))     //내용변경
                    tv_top_category.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                    tv_mission_category_eng.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                    tv_mission_category_kor.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                    tv_achieve_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))   //내용변경
                    tv_totalCount.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                    tv_index_count_num.setTextColor(ContextCompat.getColor(itemView.context, R.color.back_harpseal))  //내용변경
                    tv_start_date.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))   //내용변경
                    tv_end_date.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal)) //내용변경
                    tv_bottom.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))

                    //이미지 변경
                    dailyCheckBtn.setImageResource(R.drawable.ic_checkbtn_harpseal)
                    normal_index.setImageResource(R.drawable.ic_normal_index_harpseal)
                    progressbar.setImageResource(R.drawable.ic_progressbar_stroke_harpseal)
                    bottom_img.setImageResource(R.drawable.ic_maincard_img_normal_harpseal)

                }else if(MainCardData.index==3){

                    //유형 변경
                    tv_mission_category_eng.text="Paperless"
                    tv_mission_category_kor.text="페이퍼리스"
                    tv_bottom.text="For treeeeeee"

                    //색 변경
                    cardview.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.back_java))
                    tv_mission_name.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))     //내용변경
                    tv_top_category.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                    tv_mission_category_eng.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                    tv_mission_category_kor.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                    tv_achieve_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))   //내용변경
                    tv_totalCount.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                    tv_index_count_num.setTextColor(ContextCompat.getColor(itemView.context, R.color.back_java))  //내용변경
                    tv_start_date.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))   //내용변경
                    tv_end_date.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java)) //내용변경
                    tv_bottom.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))

                    //이미지 변경
                    dailyCheckBtn.setImageResource(R.drawable.ic_checkbtn_java)
                    normal_index.setImageResource(R.drawable.ic_normal_index_java)
                    progressbar.setImageResource(R.drawable.ic_progressbar_stroke_java)
                    bottom_img.setImageResource(R.drawable.ic_maincard_img_normal_java)

                }else if(MainCardData.index==4){

                    //유형 변경
                    tv_mission_category_eng.text="Living Habit"
                    tv_mission_category_kor.text="생활 습관 개선"
                    tv_bottom.text="YOU&I"

                    //색 변경
                    cardview.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.back_bengaltiger))
                    tv_mission_name.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))     //내용변경
                    tv_top_category.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                    tv_mission_category_eng.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                    tv_mission_category_kor.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                    tv_achieve_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))   //내용변경
                    tv_totalCount.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                    tv_index_count_num.setTextColor(ContextCompat.getColor(itemView.context, R.color.back_bengaltiger))  //내용변경
                    tv_start_date.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))   //내용변경
                    tv_end_date.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger)) //내용변경
                    tv_bottom.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))

                    //이미지 변경
                    dailyCheckBtn.setImageResource(R.drawable.ic_checkbtn_bengal)
                    normal_index.setImageResource(R.drawable.ic_normal_index_bengaltiger)
                    progressbar.setImageResource(R.drawable.ic_progressbar_stroke_bengaltiger)
                    bottom_img.setImageResource(R.drawable.ic_maincard_img_normal_bengal)
                }
            }

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