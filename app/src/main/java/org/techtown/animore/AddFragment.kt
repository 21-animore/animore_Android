package org.techtown.animore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.navigation.Navigation

class AddFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_add, container, false)

        view.findViewById<ImageButton>(R.id.btn_to_add_animal_guanicoe).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_add_fragment_to_add_animal_guanicoe)
        }

        view.findViewById<ImageButton>(R.id.btn_to_add_animal_illipika).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_add_fragment_to_add_animal_illipika)
        }

        view.findViewById<ImageButton>(R.id.btn_to_add_animal_harpseal).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_add_fragment_to_add_animal_harpseal)
        }

        view.findViewById<ImageButton>(R.id.btn_to_add_animal_java).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_add_fragment_to_add_animal_java)
        }

        view.findViewById<ImageButton>(R.id.btn_to_add_animal_bengal).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_add_fragment_to_add_animal_bengal)
        }
        return view
    }

}