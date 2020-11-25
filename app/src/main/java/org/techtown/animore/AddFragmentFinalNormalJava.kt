package org.techtown.animore

import android.content.Intent
import android.os.Bundle
import android.provider.Settings.Global.putString
import android.provider.Settings.Secure.putString
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_final_add_normal_guanicoe.*

class AddFragmentFinalNormalJava : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_final_add_normal_java, container, false)

        view.findViewById<Button>(R.id.btn_to_get_randomcard_java).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_add_final_normal_java_fragment_to_home_fragment)
        }

        return view;
    }
}