package org.techtown.animore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation

class AddFragementMissionGuanicoe : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_add_random_guanicoe, container, false)

        view.findViewById<Button>(R.id.random_animal_card_btn_to_select_mode_guanicoe).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_add_random_guanicoe_to_add_choose_normal_guanicoe)
        }

        return view;
    }
}