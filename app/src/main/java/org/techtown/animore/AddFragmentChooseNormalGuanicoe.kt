package org.techtown.animore

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_choose_option_normal_guanicoe.*
import kotlinx.android.synthetic.main.fragment_final_add_guanicoe.*
import org.techtown.animore.nework.HomecardDataList
import java.time.LocalDate

class AddFragmentChooseNormalGuanicoe : Fragment() {

    var mission_name = ""
    var mission_content = ""
    var continue_flag = ""
    var mission_period = ""
    var today = LocalDate.now()
    var mission_start_date = today.toString()
    var mission_end_date = ""
    var bundle = bundleOf(
        "mission_name" to mission_name,
        "mission_content" to mission_content,
        "continue_flag" to continue_flag,
        "mission_period" to mission_period,
        "mission_start_date" to mission_start_date,
        "mission_end_date" to mission_end_date)


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_choose_option_normal_guanicoe, container, false)

        view.findViewById<Button>(R.id.choose_option_normal_btn_to_get_final_guanicoe).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_add_choose_normal_guanicoe_to_add_final_guanicoe_fragment, bundle)
        }

        view.findViewById<Button>(R.id.choose_option_normal_tv_continuous_guanicoe).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_add_choose_normal_guanicoe_to_add_choose_continuous_guanicoe, bundle)
        }

        view.findViewById<ImageButton>(R.id.choose_option_normal_back_btn_to_add_frag_guanicoe).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_add_choose_normal_guanicoe_to_add_random_guanicoe)
        }
        return view;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mission_name = arguments?.getString("mission_name").toString()
        mission_content = arguments?.getString("mission_content").toString()
        continue_flag = "0"
        mission_period = "21"
        mission_end_date = "2021-01-07" //datepicker 날짜 받아오는 방법

        bundle = bundleOf(
            "mission_name" to mission_name,
            "mission_content" to mission_content,
            "continue_flag" to continue_flag,
            "mission_period" to mission_period,
            "mission_start_date" to mission_start_date,
            "mission_end_date" to mission_end_date)

        choose_option_normal_tv_mission_name_guanicoe.text = mission_name
    }
}