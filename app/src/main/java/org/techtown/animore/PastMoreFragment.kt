package org.techtown.animore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_home_card_more.*
import kotlinx.android.synthetic.main.fragment_past_card_more.*

class PastMoreFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_past_card_more, container, false)

        return view;
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //앞 화면에서 클릭된 아이템의 정보를 어떻게 받아오지?!

        var dump1 = PastMoreCardData(1, true)
        val No = PastMoreCardAdapter()
        No.dataPasts.add(dump1)
        pastcard_more.adapter = No

        /*---------------------------------------------------상단바 커스텀------------------------------------------------*/
        if(No.dataPasts[0].index === 0){
            past_more_card_topbar.setImageResource(R.drawable.ic_top_bar_guanicoe)
            //past_more_card_tv_mission_name.setTextColor(ContextCompat.getColor(context,R.color.stroke_guanicoe))
            past_more_card_back_btn_to_add_frag.setImageResource(R.drawable.ic_back_btn_guanicoe)
        }else if(No.dataPasts[0].index === 1){
            past_more_card_topbar.setImageResource(R.drawable.ic_top_bar_illipika)
            //past_more_card_tv_mission_name.setTextColor(ContextCompat.getColor(parent.context, R.color.stroke_illipika))
            past_more_card_back_btn_to_add_frag.setImageResource(R.drawable.ic_back_btn_illipika)
        }else if(No.dataPasts[0].index === 2){
            past_more_card_topbar.setImageResource(R.drawable.ic_top_bar_harpseal)
            //past_more_card_tv_mission_name.setTextColor(ContextCompat.getColor(parent.context, R.color.stroke_harpseal))
            past_more_card_back_btn_to_add_frag.setImageResource(R.drawable.ic_back_btn_harpseal)
        }else if(No.dataPasts[0].index === 3){
            past_more_card_topbar.setImageResource(R.drawable.ic_top_bar_javahornhawk)
            //past_more_card_tv_mission_name.setTextColor(ContextCompat.getColor(parent.context, R.color.stroke_java))
            past_more_card_back_btn_to_add_frag.setImageResource(R.drawable.ic_back_btn_java)
        }else{
            past_more_card_topbar.setImageResource(R.drawable.ic_top_bar_bengaltiger)
            //past_more_card_tv_mission_name.setTextColor(ContextCompat.getColor(parent.context, R.color.stroke_bengaltiger))
            past_more_card_back_btn_to_add_frag.setImageResource(R.drawable.ic_back_btn_bengal)
        }
    }
}