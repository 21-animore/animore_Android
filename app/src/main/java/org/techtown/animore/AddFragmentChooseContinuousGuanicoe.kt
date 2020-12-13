package org.techtown.animore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_choose_option_continuous_guanicoe.view.*
import java.time.LocalDate

class AddFragmentChooseContinuousGuanicoe : Fragment() {

    var mission_period = "7"
    val today = LocalDate.now()
    val mission_start_date= today.toString()
    var mission_end_date= "2020-12-24"  //여기서 날짜 계산해서 넘기는 방법 고민하기

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_choose_option_continuous_guanicoe, container, false)

        val mission_name = arguments?.getString("mission_name").toString()
        val mission_content = arguments?.getString("mission_content").toString()
        val continue_flag = "1"

        var bundle = bundleOf("mission_name" to mission_name, "mission_content" to mission_content, "continue_flag" to continue_flag, "mission_period" to mission_period, "mission_start_date" to mission_start_date, "mission_end_date" to mission_end_date)

        view.choose_option_continuous_button_7_guanicoe.setOnClickListener { view ->
            mission_period = "7"
            mission_end_date= "2020-12-24"//7일 후 날짜로 바꾸기
            bundle = bundleOf("mission_name" to mission_name, "mission_content" to mission_content, "continue_flag" to continue_flag, "mission_period" to mission_period, "mission_start_date" to mission_start_date, "mission_end_date" to mission_end_date)
        }

        view.choose_option_continuous_button_14_guanicoe.setOnClickListener { view ->
            mission_period = "14"
            mission_end_date= "2020-12-31"//14일 후 날짜로 바꾸기
            bundle = bundleOf("mission_name" to mission_name, "mission_content" to mission_content, "continue_flag" to continue_flag, "mission_period" to mission_period, "mission_start_date" to mission_start_date, "mission_end_date" to mission_end_date)
        }

        view.choose_option_continuous_button_21_guanicoe.setOnClickListener { view ->
            mission_period = "21"
            mission_end_date= "2020-01-07"//21일 후 날짜로 바꾸기
            bundle = bundleOf("mission_name" to mission_name, "mission_content" to mission_content, "continue_flag" to continue_flag, "mission_period" to mission_period, "mission_start_date" to mission_start_date, "mission_end_date" to mission_end_date)
        }

        view.findViewById<Button>(R.id.choose_option_continuous_tv_normal_guanicoe).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_add_choose_continuous_guanicoe_to_add_choose_normal_guanicoe, bundle)
        }

        view.findViewById<Button>(R.id.choose_option_continuous_btn_to_get_randomcard_guanicoe).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_add_choose_continuous_guanicoe_to_add_final_guanicoe_fragment, bundle)
        }

        view.findViewById<ImageButton>(R.id.choose_option_continuous_back_btn_to_add_frag_guanicoe).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_add_choose_continuous_guanicoe_to_add_random_guanicoe)
        }

        return view;
    }
}