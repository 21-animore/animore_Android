package org.techtown.animore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.continuouscard_layout.view.*
import kotlinx.android.synthetic.main.test.view.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class SubActivity : AppCompatActivity()  {
/*
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test)

    }

    var view_count = 0  // 더한 tablerow 갯수 셀려는 변수

    fun draw_7(view: View){   //7일
        draw_cal(7)
    }
    fun draw_14(view: View){
        draw_cal(14)
    }
    fun draw_21(view: View){
        draw_cal(21)
    }

    fun draw_cal(index: Int){
        var today = Calendar.getInstance()

        /*
        var inputday = findViewById<CardView>(R.id.maincard_continuous_view).tv_start_date.text.toString()
        var ind = inputday.split("-")  //text 를 년/월/일 구분
        */

        val now: LocalDate = LocalDate.now()
        val ind = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))

        var year = ind[0].toInt()
        var month = ind[1].toInt()-1
        var date = ind[2].toInt()

        today.set(year, month, date)   //날짜로 셋업

        //요일 가져오기 .. 1-일, 2- 월 => 0부터 시작하는 것이 편하기 때문에 -1
        var day = today.get(Calendar.DAY_OF_WEEK)-1

        // 월요일부터 시작하게 만들기 위해 숫자 하나씩 밀어서 대입
        day = if(day==0) 6 else day -1

        // 몇주인지 계산 월요일부터 시작 안했으면 무조건 7일은 2주 / 14일은 3주 로 만들어서 줄 +1 해두기
        var week :Int = if(day>0) (index/7) else (index/7)-1

        // 월요일부터 시작안할때 구분하는 flag -날짜 시작용
        var start=false

        // 끝난 날을 체크하는 count
        var count=0

        var table_body = findViewById<TableLayout>(R.id.myTable)

        if(view_count!=0){    // 버튼 누를때마다 table row 초기화
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
            var tbrow = TableRow(this)
            tbrow.layoutParams = rowParams
            for (j in 0..6) {  //일주일은 7일이니...

                var tv1 = TextView(this)

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
                if(count>=index){start=false}

                if(start ==true) {

                    //날짜 text
                    tv1.text = today.get(Calendar.DATE).toString()
                    //배경.. 실선
                    tv1.background = getDrawable(R.drawable.draw_solid_line)
                    //1일씩 날짜 더하기
                    today.add(Calendar.DATE, 1)
                    //id추가 ==> 나중에 색을 칠하기 위한 id
                    tv1.id=count
                    count+=1
                }
                else {
                    tv1.text = ""
                    //빈칸은 실선
                    tv1.background = getDrawable(R.drawable.draw_dash_line)
                }
                tv1.layoutParams = t_par
                tv1.gravity = Gravity.CENTER
                tv1.setPadding(0, 30, 0, 30)
                //textviw 추가
                tbrow.addView(tv1)
            }
            //tablerow 추가
            table_body.addView(tbrow)
            view_count+=1
        }

    }

    fun fill_color(view: View){   // 선택날짜 달력 칠하기

        var startday = Calendar.getInstance()
        var selday = Calendar.getInstance()

        //var inputday1 = findViewById<CardView>(R.id.maincard_continuous_view).tv_start_date.text.toString()
        //val now: LocalDate = LocalDate.now()
        //val inputday2 = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))

        //var ind1 = inputday1.split("-")
        //var ind2 = inputday2.split("-")

        var ind1 = "2020-11-26"
        var ind2 = findViewById<TextView>(R.id.test).select_date.text.toString()

        startday.set(ind1[0].toInt(), ind1[1].toInt() - 1, ind1[2].toInt())
        selday.set(ind2[0].toInt(), ind2[1].toInt() - 1, ind2[2].toInt())

        //시작날짜와 칠할날짜 차이 계산
        var diff = ((selday.timeInMillis -startday.timeInMillis)/(24*60*60*1000)).toInt()

        //위에서 만든 id 를 가지고 칠함 (아이디가 날짜가 있을때 마다 0부터 증가함)
        var table_cell = findViewById<TextView>(diff)
        table_cell.setBackgroundColor(getColor(R.color.stroke_bengaltiger))
    }
     */

}