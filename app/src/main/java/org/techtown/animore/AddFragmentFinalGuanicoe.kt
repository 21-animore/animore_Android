package org.techtown.animore

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_final_add_guanicoe.*
import kotlinx.android.synthetic.main.fragment_home.*

class AddFragmentFinalGuanicoe : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_final_add_guanicoe, container, false)

        view.findViewById<Button>(R.id.final_animal_card_btn_to_get_maincard_guanicoe).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_add_final_guanicoe_fragment_to_home_fragment)
        }

        return view;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mission_name_guanicoe = arguments?.getString("mission_name_guanicoe").toString()
        val index = arguments?.getString("index").toString()
        Log.d("찍어본다", "name:"+mission_name_guanicoe.toString()+", index:"+index)


        var dump1 = MainCardData(index = index.toInt(), false, 0, mission_name = mission_name_guanicoe)
        val No = MainCardAdapter()
        No.datas.add(dump1)
        final_add_guanicoe_cardview.adapter = No

    }
}