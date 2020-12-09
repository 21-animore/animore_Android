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

        val mission_name_guanicoe = arguments?.getString("mission_name_guanicoe").toString()
        val flag = "false"
        val dayDuring = "21"
        val today = LocalDate.now()
        val start_date= today.toString()
        var end_date= ""
        var bundle = bundleOf(
                "mission_name_guanicoe" to mission_name_guanicoe,
                "flag" to flag,
                "dayDuring" to dayDuring,
                "start_date" to start_date,
                "end_date" to end_date)

        view.findViewById<Button>(R.id.choose_option_normal_btn_to_get_final_guanicoe).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_add_choose_normal_guanicoe_to_add_final_guanicoe_fragment, bundle)
        }

        view.findViewById<Button>(R.id.choose_option_normal_tv_continuous_guanicoe).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_add_choose_normal_guanicoe_to_add_choose_continuous_guanicoe, bundle)
        }
        return view;
    }
}