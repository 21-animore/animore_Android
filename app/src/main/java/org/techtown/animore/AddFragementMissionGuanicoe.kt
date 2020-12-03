package org.techtown.animore

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.eco_card_layout_guanicoe.*
import kotlinx.android.synthetic.main.fragment_add_animal_guanicoe.view.*
import kotlinx.android.synthetic.main.fragment_add_random_guanicoe.*
import kotlinx.android.synthetic.main.maincard_layout.*

class AddFragementMissionGuanicoe : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_add_random_guanicoe, container, false)

        val mission_name_guanicoe = "미션 이름 적기"
        val index = "0";

        //bundle에 HomeFragment로 전달하고자 하는 text를 넣는다
        val bundle = bundleOf("mission_name_guanicoe" to mission_name_guanicoe, "index" to index)
        Log.d("찍어본다", "name:"+mission_name_guanicoe.toString()+", index:"+index)

        view.findViewById<Button>(R.id.random_animal_card_btn_to_select_mode_guanicoe).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_add_random_guanicoe_to_add_choose_normal_guanicoe, bundle)
        }

        return view;
    }
}