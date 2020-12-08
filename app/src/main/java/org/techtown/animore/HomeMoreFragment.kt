package org.techtown.animore

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home_card_more.*
import kotlinx.android.synthetic.main.fragment_home_card_more.view.*


class HomeMoreFragment : Fragment() {

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
        val view = inflater.inflate(R.layout.fragment_home_card_more, container, false)


        /*--------------------------------받아온 하나의 정보로 카드 1개 그림--------------------------------*/
        bundle_mission_name = arguments?.getString("bundle_mission_name").toString()
        bundle_index = arguments?.getString("bundle_index").toString()
        bundle_count = arguments?.getString("bundle_count").toString()
        bundle_total_count = arguments?.getString("bundle_total_count").toString()
        bundle_start_date = arguments?.getString("bundle_start_date").toString()
        bundle_end_date = arguments?.getString("bundle_end_date").toString()
        bundle_mission_expression = arguments?.getString("bundle_mission_expression").toString()
        Log.d("찍어본다", "name:"+bundle_mission_name.toString()+", index:"+bundle_index)
        /*-----------------------------------------------------------------------------------------------*/


        view.home_more_card_btn_giveup.setOnClickListener { view ->
            home_more_card_btn_cancle.visibility = View.VISIBLE;
            home_more_card_btn_reallygiveup.visibility = View.VISIBLE;
            home_more_card_tv_reallydelete.visibility = View.VISIBLE;
            home_more_card_reallydelete.visibility = View.VISIBLE;
        }

        view.home_more_card_btn_cancle.setOnClickListener { view ->
            home_more_card_tv_deletefin.visibility = GONE;
            home_more_card_btn_cancle.visibility = GONE;
            home_more_card_btn_reallygiveup.visibility = GONE;
            home_more_card_tv_reallydelete.visibility = GONE;
            home_more_card_reallydelete.visibility = GONE;
        }

        view.home_more_card_btn_reallygiveup.setOnClickListener { view ->
            home_more_card_tv_deletefin.visibility = View.VISIBLE;
            home_more_card_btn_cancle.visibility = GONE;
            home_more_card_btn_reallygiveup.visibility = GONE;
            home_more_card_tv_reallydelete.visibility = GONE;
            home_more_card_reallydelete.visibility = View.VISIBLE;
            //카드 삭제하는 API 호출 후 메인 화면으로 돌아가기

        }
        return view;
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*처음에 안 보여야 하는 부분들*/
        home_more_card_tv_deletefin.visibility = GONE;
        home_more_card_btn_cancle.visibility = GONE;
        home_more_card_btn_reallygiveup.visibility = GONE;
        home_more_card_tv_reallydelete.visibility = GONE;
        home_more_card_reallydelete.visibility = GONE;

        
        var dump1 = HomeMoreCardData(0, false, 14, "","", 5,"미션 이름임요","")
        val No = HomeMoreCardAdapter(requireContext())
        No.homemoreitems.add(dump1)

        /*---------------------------------------------------이것저것 적용중------------------------------------------------*/
        var HorizontalLayout2 = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL,false)
        home_more_card.layoutManager = HorizontalLayout2

        home_more_card.adapter = No
        No.notifyDataSetChanged()



        /*---------------------------------------------------상단바 커스텀------------------------------------------------*/
        if(No.homemoreitems[0].index === 0){
            home_more_card_topbar.setImageResource(R.drawable.ic_top_bar_guanicoe)
            home_more_card_tv_mission_name.setTextColor(ContextCompat.getColor(requireActivity(),R.color.stroke_guanicoe))
            home_more_card_back_btn_to_add_frag.setImageResource(R.drawable.ic_back_btn_guanicoe)
        }else if(No.homemoreitems[0].index === 1){
            home_more_card_topbar.setImageResource(R.drawable.ic_top_bar_illipika)
            home_more_card_tv_mission_name.setTextColor(ContextCompat.getColor(requireActivity(), R.color.stroke_illipika))
            home_more_card_back_btn_to_add_frag.setImageResource(R.drawable.ic_back_btn_illipika)
        }else if(No.homemoreitems[0].index === 2){
            home_more_card_topbar.setImageResource(R.drawable.ic_top_bar_harpseal)
            home_more_card_tv_mission_name.setTextColor(ContextCompat.getColor(requireActivity(), R.color.stroke_harpseal))
            home_more_card_back_btn_to_add_frag.setImageResource(R.drawable.ic_back_btn_harpseal)
        }else if(No.homemoreitems[0].index === 3){
            home_more_card_topbar.setImageResource(R.drawable.ic_top_bar_javahornhawk)
            home_more_card_tv_mission_name.setTextColor(ContextCompat.getColor(requireActivity(), R.color.stroke_java))
            home_more_card_back_btn_to_add_frag.setImageResource(R.drawable.ic_back_btn_java)
        }else{
            home_more_card_topbar.setImageResource(R.drawable.ic_top_bar_bengaltiger)
            home_more_card_tv_mission_name.setTextColor(ContextCompat.getColor(requireActivity(), R.color.stroke_bengaltiger))
            home_more_card_back_btn_to_add_frag.setImageResource(R.drawable.ic_back_btn_bengal)
        }

    }
}