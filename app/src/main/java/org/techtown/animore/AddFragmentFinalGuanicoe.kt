package org.techtown.animore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
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

        return view;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var dump1 = MainCardData(0, "안드어린이에게", true, 7)
        val No = MainCardAdapter()
        No.datas.add(dump1)
        final_add_guanicoe_cardview.adapter = No

        /*
        val title = tv_mission_name.text.toString()
        val index = 0;
        //bundle에 HomeFragment로 전달하고자 하는 text를 넣는다
        val bundle = bundleOf("title" to title, "index" to index)

        view.findViewById<Button>(R.id.btn_to_get_randomcard_guanicoe).setOnClickListener {
            //fragment 전환 시 bundle을 포함해서 보낸다
            Navigation.findNavController(view).navigate(R.id.action_add_final_normal_guanicoe_fragment_to_home_fragment, bundle)
        }
         */

    }
}