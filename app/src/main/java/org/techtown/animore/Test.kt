package org.techtown.animore

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_test.*
import kotlinx.android.synthetic.main.fragment_test.view.*
import java.util.*

class Test : Fragment() {

    var view_count = 0  // 더한 tablerow 갯수 셀려는 변수

    fun draw_cal(index: Int) {
        var today = Calendar.getInstance()

        var inputday = start_date.text.toString()
        var ind = inputday.split("-")  //text 를 년/월/일 구분

        var year = ind[0].toInt()
        var month = ind[1].toInt() - 1
        var date = ind[2].toInt()

        today.set(year, month, date)   //날짜로 셋업

        //요일 가져오기 .. 1-일, 2- 월 --> 0부터 시작 할려고 1을 뺌
        var day = today.get(Calendar.DAY_OF_WEEK) - 1
        // 월요일 부터 시작하고 싶으니 0(일요일)=> 6으로 나머지는 1씩 또뺌
        // 인덱스가 0부터 시작해야 계산이 편해서 이렇게 한거임
        day = if (day == 0) 6 else day - 1

        // 몇주인지 계산 월요일부터 시작 안했으면 무조건 7일은 2주 / 14일은 3주 ... 로 만들기
        var week: Int = if (day > 0) (index / 7) else (index / 7) - 1

        // 월요일부터 시작안할때 구분하는 flag -날짜 시작용
        var start = false
        // 끝난 날을 체크하는 count
        var count = 0

        var table_body = myTable

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
            var tbrow = TableRow(requireActivity())
            tbrow.layoutParams = rowParams
            for (j in 0..6) {  //일주일은 7일이니...

                var tv1 = TextView(requireActivity())

                // 본인 textview에 해당하는 param으로 바꿀것
                var t_par = TableRow.LayoutParams(
                        TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.WRAP_CONTENT,
                        1f
                )
                //시작 날ㅉㅏ 체크
                if (j == day) {
                    start = true
                }
                //끝나는 날짜 체크
                if (count >= index) {
                    start = false
                }

                if (start == true) {

                    //날짜 text
                    tv1.text = today.get(Calendar.DATE).toString()
                    //배경.. 실선


                    if (i == week) {
                        if (j % 7 == 0) {
                            tv1.background = getDrawable(requireActivity(), R.drawable.draw_solid_line)
                        } else {
                            tv1.background = getDrawable(requireActivity(), R.drawable.draw_solid_line_4)
                        }
                    } else {
                        if (j % 7 == 0) {
                            tv1.background = getDrawable(requireActivity(), R.drawable.draw_solid_line_2)
                        } else {
                            tv1.background = getDrawable(requireActivity(), R.drawable.draw_solid_line_3)
                        }
                    }
                    //1일씩 날짜 더하기
                    today.add(Calendar.DATE, 1)
                    //id추가 ==> 나중에 색을 칠하기 위한 id
                    tv1.id = count
                    count += 1
                } else {
                    tv1.text = ""
                    //빈칸은 실선


                    if (i == 0) {
                        if (j % 7 == 0) {
                            tv1.background = getDrawable(requireActivity(), R.drawable.draw_dash_1_1)
                        } else {
                            tv1.background = getDrawable(requireActivity(), R.drawable.draw_dash_1_2)
                        }
                        if (j == day - 1) {
                            tv1.background = getDrawable(requireActivity(), R.drawable.draw_dash_1_3)
                        }
                    } else if (i != 0 && i == week) {
                        tv1.background = getDrawable(requireActivity(), R.drawable.draw_dash_1_4)

                    }

                }

                tv1.layoutParams = t_par
                tv1.gravity = Gravity.CENTER
                tv1.setPadding(0, 30, 0, 30)
                //textviw 추가
                tbrow.addView(tv1)

            }
            //tablerow 추가
            table_body.addView(tbrow)
            view_count += 1
        }

    }

    fun fill_color(view: View) {   // 선택날짜 달력 칠하기

        var today = Calendar.getInstance()
        var selday = Calendar.getInstance()
        var inputday1 = start_date.text.toString()
        var inputday2 = select_date.text.toString()
        var ind1 = inputday1.split("-")
        var ind2 = inputday2.split("-")


        today.set(ind1[0].toInt(), ind1[1].toInt() - 1, ind1[2].toInt())
        selday.set(ind2[0].toInt(), ind2[1].toInt() - 1, ind2[2].toInt())

        //시작날짜와 칠할날짜 차이 계산
        var diff = ((selday.timeInMillis - today.timeInMillis) / (24 * 60 * 60 * 1000)).toInt()

        //위에서 만든 id 를 가지고 칠함 (아이디가 날짜가 있을때 마다 0부터 증가함)
        //var table_cell = findViewById<TextView>(diff)
        //table_cell.setBackgroundColor(ContextCompat.getColor(requireActivity(), R.color.stroke_bengaltiger))
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?

    ): View? {
        val view = inflater.inflate(R.layout.fragment_test, container, false)

        view.b_7.setOnClickListener { view ->
            draw_cal(7);
        }

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}