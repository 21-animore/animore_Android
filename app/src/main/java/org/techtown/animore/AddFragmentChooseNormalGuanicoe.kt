package org.techtown.animore

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.provider.Settings.Global.putString
import android.provider.Settings.Secure.putString
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_final_add_guanicoe.*
import java.time.LocalDate
import java.util.*

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