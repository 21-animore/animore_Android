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

    var dayDuring = "7"
    val today = LocalDate.now()
    val start_date= today.toString()
    var end_date= ""

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_choose_option_continuous_guanicoe, container, false)

        val mission_name_guanicoe = arguments?.getString("mission_name_guanicoe").toString()
        val flag = "true"

        var bundle = bundleOf("mission_name_guanicoe" to mission_name_guanicoe, "flag" to flag, "dayDuring" to dayDuring, "start_date" to start_date, "end_date" to end_date)

        view.choose_option_continuous_button_7_guanicoe.setOnClickListener { view ->
            dayDuring = "7"
            bundle = bundleOf("mission_name_guanicoe" to mission_name_guanicoe, "flag" to flag, "dayDuring" to dayDuring, "start_date" to start_date, "end_date" to end_date)
        }

        view.choose_option_continuous_button_14_guanicoe.setOnClickListener { view ->
            dayDuring = "14"
            bundle = bundleOf("mission_name_guanicoe" to mission_name_guanicoe, "flag" to flag, "dayDuring" to dayDuring, "start_date" to start_date, "end_date" to end_date)
        }

        view.choose_option_continuous_button_21_guanicoe.setOnClickListener { view ->
            dayDuring = "21"
            bundle = bundleOf("mission_name_guanicoe" to mission_name_guanicoe, "flag" to flag, "dayDuring" to dayDuring, "start_date" to start_date, "end_date" to end_date)
        }

        view.findViewById<Button>(R.id.choose_option_continuous_tv_normal_guanicoe).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_add_choose_continuous_guanicoe_to_add_choose_normal_guanicoe, bundle)
        }

        view.findViewById<Button>(R.id.choose_option_continuous_btn_to_get_randomcard_guanicoe).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_add_choose_continuous_guanicoe_to_add_final_guanicoe_fragment, bundle)
        }

        return view;
    }
}