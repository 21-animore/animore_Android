package org.techtown.animore

import android.content.Intent
import android.os.Bundle
import android.provider.Settings.Global.putString
import android.provider.Settings.Secure.putString
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

class AddFragmentChooseNormalGuanicoe : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_choose_option_normal_guanicoe, container, false)

        view.findViewById<Button>(R.id.choose_option_normal_btn_to_get_final_guanicoe).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_add_choose_normal_guanicoe_to_add_final_guanicoe_fragment)
        }

        view.findViewById<Button>(R.id.choose_option_normal_tv_continuous_guanicoe).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_add_choose_normal_guanicoe_to_add_choose_continuous_guanicoe)
        }
        return view;
    }
}