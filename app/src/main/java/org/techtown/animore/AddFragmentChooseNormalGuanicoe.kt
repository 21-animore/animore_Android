package org.techtown.animore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import java.time.LocalDate

class AddFragmentChooseNormalGuanicoe : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_choose_option_normal_guanicoe, container, false)

        val mission_name = arguments?.getString("mission_name").toString()
        val mission_content = arguments?.getString("mission_content").toString()
        val continue_flag = "0"
        val mission_period = "21"
        val today = LocalDate.now()
        val mission_start_date= today.toString()
        var mission_end_date = "2020-12-20" //datepicker 날짜 받아오는 방법
        var bundle = bundleOf(
                "mission_name" to mission_name,
                "mission_content" to mission_content,
                "continue_flag" to continue_flag,
                "mission_period" to mission_period,
                "mission_start_date" to mission_start_date,
                "mission_end_date" to mission_end_date)

        view.findViewById<Button>(R.id.choose_option_normal_btn_to_get_final_guanicoe).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_add_choose_normal_guanicoe_to_add_final_guanicoe_fragment, bundle)
        }

        view.findViewById<Button>(R.id.choose_option_normal_tv_continuous_guanicoe).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_add_choose_normal_guanicoe_to_add_choose_continuous_guanicoe, bundle)
        }
        return view;
    }
}