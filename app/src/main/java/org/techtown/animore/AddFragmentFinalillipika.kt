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
import kotlinx.android.synthetic.main.fragment_final_add_harpseal.*
import kotlinx.android.synthetic.main.fragment_final_add_illipika.*

class AddFragmentFinalillipika : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_final_add_illipika, container, false)

        view.findViewById<Button>(R.id.btn_to_get_randomcard_illipika).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_add_final_normal_illipika_fragment_to_home_fragment)
        }

        return view;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var dump1 = MainCardData(1, "안드어린이에게", true, 7)
        val No = MainCardAdapter()
        No.datas.add(dump1)
        final_add_illipika_cardview.adapter = No
    }
}