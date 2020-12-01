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



        //캘린더
        val calendarView: RecyclerView = itemView.findViewById(R.id.calendar_normalcard_layout)
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

        /*
        선생님께 받은 코드

        var view_count =0  // tablerow셈용 변수

        fun draw_cal(index:Int){
            var today = Calendar.getInstance()

            var inputday = Calendar.getInstance().toString()
            var ind = inputday.split("-")  //text 를 년/월/일 구분

            var year = ind[0].toInt()
            var month = ind[1].toInt()-1
            var date = ind[2].toInt()

            today.set(year,month,date)   //날짜로 셋업

            var day = today.get(Calendar.DAY_OF_WEEK)-1
            day = if(day==0) 6 else day -1  //월요일부터 시작하도록 셋팅
            var week :Int = if(day>0) (index/7) else (index/7)-1    //줄 계산(월요일 아니면 무조건 +1줄)

            var start=false
            var count=0            // 끝난 날을 체크하는 count

            var table_body = itemView.findViewById<TableLayout>(R.id.myTable)

            if(view_count!=0){    // 버튼 누를때마다 table row 초기화 -- 본인코드에 필요없으면 지워도됨
                for(i in 1..view_count){
                    table_body.removeViewAt(1)}
                view_count=0
            }

            // table row params
            val rowParams = TableLayout.LayoutParams(
                    TableLayout.LayoutParams.WRAP_CONTENT,
                    TableLayout.LayoutParams.WRAP_CONTENT
            )


            for (i in 0..week) {
                var tbrow = itemView.findViewById<TableRow>(R.id.maincard_tablerow)
                tbrow.layoutParams = rowParams

                for (j in 0..6) {
                    var tv1 = TextView(itemView.context)

                    // 본인 textview에 해당하는 param으로 바꿀것
                    var t_par = TableRow.LayoutParams(
                            TableRow.LayoutParams.MATCH_PARENT,
                            TableRow.LayoutParams.WRAP_CONTENT,
                            1f
                    )

                    //시작 날짜 체크
                    if(j==day){
                        start=true
                    }

                    //끝나는 날짜 체크
                    if(count>=index){
                        start=false
                    }

                    if(start ==true) {
                        //날짜 text
                        tv1.text = today.get(Calendar.DATE).toString()
                        //배경.. 실선
                        tv1.background = itemView.resources.getDrawable(R.drawable.calendar_solid_line)
                        //1일씩 날짜 더하기
                        today.add(Calendar.DATE,1)
                        //id추가 ==> 나중에 색을 칠하기 위한 id
                        tv1.id=count
                        count+=1
                    }
                    else {
                        tv1.text = ""
                        //빈칸은 실선
                        tv1.background = itemView.resources.getDrawable(R.drawable.calendar_dotted_line)
                    }

                    tv1.layoutParams = t_par
                    //tv1.gravity = Gravity.CENTER
                    tv1.setPadding(0, 30, 0, 30)
                    //textviw 추가
                    tbrow.addView(tv1)

                }
                //tablerow 추가
                table_body.addView(tbrow)
                view_count+=1
            }
        }

        */

        fun bind(mainCardData1: MainCardData) {

            if(mainCardData1.flag){
                createCalendar(mainCardData1.dayDuring)
                //draw_cal(NormalCardData1.dayDuring)

                progressbar.visibility = View.GONE
                tv_totalCount.visibility = View.GONE;
                tv_achieve_count.visibility = View.GONE;
                normal_index.visibility = View.GONE;
                tv_count_num.visibility = View.GONE;
                tv_start_date.visibility = View.GONE;
                tv_end_date.visibility = View.GONE;
            }

            if (mainCardData1.index ==0) {
                cardview.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.back_guanicoe))

                mission_name.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                tv_normal.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                mission_category_eng.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                tv_mission_category_kor.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                tv_achieve_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                tv_totalCount.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                tv_count_num.setTextColor(ContextCompat.getColor(itemView.context, R.color.back_guanicoe))
                tv_start_date.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                tv_end_date.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                tv_bottom.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))

                normal_index.setImageResource(R.drawable.ic_normal_index_guanicoe)
                progressbar.setImageResource(R.drawable.ic_progressbar_stroke_guanicoe)
                bottom_img.setImageResource(R.drawable.ic_main_card_guanicoe)
                dailyCheckBtn.setBackgroundResource(R.drawable.ic_checkbtn_guanicoe)

            } else if(mainCardData1.index==1){
                cardview.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.back_illipika))

                mission_name.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                tv_normal.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                mission_category_eng.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                tv_mission_category_kor.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                tv_achieve_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                tv_totalCount.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                tv_count_num.setTextColor(ContextCompat.getColor(itemView.context, R.color.back_illipika))
                tv_start_date.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                tv_end_date.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                tv_bottom.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))

                normal_index.setImageResource(R.drawable.ic_normal_index_illipika)
                progressbar.setImageResource(R.drawable.ic_progressbar_stroke_illipika)
                bottom_img.setImageResource(R.drawable.ic_main_card_illipika)
                dailyCheckBtn.setBackgroundResource(R.drawable.ic_checkbtn_illipika)

            } else if(mainCardData1.index==2){
                cardview.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.back_harpseal))

                mission_name.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                tv_normal.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                mission_category_eng.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                tv_mission_category_kor.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                tv_achieve_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                tv_totalCount.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                tv_count_num.setTextColor(ContextCompat.getColor(itemView.context, R.color.back_harpseal))
                tv_start_date.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                tv_end_date.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                tv_bottom.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))

                normal_index.setImageResource(R.drawable.ic_normal_index_harpseal)
                progressbar.setImageResource(R.drawable.ic_progressbar_stroke_harpseal)
                bottom_img.setImageResource(R.drawable.ic_main_card_harpseal)
                dailyCheckBtn.setBackgroundResource(R.drawable.ic_checkbtn_harpseal)

            }else if(mainCardData1.index==3){
                cardview.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.back_java))

                mission_name.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                tv_normal.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                mission_category_eng.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                tv_mission_category_kor.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                tv_achieve_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                tv_totalCount.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                tv_count_num.setTextColor(ContextCompat.getColor(itemView.context, R.color.back_java))
                tv_start_date.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                tv_end_date.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                tv_bottom.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))

                normal_index.setImageResource(R.drawable.ic_normal_index_java)
                progressbar.setImageResource(R.drawable.ic_progressbar_stroke_java)
                bottom_img.setImageResource(R.drawable.ic_main_card_java)
                dailyCheckBtn.setBackgroundResource(R.drawable.ic_checkbtn_java)

            }else if(mainCardData1.index==4){
                cardview.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.back_bengaltiger))

                mission_name.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                tv_normal.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                mission_category_eng.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                tv_mission_category_kor.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                tv_achieve_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                tv_totalCount.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                tv_count_num.setTextColor(ContextCompat.getColor(itemView.context, R.color.back_bengaltiger))
                tv_start_date.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                tv_end_date.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                tv_bottom.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))

                normal_index.setImageResource(R.drawable.ic_normal_index_bengaltiger)
                progressbar.setImageResource(R.drawable.ic_progressbar_stroke_bengaltiger)
                bottom_img.setImageResource(R.drawable.ic_main_card_bengaltiger)
                dailyCheckBtn.setBackgroundResource(R.drawable.ic_checkbtn_bengal)

            }

            mission_name.text = mainCardData1.mission_name;

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