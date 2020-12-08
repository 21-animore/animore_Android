package org.techtown.animore

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_choose_option_continuous_guanicoe.view.*
import kotlinx.android.synthetic.main.fragment_choose_option_continuous_guanicoe.view.choose_option_continuous_button_7_guanicoe
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.maincard_layout.view.*
import java.util.*

class HomeFragment : Fragment() {

    var bundle_mission_name = ""
    var bundle_index = ""
    var bundle_count = ""
    var bundle_total_count = ""
    var bundle_start_date = ""
    var bundle_end_date = ""
    var bundle_mission_expression = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var maincard1 = MainCardData(0, true, 7, "2020-11-23", "2020-12-24", 5, "미션이름입니다", "")
        var maincard2 = MainCardData(1, true, 14, "2020-11-25", "2020-12-24", 2, "미션이름입니다", "")
        var maincard3 = MainCardData(2, true, 14, "2020-11-26", "2020-12-24", 13, "미션이름입니다", "")
        var maincard4 = MainCardData(3, true, 21, "2020-11-27", "2020-12-24", 14, "미션이름입니다", "")
        var maincard5 = MainCardData(4, true, 21, "2020-11-28", "2020-12-24", 10, "미션이름입니다", "")

        val Adapter = MainCardAdapter()
        Adapter.datas.add(maincard1)
        Adapter.datas.add(maincard2)
        Adapter.datas.add(maincard3)
        Adapter.datas.add(maincard4)
        Adapter.datas.add(maincard5)
        main_card_list.adapter = Adapter

        //MyData에 넘겨 받은 카드 개수에 맞춰 width 조절
        if(Adapter.datas.size === 3){
            var layout = LinearLayout.LayoutParams(2787,LinearLayout.LayoutParams.WRAP_CONTENT)
            main_card_list.layoutParams = layout
        }else if(Adapter.datas.size === 4){
            var layout = LinearLayout.LayoutParams(3715,LinearLayout.LayoutParams.WRAP_CONTENT)
            main_card_list.layoutParams = layout
        }else if(Adapter.datas.size === 5){
            //카드가 5개일 경우 디폴트 카드 삭제
            default_card.visibility = View.GONE;
            var layout = LinearLayout.LayoutParams(4645,LinearLayout.LayoutParams.WRAP_CONTENT)
            main_card_list.layoutParams = layout
        }
        //No.notifyDataSetChanged()

    }
}