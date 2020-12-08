package org.techtown.animore

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_home_card_more.*
import kotlinx.android.synthetic.main.fragment_past_card_more.*

class PastMoreFragment : Fragment() {

    var bundle_mission_name = ""   //미션 이름
    var bundle_index = ""   //인덱스(유형 구분)
    var bundle_flag = "" //연속 카드 여부
    var bundle_count = ""   //카운트(달성 횟수)
    var bundle_total_count = "" //총 횟수(7,14,21)
    var bundle_start_date = ""  //시작 날짜
    var bundle_end_date = ""    //끝 날짜
    var bundle_mission_expression = "" //미션별 소개 글
    var bundle_success_flag = ""    //성공 여부



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_past_card_more, container, false)

        /*--------------------------------받아온 하나의 정보로 카드 1개 그림--------------------------------*/
        bundle_mission_name = arguments?.getString("bundle_mission_name").toString()
        bundle_flag = arguments?.getString("bundle_flag").toString()
        bundle_index = arguments?.getString("bundle_index").toString()
        bundle_count = arguments?.getString("bundle_count").toString()
        bundle_total_count = arguments?.getString("bundle_total_count").toString()
        bundle_start_date = arguments?.getString("bundle_start_date").toString()
        bundle_end_date = arguments?.getString("bundle_end_date").toString()
        bundle_mission_expression = arguments?.getString("bundle_mission_expression").toString()
        bundle_success_flag = arguments?.getString("bundle_success_flag").toString()
        Log.d("찍어본다", "name:"+bundle_mission_name.toString()+", index:"+bundle_index)
        /*-----------------------------------------------------------------------------------------------*/

        return view;
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        var pastcard = PastMoreCardData(
                index = bundle_index.toInt(),
                flag = bundle_flag.toBoolean(),
                dayDuring = bundle_total_count.toInt(),
                start_date = bundle_start_date,
                end_date = bundle_end_date,
                count = bundle_count.toInt(),
                mission_name = bundle_mission_name,
                mission_expression = bundle_mission_expression,
                success_flag = bundle_success_flag.toBoolean())
        val Adapter = PastMoreCardAdapter()
        Adapter.dataPasts.add(pastcard)
        pastcard_more.adapter = Adapter

        /*---------------------------------------------------상단바 커스텀------------------------------------------------*/
        past_more_card_tv_mission_name.text = bundle_mission_name;

        if(Adapter.dataPasts[0].index === 0){
            past_more_card_topbar.setImageResource(R.drawable.ic_top_bar_guanicoe)
            past_more_card_tv_mission_name.setTextColor(ContextCompat.getColor(requireActivity(),R.color.stroke_guanicoe))
            past_more_card_back_btn_to_add_frag.setImageResource(R.drawable.ic_back_btn_guanicoe)
        }else if(Adapter.dataPasts[0].index === 1){
            past_more_card_topbar.setImageResource(R.drawable.ic_top_bar_illipika)
            past_more_card_tv_mission_name.setTextColor(ContextCompat.getColor(requireActivity(), R.color.stroke_illipika))
            past_more_card_back_btn_to_add_frag.setImageResource(R.drawable.ic_back_btn_illipika)
        }else if(Adapter.dataPasts[0].index === 2){
            past_more_card_topbar.setImageResource(R.drawable.ic_top_bar_harpseal)
            past_more_card_tv_mission_name.setTextColor(ContextCompat.getColor(requireActivity(), R.color.stroke_harpseal))
            past_more_card_back_btn_to_add_frag.setImageResource(R.drawable.ic_back_btn_harpseal)
        }else if(Adapter.dataPasts[0].index === 3){
            past_more_card_topbar.setImageResource(R.drawable.ic_top_bar_javahornhawk)
            past_more_card_tv_mission_name.setTextColor(ContextCompat.getColor(requireActivity(), R.color.stroke_java))
            past_more_card_back_btn_to_add_frag.setImageResource(R.drawable.ic_back_btn_java)
        }else{
            past_more_card_topbar.setImageResource(R.drawable.ic_top_bar_bengaltiger)
            past_more_card_tv_mission_name.setTextColor(ContextCompat.getColor(requireActivity(), R.color.stroke_bengaltiger))
            past_more_card_back_btn_to_add_frag.setImageResource(R.drawable.ic_back_btn_bengal)
        }
    }
}