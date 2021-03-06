package org.techtown.animore

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.content.Context
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import java.time.LocalDate
import java.util.*

class HomeMoreCardAdapter(val context: Context): RecyclerView.Adapter<HomeMoreCardAdapter.Holder>(){
    var homemoreitems = mutableListOf<HomeMoreCardData>()

    override fun getItemCount(): Int {
        return homemoreitems.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.more_card_layout, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(homemoreitems[position], context)
    }

    inner class Holder(itemView: View):RecyclerView.ViewHolder(itemView) {

        var frontcard = itemView.findViewById<RelativeLayout>(R.id.more_card_view_front)
        var backcard = itemView.findViewById<RelativeLayout>(R.id.more_card_view_back)

        var mSetRightOut = AnimatorInflater.loadAnimator(itemView.context, R.animator.out_ani) as AnimatorSet
        var mSetLeftIn = AnimatorInflater.loadAnimator(itemView.context, R.animator.in_ani) as AnimatorSet


        //원 그리기
        val calendarView: RecyclerView = itemView.findViewById(R.id.more_card_circle_recyclerview)
        val CircleAdapter = HomeMoreCardCircleAdapter()

        fun createCircle(count: Int, type:Int){

            var int = 1;
            var typestring = "";

            if(type === 0){
                typestring = "0-"
            }else if(type === 1){
                typestring = "1-"
            }else if(type === 2){
                typestring = "2-"
            }else if(type === 3){
                typestring = "3-"
            }else if(type === 4){
                typestring = "4-"
            }

            for(i in 0 until count){
                CircleAdapter.items.add(""+typestring + int.toString())
                int ++;
            }

            for(i in 1..21-count){
                CircleAdapter.items.add(""+typestring + (int+50).toString())
                int ++;
            }

            calendarView.adapter = CircleAdapter
        }



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

            if (view_count != 0) {    // 버튼 누를때마다 table row 초기화
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
                            tv1.setPadding(12, 45, 12, 45)
                        }else{
                            tv1.setPadding(0, 45, 0, 45)
                        }
                    }else{
                        tv1.setPadding(45, 45, 45, 45)
                    }
                    //textviw 추가
                    tbrow.addView(tv1)
                }
                //tablerow 추가
                table_body.addView(tbrow)
                view_count += 1
            }
        }



        /*-------------------------------------------사용할 변수 선언-----------------------------------------------*/

        /*-------------------------------------------front-----------------------------------------------*/
        val front_background_img = itemView.findViewById<ImageView>(R.id.more_card_front_backgroundimg)
        val front_img = itemView.findViewById<ImageView>(R.id.more_card_front_img)
        val front_tv_mission_name = itemView.findViewById<TextView>(R.id.more_card_front_tv_mission_name)
        val front_tv_top_category = itemView.findViewById<TextView>(R.id.more_card_front_tv_top_category)
        //val front_tv_mission_total_count = itemView.findViewById<TextView>(R.id.more_card_front_tv_mission_total_count)
        val front_tv_mission_category_eng = itemView.findViewById<TextView>(R.id.more_card_front_tv_mission_category_eng)
        val front_tv_mission_category_kor = itemView.findViewById<TextView>(R.id.more_card_front_tv_mission_category_kor)
        val front_tv_achieve_count = itemView.findViewById<TextView>(R.id.more_card_front_tv_achieve_count_title)
        val front_tv_times = itemView.findViewById<TextView>(R.id.more_card_front_tv_times)
        val front_tv_start_date_title = itemView.findViewById<TextView>(R.id.more_card_front_tv_start_date_title)
        val front_tv_end_date_title = itemView.findViewById<TextView>(R.id.more_card_front_tv_end_date_title)
        val front_tv_start_date = itemView.findViewById<TextView>(R.id.more_card_front_tv_start_date)
        val front_tv_end_date = itemView.findViewById<TextView>(R.id.more_card_front_tv_end_date)
        val front_tv_achieve_count_num = itemView.findViewById<TextView>(R.id.more_card_front_tv_achieve_count_num)
        val front_tv_process = itemView.findViewById<TextView>(R.id.more_card_front_tv_process)
        val front_tv_process_count = itemView.findViewById<TextView>(R.id.more_card_front_tv_process_count)
        val front_tv_count_slash = itemView.findViewById<TextView>(R.id.more_card_front_tv_count_slash)
        val front_tv_total_count = itemView.findViewById<TextView>(R.id.more_card_front_tv_total_count)
        val front_tv_bottom_sentence = itemView.findViewById<TextView>(R.id.more_card_front_tv_bottom_sentence)

        val front_normal_index = itemView.findViewById<ImageView>(R.id.more_card_front_normal_index)
        val front_tv_index_count_num = itemView.findViewById<TextView>(R.id.more_card_front_tv_index_count_num)
        val front_progressbar_normal = itemView.findViewById<ImageView>(R.id.more_card_front_progressbar_normal)
        val normal_circle_recyclerview = itemView.findViewById<RecyclerView>(R.id.more_card_circle_recyclerview)


        val front_tv_day_mon = itemView.findViewById<TextView>(R.id.more_card_front_tv_day_mon)
        val front_tv_day_tue = itemView.findViewById<TextView>(R.id.more_card_front_tv_day_tue)
        val front_tv_day_wed = itemView.findViewById<TextView>(R.id.more_card_front_tv_day_wed)
        val front_tv_day_thu = itemView.findViewById<TextView>(R.id.more_card_front_tv_day_thu)
        val front_tv_day_fir = itemView.findViewById<TextView>(R.id.more_card_front_tv_day_fri)
        val front_tv_day_sat = itemView.findViewById<TextView>(R.id.more_card_front_tv_day_sat)
        val front_tv_day_sun = itemView.findViewById<TextView>(R.id.more_card_front_tv_day_sun)

        val front_stroke = itemView.findViewById<ImageView>(R.id.more_card_front_stroke)

        val progressbar_front = itemView.findViewById<ProgressBar>(R.id.more_card_front_progressbar)

        /*-------------------------------------------back-----------------------------------------------*/

        val back_background_img = itemView.findViewById<ImageView>(R.id.more_card_back_backgroundimg)
        val back_img = itemView.findViewById<ImageView>(R.id.more_card_back_img)
        val back_stroke = itemView.findViewById<ImageView>(R.id.more_card_back_stroke)
        //val back_imageView = itemView.findViewById<TextView>(R.id.more_card_back_imageView)

        val back_tv_top_category = itemView.findViewById<TextView>(R.id.more_card_back_tv_top_category)
        val back_tv_count_num_behind = itemView.findViewById<TextView>(R.id.more_card_back_tv_count_num_behind)
        val back_tv_mission_name = itemView.findViewById<TextView>(R.id.more_card_back_tv_mission_name)
        //val back_tv_mission_total_count = itemView.findViewById<TextView>(R.id.more_card_back_tv_mission_total_count)
        val back_tv_mission_category_eng = itemView.findViewById<TextView>(R.id.more_card_back_tv_mission_category_eng)
        val back_tv_mission_category_kor = itemView.findViewById<TextView>(R.id.more_card_back_tv_mission_category_kor)
        val back_tv_achieve_count = itemView.findViewById<TextView>(R.id.more_card_back_tv_achieve_count)
        val back_tv_start_date_title = itemView.findViewById<TextView>(R.id.more_card_back_tv_start_date_title)
        val back_tv_end_date_title = itemView.findViewById<TextView>(R.id.more_card_back_tv_end_date_title)
        val back_tv_achieve_count_num = itemView.findViewById<TextView>(R.id.more_card_back_tv_achieve_count_num)
        val back_tv_times = itemView.findViewById<TextView>(R.id.more_card_back_tv_times)
        val back_tv_start_date = itemView.findViewById<TextView>(R.id.more_card_back_tv_start_date)
        val back_tv_end_date = itemView.findViewById<TextView>(R.id.more_card_back_tv_end_date)
        val back_tv_process = itemView.findViewById<TextView>(R.id.more_card_back_tv_process)
        val back_tv_process_count = itemView.findViewById<TextView>(R.id.more_card_back_tv_process_count)
        val back_tv_count_slash = itemView.findViewById<TextView>(R.id.more_card_back_tv_count_slash)
        val back_tv_total_count = itemView.findViewById<TextView>(R.id.more_card_back_tv_total_count)
        val back_tv_mission_content = itemView.findViewById<TextView>(R.id.more_card_back_tv_mission_content)
        val back_tv_bottom_sentence = itemView.findViewById<TextView>(R.id.more_card_back_tv_bottom_sentence)

        val progressbar = itemView.findViewById<ProgressBar>(R.id.more_card_back_progressbar)

        fun getPos(count : Int){
            front_normal_index.x = 70F
            front_tv_index_count_num.x = 70F

            front_normal_index.x += 48*count
            front_tv_index_count_num.x += 48*count
        }

        fun bind(HomeMoreCardData: HomeMoreCardData, context: Context) {

            /*-----------------------------------------뒤집는 애니메이션------------------------------------------*/

            backcard.visibility=View.GONE;

            frontcard.setOnClickListener {
                backcard.visibility=View.VISIBLE
                mSetRightOut.setTarget(frontcard)
                mSetLeftIn.setTarget(backcard)
                mSetRightOut.start()
                mSetLeftIn.start()
                val distance = 8000
                val scale: Float = context.resources.displayMetrics.density * distance
                frontcard.setCameraDistance(scale)
            }

            backcard.setOnClickListener {
                frontcard.visibility=View.VISIBLE
                mSetRightOut.setTarget(backcard)
                mSetLeftIn.setTarget(frontcard)
                mSetRightOut.start()
                mSetLeftIn.start()
                val distance = 8000
                val scale: Float = context.resources.displayMetrics.density * distance
                backcard.setCameraDistance(scale)
            }


            /*----------------------------------미션마다 다른 정보 우선 배정--------------------------------------------*/
            //카드에 보이게 되는 정보들
            front_tv_mission_name.text = HomeMoreCardData.mission_name
            //front_tv_mission_total_count.text = HomeMoreCardData.dayDuring.toString()
            front_tv_start_date.text = HomeMoreCardData.start_date
            front_tv_end_date.text = HomeMoreCardData.end_date
            front_tv_achieve_count_num.text = HomeMoreCardData.count.toString()
            front_tv_process_count.text = HomeMoreCardData.count.toString()
            front_tv_total_count.text = HomeMoreCardData.dayDuring.toString()
            front_tv_index_count_num.text = HomeMoreCardData.count.toString()

            back_tv_mission_name.text = HomeMoreCardData.mission_name
            //back_tv_mission_total_count.text = HomeMoreCardData.dayDuring.toString()
            back_tv_start_date.text = HomeMoreCardData.start_date
            back_tv_end_date.text = HomeMoreCardData.end_date
            back_tv_achieve_count_num.text = HomeMoreCardData.count.toString()
            back_tv_process_count.text = HomeMoreCardData.count.toString()
            back_tv_total_count.text = HomeMoreCardData.dayDuring.toString()
            back_tv_mission_content.text = HomeMoreCardData.mission_expression
            back_tv_count_num_behind.text = HomeMoreCardData.dayDuring.toString()

            var count_for_progressbar = HomeMoreCardData.count.toFloat()/HomeMoreCardData.dayDuring*100
            var int = count_for_progressbar.toInt()
            progressbar.progress = int
            progressbar_front.progress = int


            /*----------------------------------타입마다 다른 정보 나중 배정--------------------------------------------*/

            if(HomeMoreCardData.flag === 0){
                //원 스탬프 그리기
                createCircle(HomeMoreCardData.count, HomeMoreCardData.index)
                getPos(HomeMoreCardData.count)

                //연속 카드 요소 안 보이게
                front_tv_day_mon.visibility = View.GONE
                front_tv_day_tue.visibility = View.GONE
                front_tv_day_wed.visibility = View.GONE
                front_tv_day_thu.visibility = View.GONE
                front_tv_day_fir.visibility = View.GONE
                front_tv_day_sat.visibility = View.GONE
                front_tv_day_sun.visibility = View.GONE
                back_tv_count_num_behind.visibility = View.GONE

            }else if(HomeMoreCardData.flag === 1){
                //캘린더 그리기
                draw_cal(HomeMoreCardData.dayDuring, HomeMoreCardData.index, HomeMoreCardData.start_date, HomeMoreCardData.count)

                //일반 카드 요소 안 보이게
                progressbar_front.visibility=View.GONE
                front_normal_index.visibility = View.GONE
                front_tv_index_count_num.visibility = View.GONE
                front_progressbar_normal.visibility = View.GONE
                normal_circle_recyclerview.visibility = View.GONE
            }

            //유형별 달라지는 부분
            if(HomeMoreCardData.index === 0){

                //유형 변경
                front_tv_mission_category_eng.text="Spending Habit"
                front_tv_mission_category_kor.text="소비 습관 개선"
                front_tv_bottom_sentence.text="Think one more"
                back_tv_mission_category_eng.text="Spending Habit"
                back_tv_mission_category_kor.text="소비 습관 개선"
                back_tv_bottom_sentence.text="Think one more"

                //색 변경
                front_tv_mission_name.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                front_tv_top_category.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                //front_tv_mission_total_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.back_guanicoe))
                front_tv_mission_category_eng.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                front_tv_mission_category_kor.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                front_tv_achieve_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                front_tv_times.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                front_tv_start_date_title.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                front_tv_end_date_title.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                front_tv_start_date.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                front_tv_end_date.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                front_tv_achieve_count_num.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                front_tv_process.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                front_tv_process_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                front_tv_count_slash.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                front_tv_total_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                front_tv_bottom_sentence.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))

                back_tv_top_category.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                back_tv_count_num_behind.setTextColor(ContextCompat.getColor(itemView.context, R.color.blur_guanicoe))
                back_tv_mission_name.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                //back_tv_mission_total_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.back_guanicoe))
                back_tv_mission_category_eng.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                back_tv_mission_category_kor.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                back_tv_achieve_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                back_tv_start_date_title.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                back_tv_end_date_title.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                back_tv_achieve_count_num.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                back_tv_times.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                back_tv_start_date.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                back_tv_end_date.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                back_tv_process.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                back_tv_process_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                back_tv_count_slash.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                back_tv_total_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                back_tv_mission_content.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                back_tv_bottom_sentence.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))

                //이미지 변경
                front_background_img.setImageResource(R.drawable.ic_more_card_background_guanicoe)
                back_background_img.setImageResource(R.drawable.ic_more_card_background_guanicoe)

                progressbar.setProgressDrawableTiled(ContextCompat.getDrawable(itemView.context, R.drawable.progressbar_guanicoe))
                progressbar_front.setProgressDrawableTiled(ContextCompat.getDrawable(itemView.context, R.drawable.main_progressbar_guanicoe))

                if(HomeMoreCardData.flag === 1){
                    front_tv_day_mon.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                    front_tv_day_tue.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                    front_tv_day_wed.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                    front_tv_day_thu.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                    front_tv_day_fir.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                    front_tv_day_sat.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))
                    front_tv_day_sun.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_guanicoe))

                    if(HomeMoreCardData.dayDuring === 7){
                        front_img.setImageResource(R.drawable.ic_home_more_card_front_7_guanicoe)
                        front_stroke.visibility = View.GONE
                        front_tv_top_category.text = "모어 7일"

                        back_img.setImageResource(R.drawable.ic_home_more_card_back_7_guanicoe)
                        back_stroke.visibility = View.GONE
                        back_tv_top_category.text = "모어 7일"
                    }else if(HomeMoreCardData.dayDuring === 14){
                        front_img.setImageResource(R.drawable.ic_home_more_card_front_14_guanicoe)
                        front_stroke.visibility = View.GONE
                        front_tv_top_category.text = "모어 14일"

                        back_img.setImageResource(R.drawable.ic_home_more_card_back_14_guanicoe)
                        back_stroke.visibility = View.GONE
                        back_tv_top_category.text = "모어 14일"
                    }else if(HomeMoreCardData.dayDuring === 21){
                        front_img.setImageResource(R.drawable.ic_home_more_card_front_21_guanicoe)
                        front_stroke.setImageResource(R.drawable.ic_home_more_card_stroke_guanicoe)
                        front_tv_top_category.text = "모어 21일"

                        back_img.setImageResource(R.drawable.ic_home_more_card_back_21_guanicoe)
                        back_stroke.setImageResource(R.drawable.ic_home_more_card_stroke_guanicoe)
                        back_tv_top_category.text = "모어 21일"
                    }

                } else if(HomeMoreCardData.flag === 0){
                    front_img.setImageResource(R.drawable.ic_home_more_card_front_7_guanicoe)
                    front_stroke.visibility = View.GONE
                    front_tv_top_category.text = "애니"
                    //front_tv_mission_total_count.text=""
                    front_normal_index.setImageResource(R.drawable.ic_normal_index_guanicoe)
                    front_tv_index_count_num.setTextColor(ContextCompat.getColor(itemView.context, R.color.back_guanicoe))
                    front_progressbar_normal.setImageResource(R.drawable.ic_home_more_card_progressbar_guanicoe)

                    back_img.setImageResource(R.drawable.ic_home_more_card_back_0_guanicoe)
                    back_stroke.visibility = View.GONE
                    back_tv_top_category.text = "애니"
                    //back_tv_mission_total_count.text=""
                }

            }else if(HomeMoreCardData.index === 1){

                //유형 변경
                front_tv_mission_category_eng.text="Saving Electricity"
                front_tv_mission_category_kor.text="전기 절약"
                front_tv_bottom_sentence.text="Not yours, Ours"
                back_tv_mission_category_eng.text="Saving Electricity"
                back_tv_mission_category_kor.text="전기 절약"
                back_tv_bottom_sentence.text="Not yours, Ours"

                //색 변경
                front_tv_mission_name.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                front_tv_top_category.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                //front_tv_mission_total_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.back_illipika))
                front_tv_mission_category_eng.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                front_tv_mission_category_kor.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                front_tv_achieve_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                front_tv_times.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                front_tv_start_date_title.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                front_tv_end_date_title.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                front_tv_start_date.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                front_tv_end_date.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                front_tv_achieve_count_num.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                front_tv_process.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                front_tv_process_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                front_tv_count_slash.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                front_tv_total_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                front_tv_bottom_sentence.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))

                back_tv_top_category.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                back_tv_count_num_behind.setTextColor(ContextCompat.getColor(itemView.context, R.color.blur_illipika))
                back_tv_mission_name.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                //back_tv_mission_total_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.back_illipika))
                back_tv_mission_category_eng.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                back_tv_mission_category_kor.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                back_tv_achieve_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                back_tv_start_date_title.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                back_tv_end_date_title.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                back_tv_achieve_count_num.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                back_tv_times.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                back_tv_start_date.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                back_tv_end_date.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                back_tv_process.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                back_tv_process_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                back_tv_count_slash.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                back_tv_total_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                back_tv_mission_content.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                back_tv_bottom_sentence.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))

                //이미지 변경
                front_background_img.setImageResource(R.drawable.ic_more_card_background_illipika)
                back_background_img.setImageResource(R.drawable.ic_more_card_background_illipika)

                progressbar.setProgressDrawableTiled(ContextCompat.getDrawable(itemView.context, R.drawable.progressbar_illipika))
                progressbar_front.setProgressDrawableTiled(ContextCompat.getDrawable(itemView.context, R.drawable.main_progressbar_illipika))

                if(HomeMoreCardData.flag === 1){
                    front_tv_day_mon.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                    front_tv_day_tue.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                    front_tv_day_wed.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                    front_tv_day_thu.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                    front_tv_day_fir.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                    front_tv_day_sat.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))
                    front_tv_day_sun.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_illipika))

                    if(HomeMoreCardData.dayDuring === 7){
                        front_img.setImageResource(R.drawable.ic_home_more_card_front_7_illipika)
                        front_stroke.visibility = View.GONE
                        front_tv_top_category.text = "모어 7일"

                        back_img.setImageResource(R.drawable.ic_home_more_card_back_7_illipika)
                        back_stroke.visibility = View.GONE
                        back_tv_top_category.text = "모어 7일"
                    }else if(HomeMoreCardData.dayDuring === 14){
                        front_img.setImageResource(R.drawable.ic_home_more_card_front_14_illipika)
                        front_stroke.visibility = View.GONE
                        front_tv_top_category.text = "모어 14일"

                        back_img.setImageResource(R.drawable.ic_home_more_card_back_14_illipika)
                        back_stroke.visibility = View.GONE
                        back_tv_top_category.text = "모어 14일"
                    }else if(HomeMoreCardData.dayDuring === 21){
                        front_img.setImageResource(R.drawable.ic_home_more_card_front_21_illipika)
                        front_stroke.setImageResource(R.drawable.ic_home_more_card_stroke_illipika)
                        front_tv_top_category.text = "모어 21일"

                        back_img.setImageResource(R.drawable.ic_home_more_card_back_21_illipika)
                        back_stroke.setImageResource(R.drawable.ic_home_more_card_stroke_illipika)
                        back_tv_top_category.text = "모어 21일"
                    }

                } else if(HomeMoreCardData.flag === 0){
                    front_img.setImageResource(R.drawable.ic_home_more_card_front_7_illipika)
                    front_stroke.visibility = View.GONE
                    front_tv_top_category.text = "애니"
                    //front_tv_mission_total_count.text=""
                    front_normal_index.setImageResource(R.drawable.ic_normal_index_illipika)
                    front_tv_index_count_num.setTextColor(ContextCompat.getColor(itemView.context, R.color.back_illipika))
                    front_progressbar_normal.setImageResource(R.drawable.ic_home_more_card_progressbar_illipika)

                    back_img.setImageResource(R.drawable.ic_home_more_card_back_0_illipika)
                    back_stroke.visibility = View.GONE
                    back_tv_top_category.text = "애니"
                    //back_tv_mission_total_count.text=""
                }

            }else if(HomeMoreCardData.index === 2){

                //유형 변경
                front_tv_mission_category_eng.text="Reduce Trash"
                front_tv_mission_category_kor.text="쓰레기 배출량 감소"
                front_tv_bottom_sentence.text="Our Planet"
                back_tv_mission_category_eng.text="Reduce Trash"
                back_tv_mission_category_kor.text="쓰레기 배출량 감소"
                back_tv_bottom_sentence.text="Our Planet"

                //색 변경
                front_tv_mission_name.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                front_tv_top_category.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                //front_tv_mission_total_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.back_harpseal))
                front_tv_mission_category_eng.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                front_tv_mission_category_kor.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                front_tv_achieve_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                front_tv_times.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                front_tv_start_date_title.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                front_tv_end_date_title.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                front_tv_start_date.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                front_tv_end_date.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                front_tv_achieve_count_num.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                front_tv_process.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                front_tv_process_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                front_tv_count_slash.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                front_tv_total_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                front_tv_bottom_sentence.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))

                back_tv_top_category.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                back_tv_count_num_behind.setTextColor(ContextCompat.getColor(itemView.context, R.color.blur_harpseal))
                back_tv_mission_name.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                //back_tv_mission_total_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.back_harpseal))
                back_tv_mission_category_eng.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                back_tv_mission_category_kor.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                back_tv_achieve_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                back_tv_start_date_title.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                back_tv_end_date_title.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                back_tv_achieve_count_num.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                back_tv_times.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                back_tv_start_date.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                back_tv_end_date.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                back_tv_process.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                back_tv_process_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                back_tv_count_slash.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                back_tv_total_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                back_tv_mission_content.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                back_tv_bottom_sentence.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))

                //이미지 변경
                front_background_img.setImageResource(R.drawable.ic_more_card_background_harpseal)
                back_background_img.setImageResource(R.drawable.ic_more_card_background_harpseal)

                progressbar.setProgressDrawableTiled(ContextCompat.getDrawable(itemView.context, R.drawable.progressbar_harpseal))
                progressbar_front.setProgressDrawableTiled(ContextCompat.getDrawable(itemView.context, R.drawable.main_progressbar_harpseal))

                if(HomeMoreCardData.flag === 1){
                    front_tv_day_mon.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                    front_tv_day_tue.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                    front_tv_day_wed.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                    front_tv_day_thu.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                    front_tv_day_fir.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                    front_tv_day_sat.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))
                    front_tv_day_sun.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_harpseal))

                    if(HomeMoreCardData.dayDuring === 7){
                        front_img.setImageResource(R.drawable.ic_home_more_card_front_7_harpseal)
                        front_stroke.visibility = View.GONE
                        front_tv_top_category.text = "모어 7일"

                        back_img.setImageResource(R.drawable.ic_home_more_card_back_7_harpseal)
                        back_stroke.visibility = View.GONE
                        back_tv_top_category.text = "모어 7일"
                    }else if(HomeMoreCardData.dayDuring === 14){
                        front_img.setImageResource(R.drawable.ic_home_more_card_front_14_harpseal)
                        front_stroke.visibility = View.GONE
                        front_tv_top_category.text = "모어 14일"

                        back_img.setImageResource(R.drawable.ic_home_more_card_back_14_harpseal)
                        back_stroke.visibility = View.GONE
                        back_tv_top_category.text = "모어 14일"
                    }else if(HomeMoreCardData.dayDuring === 21){
                        front_img.setImageResource(R.drawable.ic_home_more_card_front_21_harpseal)
                        front_stroke.setImageResource(R.drawable.ic_home_more_card_stroke_harpseal)
                        front_tv_top_category.text = "모어 21일"

                        back_img.setImageResource(R.drawable.ic_home_more_card_back_21_harpseal)
                        back_stroke.setImageResource(R.drawable.ic_home_more_card_stroke_harpseal)
                        back_tv_top_category.text = "모어 21일"
                    }

                } else if(HomeMoreCardData.flag === 0){
                    front_img.setImageResource(R.drawable.ic_home_more_card_front_7_harpseal)
                    front_stroke.visibility = View.GONE
                    front_tv_top_category.text = "애니"
                    //front_tv_mission_total_count.text=""
                    front_normal_index.setImageResource(R.drawable.ic_normal_index_harpseal)
                    front_tv_index_count_num.setTextColor(ContextCompat.getColor(itemView.context, R.color.back_harpseal))
                    front_progressbar_normal.setImageResource(R.drawable.ic_home_more_card_progressbar_harpseal)

                    back_img.setImageResource(R.drawable.ic_home_more_card_back_0_harpseal)
                    back_stroke.visibility = View.GONE
                    back_tv_top_category.text = "애니"
                    //back_tv_mission_total_count.text=""
                }

            }else if(HomeMoreCardData.index === 3){

                //유형 변경
                front_tv_mission_category_eng.text="Paperless"
                front_tv_mission_category_kor.text="페이퍼리스"
                front_tv_bottom_sentence.text="For treeeeeee"
                back_tv_mission_category_eng.text="Paperless"
                back_tv_mission_category_kor.text="페이퍼리스"
                back_tv_bottom_sentence.text="For treeeeeee"

                //색 변경
                front_tv_mission_name.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                front_tv_top_category.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                //front_tv_mission_total_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.back_java))
                front_tv_mission_category_eng.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                front_tv_mission_category_kor.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                front_tv_achieve_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                front_tv_times.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                front_tv_start_date_title.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                front_tv_end_date_title.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                front_tv_start_date.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                front_tv_end_date.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                front_tv_achieve_count_num.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                front_tv_process.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                front_tv_process_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                front_tv_count_slash.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                front_tv_total_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                front_tv_bottom_sentence.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))

                back_tv_top_category.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                back_tv_count_num_behind.setTextColor(ContextCompat.getColor(itemView.context, R.color.blur_java))
                back_tv_mission_name.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                //back_tv_mission_total_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.back_java))
                back_tv_mission_category_eng.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                back_tv_mission_category_kor.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                back_tv_achieve_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                back_tv_start_date_title.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                back_tv_end_date_title.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                back_tv_achieve_count_num.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                back_tv_times.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                back_tv_start_date.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                back_tv_end_date.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                back_tv_process.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                back_tv_process_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                back_tv_count_slash.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                back_tv_total_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                back_tv_mission_content.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                back_tv_bottom_sentence.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))

                //이미지 변경
                front_background_img.setImageResource(R.drawable.ic_more_card_background_java)
                back_background_img.setImageResource(R.drawable.ic_more_card_background_java)

                progressbar.setProgressDrawableTiled(ContextCompat.getDrawable(itemView.context, R.drawable.progressbar_java))
                progressbar_front.setProgressDrawableTiled(ContextCompat.getDrawable(itemView.context, R.drawable.main_progressbar_java))

                if(HomeMoreCardData.flag === 1){
                    front_tv_day_mon.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                    front_tv_day_tue.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                    front_tv_day_wed.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                    front_tv_day_thu.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                    front_tv_day_fir.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                    front_tv_day_sat.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))
                    front_tv_day_sun.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_java))

                    if(HomeMoreCardData.dayDuring === 7){
                        front_img.setImageResource(R.drawable.ic_home_more_card_front_7_java)
                        front_stroke.visibility = View.GONE
                        front_tv_top_category.text = "모어 7일"

                        back_img.setImageResource(R.drawable.ic_home_more_card_back_7_java)
                        back_stroke.visibility = View.GONE
                        back_tv_top_category.text = "모어 7일"
                    }else if(HomeMoreCardData.dayDuring === 14){
                        front_img.setImageResource(R.drawable.ic_home_more_card_front_14_java)
                        front_stroke.visibility = View.GONE
                        front_tv_top_category.text = "모어 14일"

                        back_img.setImageResource(R.drawable.ic_home_more_card_back_14_java)
                        back_stroke.visibility = View.GONE
                        back_tv_top_category.text = "모어 14일"
                    }else if(HomeMoreCardData.dayDuring === 21){
                        front_img.setImageResource(R.drawable.ic_home_more_card_front_21_java)
                        front_stroke.setImageResource(R.drawable.ic_home_more_card_stroke_java)
                        front_tv_top_category.text = "모어 21일"

                        back_img.setImageResource(R.drawable.ic_home_more_card_back_21_java)
                        back_stroke.setImageResource(R.drawable.ic_home_more_card_stroke_java)
                        back_tv_top_category.text = "모어 21일"
                    }

                } else if(HomeMoreCardData.flag === 0){
                    front_img.setImageResource(R.drawable.ic_home_more_card_front_7_java)
                    front_stroke.visibility = View.GONE
                    front_tv_top_category.text = "애니"
                    //front_tv_mission_total_count.text=""
                    front_normal_index.setImageResource(R.drawable.ic_normal_index_java)
                    front_tv_index_count_num.setTextColor(ContextCompat.getColor(itemView.context, R.color.back_java))
                    front_progressbar_normal.setImageResource(R.drawable.ic_home_more_card_progressbar_java)

                    back_img.setImageResource(R.drawable.ic_home_more_card_back_0_java)
                    back_stroke.visibility = View.GONE
                    back_tv_top_category.text = "애니"
                    //back_tv_mission_total_count.text=""
                }

            }else if(HomeMoreCardData.index === 4){
                //유형 변경
                front_tv_mission_category_eng.text="Living Habit"
                front_tv_mission_category_kor.text="생활 습관 개선"
                front_tv_bottom_sentence.text="YOU&I"
                back_tv_mission_category_eng.text="Living Habit"
                back_tv_mission_category_kor.text="생활 습관 개선"
                back_tv_bottom_sentence.text="YOU&I"

                //색 변경
                front_tv_mission_name.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                front_tv_top_category.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                //front_tv_mission_total_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.back_bengaltiger))
                front_tv_mission_category_eng.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                front_tv_mission_category_kor.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                front_tv_achieve_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                front_tv_times.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                front_tv_start_date_title.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                front_tv_end_date_title.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                front_tv_start_date.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                front_tv_end_date.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                front_tv_achieve_count_num.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                front_tv_process.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                front_tv_process_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                front_tv_count_slash.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                front_tv_total_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                front_tv_bottom_sentence.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))

                back_tv_top_category.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                back_tv_count_num_behind.setTextColor(ContextCompat.getColor(itemView.context, R.color.blur_bengal))
                back_tv_mission_name.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                //back_tv_mission_total_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.back_bengaltiger))
                back_tv_mission_category_eng.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                back_tv_mission_category_kor.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                back_tv_achieve_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                back_tv_start_date_title.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                back_tv_end_date_title.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                back_tv_achieve_count_num.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                back_tv_times.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                back_tv_start_date.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                back_tv_end_date.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                back_tv_process.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                back_tv_process_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                back_tv_count_slash.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                back_tv_total_count.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                back_tv_mission_content.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                back_tv_bottom_sentence.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))

                //이미지 변경
                front_background_img.setImageResource(R.drawable.ic_more_card_background_bengal)
                back_background_img.setImageResource(R.drawable.ic_more_card_background_bengal)

                progressbar.setProgressDrawableTiled(ContextCompat.getDrawable(itemView.context, R.drawable.progressbar_bengal))
                progressbar_front.setProgressDrawableTiled(ContextCompat.getDrawable(itemView.context, R.drawable.main_progressbar_bengal))

                if(HomeMoreCardData.flag === 1){
                    front_tv_day_mon.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                    front_tv_day_tue.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                    front_tv_day_wed.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                    front_tv_day_thu.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                    front_tv_day_fir.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                    front_tv_day_sat.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))
                    front_tv_day_sun.setTextColor(ContextCompat.getColor(itemView.context, R.color.stroke_bengaltiger))

                    if(HomeMoreCardData.dayDuring === 7){
                        front_img.setImageResource(R.drawable.ic_home_more_card_front_7_bengal)
                        front_stroke.visibility = View.GONE
                        front_tv_top_category.text = "모어 7일"

                        back_img.setImageResource(R.drawable.ic_home_more_card_back_7_bengal)
                        back_stroke.visibility = View.GONE
                        back_tv_top_category.text = "모어 7일"
                    }else if(HomeMoreCardData.dayDuring === 14){
                        front_img.setImageResource(R.drawable.ic_home_more_card_front_14_bengal)
                        front_stroke.visibility = View.GONE
                        front_tv_top_category.text = "모어 14일"

                        back_img.setImageResource(R.drawable.ic_home_more_card_back_14_bengal)
                        back_stroke.visibility = View.GONE
                        back_tv_top_category.text = "모어 14일"
                    }else if(HomeMoreCardData.dayDuring === 21){
                        front_img.setImageResource(R.drawable.ic_home_more_card_front_21_bengal)
                        front_stroke.setImageResource(R.drawable.ic_home_more_card_stroke_bengal)
                        front_tv_top_category.text = "모어 21일"

                        back_img.setImageResource(R.drawable.ic_home_more_card_back_21_bengal)
                        back_stroke.setImageResource(R.drawable.ic_home_more_card_stroke_bengal)
                        back_tv_top_category.text = "모어 21일"
                    }

                } else if(HomeMoreCardData.flag === 0){
                    front_img.setImageResource(R.drawable.ic_home_more_card_front_7_bengal)
                    front_stroke.visibility = View.GONE
                    front_tv_top_category.text = "애니"
                    //front_tv_mission_total_count.text=""
                    front_normal_index.setImageResource(R.drawable.ic_normal_index_bengaltiger)
                    front_tv_index_count_num.setTextColor(ContextCompat.getColor(itemView.context, R.color.back_bengaltiger))
                    front_progressbar_normal.setImageResource(R.drawable.ic_home_more_card_progressbar_bengal)

                    back_img.setImageResource(R.drawable.ic_home_more_card_back_0_bengal)
                    back_stroke.visibility = View.GONE
                    back_tv_top_category.text = "애니"
                    //back_tv_mission_total_count.text=""
                }
            }
        }
    }
}