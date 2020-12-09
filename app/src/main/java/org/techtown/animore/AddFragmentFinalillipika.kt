package org.techtown.animore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.techtown.animore.R

class AddFragmentFinalillipika : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_final_add_illipika, container, false)

        return view;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*
            var dump1 = MainCardData(0, true, 7, "이건 또 뭐람")
            val No = MainCardAdapter()
            No.datas.add(dump1)
            final_add_bengal_cardview.adapter = No
        */
    }
}