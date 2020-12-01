package org.techtown.animore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation

class AddFragementMissionBengal : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_random_bengal, container, false)


        /*
        view.findViewById<Button>(R.id.btn_to_select_mode_bengal).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_add_random_bengal_to_home_more_card_fragment)
        }

         */

        return view;
    }
}