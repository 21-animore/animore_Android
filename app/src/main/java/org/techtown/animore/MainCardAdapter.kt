package org.techtown.animore

import android.content.Intent
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.content.res.AppCompatResources
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import org.techtown.animore.nework.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDate
import java.util.*
import java.util.logging.Handler

class MainCardAdapter : RecyclerView.Adapter<MainCardAdapter.Holder>() {
    var datas = mutableListOf<HomecardDataList>()
    var dateforbtn = Calendar.getInstance()

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


        /*-------------------------------------------------선생님-------------------------------------------------------*/
        var view_count = 0  // 더한 tablerow 갯수 셀려는 변수

        fun draw_cal(index: Int, type:Int, todaydate:String, success_count:Int) {
            var today = Calendar.getInstance()

            var sampleday = todaydate
            var ind = sampleday.split("-")  //text를 -를 기준으로 자름

            var year = ind[0].toInt()
            var month = ind[1].toInt() - 1
            var date = ind[2].toInt()

            today.set(year, month, date)   //오늘 날짜로 셋업

            /*요일의 인덱스를 0부터 시작하도록 수정하는 과정*/
            //요일 가져오기 .. 1-일, 2- 월 --> 0부터 시작 할려고 1을 뺌
            var day = today.get(Calendar.DAY_OF_WEEK) - 1
            // 월요일 부터 시작하고 싶으니 0(일요일)=> 6으로 나머지는 1씩 뺌
            day = if (day == 0) 6 else day - 1

            // 몇주인지 계산 월요일부터 시작 안했으면 무조건 7일은 2주 / 14일은 3주 ... 로 만들기
            var week: Int = if (day > 0) (index / 7) else (index / 7) - 1

            // 월요일부터 시작안할때 구분하는 flag -날짜 시작용
            var start = false
            // 끝난 날을 체크하는 count
            var count = 0
            //달성 횟수만큼만 배경 채우기 위함
            var checknum = 1;

            var table_body : TableLayout = itemView.findViewById(R.id.myTable)

            if (view_count != 0) {    // 버튼 누를때마다 table row 초기화 -- 본인코드에 필요없으면 지워도됨
                for (i in 1..view_count) {
                    table_body.removeViewAt(1)
                }
                view_count = 0
            }

            // table row params
            val rowParams = TableLayout.LayoutParams(
                TableLayout.LayoutParams.WRAP_CONTENT,
                TableLayout.LayoutParams.WRAP_CONTENT
            )

            for (i in 0..week) {
                var tbrow = TableRow(itemView.context)
                tbrow.layoutParams = rowParams
                for (j in 0..6) {  //일주일

                    var tv1 = TextView(itemView.context)
                    var t_par = TableRow.LayoutParams(
                        TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.WRAP_CONTENT,
                        1f
                    )
                    //시작 날짜 체크
                    if (j == day) {
                        start = true
                    }
                    //끝나는 날짜 체크
                    if (count >= index) {
                        start = false
                    }

                    if (start == true) {

                        var myfont = ResourcesCompat.getFont(itemView.context,R.font.montserrat_bold)
                        tv1.setTypeface(myfont)
                        tv1.text = today.get(Calendar.DATE).toString()  //날짜 text

                        //실선
                        //drawable 색 동적으로 바꾸는 방법 찾아보기
                        if(type == 0){
                            if(checknum >= 1 && checknum <= success_count){
                                tv1.setTextColor(ContextCompat.getColor(itemView.context, R.color.back_guanicoe))
                                tv1.background = AppCompatResources.getDrawable(itemView.context, R.drawable.draw_solid_square_guanicoe)
                                checknum += 1
                            }else if(checknum > success_count){
                                tv1.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                                if (i == week) {
                                    if (j % 7 == 0) {
                                        tv1.background = AppCompatResources.getDrawable(itemView.context, R.drawable.draw_solid_line_1_guanicoe)
                                    } else {
                                        tv1.background = AppCompatResources.getDrawable(itemView.context, R.drawable.draw_solid_line_4_guanicoe)
                                    }
                                } else {
                                    if (j % 7 == 0) {
                                        tv1.background = AppCompatResources.getDrawable(itemView.context, R.drawable.draw_solid_line_2_guanicoe)
                                    } else {
                                        tv1.background = AppCompatResources.getDrawable(itemView.context, R.drawable.draw_solid_line_3_guanicoe)
                                    }
                                }
                            }
                        }else if(type == 1){
                            if(checknum >= 1 && checknum <= success_count){
                                tv1.setTextColor(ContextCompat.getColor(itemView.context, R.color.back_illipika))
                                tv1.background = AppCompatResources.getDrawable(itemView.context, R.drawable.draw_solid_square_illipika)
                                checknum += 1
                            }else if(checknum > success_count){
                                tv1.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                                if (i == week) {
                                    if (j % 7 == 0) {
                                        tv1.background = AppCompatResources.getDrawable(itemView.context, R.drawable.draw_solid_line_1_illipika)
                                    } else {
                                        tv1.background = AppCompatResources.getDrawable(itemView.context, R.drawable.draw_solid_line_4_illipika)
                                    }
                                } else {
                                    if (j % 7 == 0) {
                                        tv1.background = AppCompatResources.getDrawable(itemView.context, R.drawable.draw_solid_line_2_illipika)
                                    } else {
                                        tv1.background = AppCompatResources.getDrawable(itemView.context, R.drawable.draw_solid_line_3_illipika)
                                    }
                                }
                            }
                        }else if(type == 2){
                            if(checknum >= 1 && checknum <= success_count){
                                tv1.setTextColor(ContextCompat.getColor(itemView.context, R.color.back_harpseal))
                                tv1.background = AppCompatResources.getDrawable(itemView.context, R.drawable.draw_solid_square_harpseal)
                                checknum += 1
                            }else if(checknum > success_count){
                                tv1.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                                if (i == week) {
                                    if (j % 7 == 0) {
                                        tv1.background = AppCompatResources.getDrawable(itemView.context, R.drawable.draw_solid_line_1_harpseal)
                                    } else {
                                        tv1.background = AppCompatResources.getDrawable(itemView.context, R.drawable.draw_solid_line_4_harpseal)
                                    }
                                } else {
                                    if (j % 7 == 0) {
                                        tv1.background = AppCompatResources.getDrawable(itemView.context, R.drawable.draw_solid_line_2_harpseal)
                                    } else {
                                        tv1.background = AppCompatResources.getDrawable(itemView.context, R.drawable.draw_solid_line_3_harpseal)
                                    }
                                }
                            }
                        }else if(type == 3){
                            if(checknum >= 1 && checknum <= success_count){
                                tv1.setTextColor(ContextCompat.getColor(itemView.context, R.color.back_java))
                                tv1.background = AppCompatResources.getDrawable(itemView.context, R.drawable.draw_solid_square_java)
                                checknum += 1
                            }else if(checknum > success_count){
                                tv1.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                                if (i == week) {
                                    if (j % 7 == 0) {
                                        tv1.background = AppCompatResources.getDrawable(itemView.context, R.drawable.draw_solid_line_1_java)
                                    } else {
                                        tv1.background = AppCompatResources.getDrawable(itemView.context, R.drawable.draw_solid_line_4_java)
                                    }
                                } else {
                                    if (j % 7 == 0) {
                                        tv1.background = AppCompatResources.getDrawable(itemView.context, R.drawable.draw_solid_line_2_java)
                                    } else {
                                        tv1.background = AppCompatResources.getDrawable(itemView.context, R.drawable.draw_solid_line_3_java)
                                    }
                                }
                            }
                        }else if(type == 4){
                            if(checknum >= 1 && checknum <= success_count){
                                tv1.setTextColor(ContextCompat.getColor(itemView.context, R.color.back_bengaltiger))
                                tv1.background = AppCompatResources.getDrawable(itemView.context, R.drawable.draw_solid_square_bengal)
                                checknum += 1
                            }else if(checknum > success_count){
                                tv1.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                                if (i == week) {
                                    if (j % 7 == 0) {
                                        tv1.background = AppCompatResources.getDrawable(itemView.context, R.drawable.draw_solid_line_1_bengal)
                                    } else {
                                        tv1.background = AppCompatResources.getDrawable(itemView.context, R.drawable.draw_solid_line_4_bengal)
                                    }
                                } else {
                                    if (j % 7 == 0) {
                                        tv1.background = AppCompatResources.getDrawable(itemView.context, R.drawable.draw_solid_line_2_bengal)
                                    } else {
                                        tv1.background = AppCompatResources.getDrawable(itemView.context, R.drawable.draw_solid_line_3_bengal)
                                    }
                                }
                            }
                        }
                        //1일씩 날짜 더하기
                        today.add(Calendar.DATE, 1)
                        //id추가 ==> 나중에 색을 칠하기 위한 id
                        tv1.id = count
                        count += 1

                    } else {
                        tv1.text = ""
                        //빈칸은 점선

                        if(type === 0){
                            if (i == 0) {
                                if (j % 7 == 0) {
                                    tv1.background = AppCompatResources.getDrawable(itemView.context, R.drawable.draw_dash_1_1_guanicoe)
                                } else {
                                    tv1.background = AppCompatResources.getDrawable(itemView.context, R.drawable.draw_dash_1_2_guanicoe)
                                }
                                if (j == day - 1) {
                                    tv1.background = AppCompatResources.getDrawable(itemView.context, R.drawable.draw_dash_1_3_guanicoe)
                                }
                            } else if (i != 0 && i == week) {
                                tv1.background = AppCompatResources.getDrawable(itemView.context, R.drawable.draw_dash_1_4_guanicoe)
                            }
                        }else if(type === 1){
                            if (i == 0) {
                                if (j % 7 == 0) {
                                    tv1.background = AppCompatResources.getDrawable(itemView.context, R.drawable.draw_dash_1_1_illipika)
                                } else {
                                    tv1.background = AppCompatResources.getDrawable(itemView.context, R.drawable.draw_dash_1_2_illipika)
                                }
                                if (j == day - 1) {
                                    tv1.background = AppCompatResources.getDrawable(itemView.context, R.drawable.draw_dash_1_3_illipika)
                                }
                            } else if (i != 0 && i == week) {
                                tv1.background = AppCompatResources.getDrawable(itemView.context, R.drawable.draw_dash_1_4_illipika)
                            }
                        }else if(type === 2){
                            if (i == 0) {
                                if (j % 7 == 0) {
                                    tv1.background = AppCompatResources.getDrawable(itemView.context, R.drawable.draw_dash_1_1_harpseal)
                                } else {
                                    tv1.background = AppCompatResources.getDrawable(itemView.context, R.drawable.draw_dash_1_2_harpseal)
                                }
                                if (j == day - 1) {
                                    tv1.background = AppCompatResources.getDrawable(itemView.context, R.drawable.draw_dash_1_3_harpseal)
                                }
                            } else if (i != 0 && i == week) {
                                tv1.background = AppCompatResources.getDrawable(itemView.context, R.drawable.draw_dash_1_4_harpseal)
                            }
                        }else if(type === 3){
                            if (i == 0) {
                                if (j % 7 == 0) {
                                    tv1.background = AppCompatResources.getDrawable(itemView.context, R.drawable.draw_dash_1_1_java)
                                } else {
                                    tv1.background = AppCompatResources.getDrawable(itemView.context, R.drawable.draw_dash_1_2_java)
                                }
                                if (j == day - 1) {
                                    tv1.background = AppCompatResources.getDrawable(itemView.context, R.drawable.draw_dash_1_3_java)
                                }
                            } else if (i != 0 && i == week) {
                                tv1.background = AppCompatResources.getDrawable(itemView.context, R.drawable.draw_dash_1_4_java)
                            }
                        }else if(type === 4){
                            if (i == 0) {
                                if (j % 7 == 0) {
                                    tv1.background = AppCompatResources.getDrawable(itemView.context, R.drawable.draw_dash_1_1_bengal)
                                } else {
                                    tv1.background = AppCompatResources.getDrawable(itemView.context, R.drawable.draw_dash_1_2_bengal)
                                }
                                if (j == day - 1) {
                                    tv1.background = AppCompatResources.getDrawable(itemView.context, R.drawable.draw_dash_1_3_bengal)
                                }
                            } else if (i != 0 && i == week) {
                                tv1.background = AppCompatResources.getDrawable(itemView.context, R.drawable.draw_dash_1_4_bengal)
                            }
                        }
                    }

                    tv1.layoutParams = t_par
                    // tv1.setTextColor()
                    tv1.gravity = Gravity.CENTER

                    //숫자가 있을 경우에
                    if(tv1.text.toString() != "")
                    {
                        val num = (tv1.text.toString()).toInt()
                        if(num <= 9){
                            tv1.setPadding(12, 23, 12, 23)
                        }else{
                            tv1.setPadding(0, 23, 0, 23)
                        }
                    }else{
                        tv1.setPadding(23, 23, 23, 23)
                    }
                    //textviw 추가
                    tbrow.addView(tv1)
                }
                //tablerow 추가
                table_body.addView(tbrow)
                view_count += 1
            }
        }


        /*-------------------------------------------------캘린더-------------------------------------------------------
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
         */

        /*-------------------------------------------사용할 변수 선언-----------------------------------------------*/
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
        val progressbar_stroke = itemView.findViewById<ImageView>(R.id.maincard_progressbar_stroke)
        val bottom_img = itemView.findViewById<ImageView>(R.id.maincard_bottom_img)

        val myTable = itemView.findViewById<TableLayout>(R.id.myTable)

        val mon = itemView.findViewById<TextView>(R.id.maincard_tv_day_mon)
        val tue = itemView.findViewById<TextView>(R.id.maincard_tv_day_tue)
        val wed = itemView.findViewById<TextView>(R.id.maincard_tv_day_wed)
        val thu = itemView.findViewById<TextView>(R.id.maincard_tv_day_thu)
        val fri = itemView.findViewById<TextView>(R.id.maincard_tv_day_fri)
        val sat = itemView.findViewById<TextView>(R.id.maincard_tv_day_sat)
        val sun = itemView.findViewById<TextView>(R.id.maincard_tv_day_sun)

        val stroke21 = itemView.findViewById<ImageView>(R.id.maincard_continue_21_stroke)
        val progressbar = itemView.findViewById<ProgressBar>(R.id.maincard_progressbar)

        val black_screen = itemView.findViewById<ImageView>(R.id.maincard_success_black_screen)
        val circle = itemView.findViewById<ImageView>(R.id.maincard_success_circle)
        val balck_screen_text = itemView.findViewById<TextView>(R.id.maincard_success_black_screen_text)

        var user_idx = 1;
        var mission_name=""
        var mission_period = 0
        val click_date = LocalDate.now().toString()

        fun addCount(){
            val retrofitClient = RetrofitClient.create(RequestCardInterface::class.java)

            retrofitClient.addCountRequest(user_idx, mission_name, mission_period, click_date).enqueue(object :
                Callback<RandomCheerupData> {
                override fun onFailure(call: Call<RandomCheerupData>, t: Throwable) {
                    if (t.message != null) {
                        Log.d("add Count", t.message!!)
                    } else {
                        Log.d("add Count", "통신실패")
                    }
                }
                override fun onResponse(
                    call: Call<RandomCheerupData>,
                    response: Response<RandomCheerupData>
                ) {
                    if (response.isSuccessful) {
                        if (response.body()!!.success) {
                            Log.d("add Count", "전체 데이터 : ${response.body()!!}")
                            balck_screen_text.text = response.body()!!.data
                        } else {
                            Log.d("add Count", "통신실패")
                        }
                    } else {
                        Log.d("add Count", "${response.message()}, ${response.errorBody()}")
                    }
                }
            })
        }

        fun getPos(count : Int){
            normal_index.x = 0F
            tv_index_count_num.x = 0F
            
            normal_index.x += (50 + 32*count)
            tv_index_count_num.x += (50 + 32*count)
        }


        fun bind(MainCardData: HomecardDataList) {

            mission_name = MainCardData.mission_name
            mission_period = MainCardData.mission_period

            /*----------------------------------데이터 바인딩 부분--------------------------------------------*/
            //상세페이지 눌렀을 때 넘겨줄 수 있도록
            var bundle_mission_name = MainCardData.mission_name   //미션 이름
            var bundle_mission_category = MainCardData.mission_category.toString()   //인덱스(유형 구분)
            val bundle_continue_flag = MainCardData.continue_flag.toString()
            var bundle_mission_acheive_count = MainCardData.mission_acheive_count.toString()   //카운트(달성 횟수)
            var bundle_mission_period = MainCardData.mission_period.toString() //총 횟수(7,14,21)
            var bundle_mission_start_date = MainCardData.mission_start_date  //시작 날짜
            var bundle_mission_end_date = MainCardData.mission_end_date    //끝 날짜
            var bundle_mission_content = MainCardData.mission_content //미션별 소개 글

            /*----------------------------------미션마다 다른 정보 우선 배정--------------------------------------------*/

            //카드에 보이게 되는 정보들
            tv_mission_name.text = MainCardData.mission_name
            tv_achieve_count.text = MainCardData.mission_acheive_count.toString()
            tv_totalCount.text = "/"+MainCardData.mission_period.toString()
            tv_index_count_num.text = MainCardData.mission_acheive_count.toString()
            tv_start_date.text = MainCardData.mission_start_date
            tv_end_date.text = MainCardData.mission_end_date

            var count_for_progressbar = MainCardData.mission_acheive_count.toFloat()/MainCardData.mission_period*100
            var int = count_for_progressbar.toInt()
            progressbar.progress = int

            /*----------------------------------타입마다 다른 정보 나중 배정--------------------------------------------*/

            //그리고 여기서 오늘 날짜 === 저장된 날짜 같은지 확인하고
            if(MainCardData.click_date == LocalDate.now().toString()) {
                //같으면 계속 보이게 설정
                black_screen.visibility = View.VISIBLE
                circle.visibility = View.VISIBLE
                balck_screen_text.visibility = View.VISIBLE
                balck_screen_text.setText("오늘 성공한 미션")
                dailyCheckBtn.setEnabled(false);
            }

            if(MainCardData.continue_flag == 1){
                //연속 카드라면
                
                //일반 카드 요소들 숨기기
                progressbar.visibility = View.GONE
                progressbar_stroke.visibility = View.GONE
                tv_totalCount.visibility = View.GONE;
                tv_achieve_count.visibility = View.GONE;
                normal_index.visibility = View.GONE;
                tv_index_count_num.visibility = View.GONE;
                tv_start_date.visibility = View.GONE;
                tv_end_date.visibility = View.GONE;

                //캘린더 그리기
                draw_cal(MainCardData.mission_period, MainCardData.mission_category, MainCardData.mission_start_date, MainCardData.mission_acheive_count)

                /*----------------------------------연속 카드 일수별로 다른 요소 변경--------------------------------------------*/
                
                if (MainCardData.mission_category ==0) {

                    //유형 변경
                    tv_mission_category_eng.text="Spending Habit"
                    tv_mission_category_kor.text="소비 습관 개선"
                    tv_bottom.text="Think one more"

                    //색 변경
                    cardview.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.back_guanicoe))
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

                } else if(MainCardData.mission_category==1){

                    //유형 변경
                    tv_mission_category_eng.text="Saving Electricity"
                    tv_mission_category_kor.text="전기 절약"
                    tv_bottom.text="Not yours, Ours"

                    //색 변경
                    cardview.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.back_illipika))
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

                } else if(MainCardData.mission_category==2){

                    //유형 변경
                    tv_mission_category_eng.text="Reduce Trash"
                    tv_mission_category_kor.text="쓰레기 배출량 감소"
                    tv_bottom.text="Our Planet"

                    //색 변경
                    cardview.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.back_harpseal))
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


                }else if(MainCardData.mission_category==3){

                    //유형 변경
                    tv_mission_category_eng.text="Paperless"
                    tv_mission_category_kor.text="페이퍼리스"
                    tv_bottom.text="For treeeeeee"

                    //색 변경
                    cardview.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.back_java))
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


                }else if(MainCardData.mission_category==4){

                    //유형 변경
                    tv_mission_category_eng.text="Living Habit"
                    tv_mission_category_kor.text="생활 습관 개선"
                    tv_bottom.text="YOU&I"

                    //색 변경
                    cardview.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.back_bengaltiger))
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

                }

                /*------------------------------------------일수별로 다른 요소 변경--------------------------------------------*/

                if(MainCardData.mission_period === 7){
                    //7일이라면

                    //카테고리 7일로 변경
                    tv_top_category.text="연속 7일"

                    //테두리 가리기
                    stroke21.visibility = View.GONE

                    //유형별 분류
                    if (MainCardData.mission_category ==0) {
                        bottom_img.setImageResource(R.drawable.ic_maincard_img_continue_7_guanicoe)
                    } else if(MainCardData.mission_category==1){
                        bottom_img.setImageResource(R.drawable.ic_maincard_img_continue_7_illipika)
                    } else if(MainCardData.mission_category==2){
                        bottom_img.setImageResource(R.drawable.ic_maincard_img_continue_7_harpseal)
                    }else if(MainCardData.mission_category==3){
                        bottom_img.setImageResource(R.drawable.ic_maincard_img_continue_7_java)
                    }else if(MainCardData.mission_category==4){
                        bottom_img.setImageResource(R.drawable.ic_maincard_img_continue_7_bengal)
                    }

                }else if(MainCardData.mission_period === 14){
                    //14일이라면

                    //카테고리 14일로 변경
                    tv_top_category.text="연속 14일"

                    //테두리 가리기
                    stroke21.visibility = View.GONE

                    //유형별 분류
                    if (MainCardData.mission_category ==0) {
                        bottom_img.setImageResource(R.drawable.ic_maincard_img_continue_14_guanicoe)
                    } else if(MainCardData.mission_category==1){
                        bottom_img.setImageResource(R.drawable.ic_maincard_img_continue_14_illipika)
                    } else if(MainCardData.mission_category==2){
                        bottom_img.setImageResource(R.drawable.ic_maincard_img_continue_14_harpseal)
                    }else if(MainCardData.mission_category==3){
                        bottom_img.setImageResource(R.drawable.ic_maincard_img_continue_14_java)
                    }else if(MainCardData.mission_category==4){
                        bottom_img.setImageResource(R.drawable.ic_maincard_img_continue_14_bengal)
                    }

                }else{
                    //21일이라면

                    //카테고리 21일로 변경
                    tv_top_category.text="연속 21일"

                    //유형별 분류
                    if (MainCardData.mission_category ==0) {
                        stroke21.setImageResource(R.drawable.ic_maincard_stroke_continue_21_guanicoe)
                        bottom_img.setImageResource(R.drawable.ic_maincard_img_continue_21_guanicoe)
                    } else if(MainCardData.mission_category==1){
                        stroke21.setImageResource(R.drawable.ic_maincard_stroke_continue_21_illipika)
                        bottom_img.setImageResource(R.drawable.ic_maincard_img_continue_21_illipika)
                    } else if(MainCardData.mission_category==2){
                        stroke21.setImageResource(R.drawable.ic_maincard_stroke_continue_21_harpseal)
                        bottom_img.setImageResource(R.drawable.ic_maincard_img_continue_21_harpseal)
                    }else if(MainCardData.mission_category==3){
                        stroke21.setImageResource(R.drawable.ic_maincard_stroke_continue_21_java)
                        bottom_img.setImageResource(R.drawable.ic_maincard_img_continue_21_java)
                    }else if(MainCardData.mission_category==4){
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
                //calendarView.visibility = View.GONE
                myTable.visibility = View.GONE;

                //카테고리 일반으로 변경
                tv_top_category.text="일반"

                //테두리 가리기
                stroke21.visibility = View.GONE

                //프로그레스바 인디케이터 위치 옮기기
                getPos(MainCardData.mission_acheive_count)

                //이후 유형별 이미지 및 글씨 바꿔주기
                if (MainCardData.mission_category ==0) {

                    //유형 변경
                    tv_mission_category_eng.text="Spending Habit"
                    tv_mission_category_kor.text="소비 습관 개선"
                    tv_bottom.text="Think one more"

                    //색 변경
                    cardview.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.back_guanicoe))
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
                    progressbar_stroke.setImageResource(R.drawable.ic_progressbar_stroke_guanicoe)
                    bottom_img.setImageResource(R.drawable.ic_maincard_img_normal_guanicoe)

                    progressbar.setProgressDrawableTiled(ContextCompat.getDrawable(itemView.context, R.drawable.main_progressbar_guanicoe))

                } else if(MainCardData.mission_category==1){

                    //유형 변경
                    tv_mission_category_eng.text="Saving Electricity"
                    tv_mission_category_kor.text="전기 절약"
                    tv_bottom.text="Not yours, Ours"

                    //색 변경
                    cardview.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.back_illipika))
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
                    progressbar_stroke.setImageResource(R.drawable.ic_progressbar_stroke_illipika)
                    bottom_img.setImageResource(R.drawable.ic_maincard_img_normal_illipika)

                    progressbar.setProgressDrawableTiled(ContextCompat.getDrawable(itemView.context, R.drawable.main_progressbar_illipika))

                } else if(MainCardData.mission_category==2){

                    //유형 변경
                    tv_mission_category_eng.text="Reduce Trash"
                    tv_mission_category_kor.text="쓰레기 배출량 감소"
                    tv_bottom.text="Our Planet"

                    //색 변경
                    cardview.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.back_harpseal))
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
                    progressbar_stroke.setImageResource(R.drawable.ic_progressbar_stroke_harpseal)
                    bottom_img.setImageResource(R.drawable.ic_maincard_img_normal_harpseal)

                    progressbar.setProgressDrawableTiled(ContextCompat.getDrawable(itemView.context, R.drawable.main_progressbar_harpseal))

                }else if(MainCardData.mission_category==3){

                    //유형 변경
                    tv_mission_category_eng.text="Paperless"
                    tv_mission_category_kor.text="페이퍼리스"
                    tv_bottom.text="For treeeeeee"

                    //색 변경
                    cardview.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.back_java))
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
                    progressbar_stroke.setImageResource(R.drawable.ic_progressbar_stroke_java)
                    bottom_img.setImageResource(R.drawable.ic_maincard_img_normal_java)

                    progressbar.setProgressDrawableTiled(ContextCompat.getDrawable(itemView.context, R.drawable.main_progressbar_java))

                }else if(MainCardData.mission_category==4){

                    //유형 변경
                    tv_mission_category_eng.text="Living Habit"
                    tv_mission_category_kor.text="생활 습관 개선"
                    tv_bottom.text="YOU&I"

                    //색 변경
                    cardview.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.back_bengaltiger))
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
                    progressbar_stroke.setImageResource(R.drawable.ic_progressbar_stroke_bengaltiger)
                    bottom_img.setImageResource(R.drawable.ic_maincard_img_normal_bengal)

                    progressbar.setProgressDrawableTiled(ContextCompat.getDrawable(itemView.context, R.drawable.main_progressbar_bengal))
                }
            }

            //클릭한 카드의 데이터 상세 뷰로 보내기
            var bundle = bundleOf(
                    "bundle_mission_name" to bundle_mission_name,
                    "bundle_mission_category" to bundle_mission_category,
                    "bundle_continue_flag" to bundle_continue_flag,
                    "bundle_mission_acheive_count" to bundle_mission_acheive_count,
                    "bundle_mission_period" to bundle_mission_period,
                    "bundle_mission_start_date" to bundle_mission_start_date,
                    "bundle_mission_end_date" to bundle_mission_end_date,
                    "bundle_mission_content" to bundle_mission_content)
            cardview.setOnClickListener {
                Navigation.findNavController(cardview).navigate(R.id.action_home_fragment_to_home_more_card_fragment, bundle)
            }

            dailyCheckBtn.setOnClickListener {
                addCount()
                if((MainCardData.mission_acheive_count +1) == MainCardData.mission_period){
                    val intent = Intent(itemView.context, SplashFinishActivity::class.java)
                    itemView.context.startActivity(intent)
                }else{
                    black_screen.visibility = View.VISIBLE
                    circle.visibility = View.VISIBLE
                    balck_screen_text.visibility = View.VISIBLE
                    dailyCheckBtn.setEnabled(false);

                    bundle_mission_acheive_count = (bundle_mission_acheive_count.toInt() + 1).toString()

                    if(MainCardData.continue_flag == 1){
                        //뒷 배경 바꾸기(연속)
                        draw_cal(MainCardData.mission_period, MainCardData.mission_category, MainCardData.mission_start_date, bundle_mission_acheive_count.toInt())
                    }else{
                        //뒷 배경 바꾸기(일반)
                        tv_achieve_count.text = bundle_mission_acheive_count
                        tv_index_count_num.text = bundle_mission_acheive_count
                        var after_click_count_for_progressbar = bundle_mission_acheive_count.toFloat()/MainCardData.mission_period*100
                        var after_click_int = after_click_count_for_progressbar.toInt()
                        progressbar.progress = after_click_int
                        getPos(bundle_mission_acheive_count.toInt())
                    }

                    bundle = bundleOf(
                        "bundle_mission_name" to bundle_mission_name,
                        "bundle_mission_category" to bundle_mission_category,
                        "bundle_continue_flag" to bundle_continue_flag,
                        "bundle_mission_acheive_count" to bundle_mission_acheive_count,
                        "bundle_mission_period" to bundle_mission_period,
                        "bundle_mission_start_date" to bundle_mission_start_date,
                        "bundle_mission_end_date" to bundle_mission_end_date,
                        "bundle_mission_content" to bundle_mission_content)
                }
            }
        }
    }
}