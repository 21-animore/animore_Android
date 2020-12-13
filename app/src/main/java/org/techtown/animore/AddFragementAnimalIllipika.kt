package org.techtown.animore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import org.techtown.animore.R

class AddFragementAnimalIllipika : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_animal_illipika, container, false)

        view.findViewById<Button>(R.id.intro_animal_card_btn_to_get_randomcard_illipika).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_add_animal_illipika_to_add_random_illipika)
        }

        view.findViewById<ImageButton>(R.id.intro_animal_card_back_btn_to_add_frag_illipika).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_add_animal_illipika_to_add_fragment)
        }


        return view;
    }
}