package org.techtown.animore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import org.techtown.animore.R

class AddFragementAnimalGuanicoe : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_animal_guanicoe, container, false)

        view.findViewById<Button>(R.id.intro_animal_card_btn_to_get_randomcard_guanicoe).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_add_animal_guanicoe_to_add_random_guanicoe)
        }

        return view;
    }
}