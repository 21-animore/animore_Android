package org.techtown.animore

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_final_add_guanicoe.*

class AddFragmentFinalGuanicoe : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_final_add_guanicoe, container, false)

        view.findViewById<Button>(R.id.final_animal_card_btn_to_get_maincard_guanicoe).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_add_final_guanicoe_fragment_to_home_fragment)
        }

        return view;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mission_name_guanicoe = arguments?.getString("mission_name_guanicoe").toString()
        val flag =  arguments?.getString("flag").toString()
        val dayDuring = arguments?.getString("dayDuring").toString()
        val start_date= arguments?.getString("start_date").toString()
        var end_date= arguments?.getString("end_date").toString()
        Log.d("나잡아봐라", mission_name_guanicoe+", "+flag+", "+dayDuring+", "+start_date+", "+end_date)
        val index = "0"
        val count = "0"

        var card = MainCardData(index = index.toInt(), flag = flag.toBoolean(), dayDuring = dayDuring.toInt(), mission_name = mission_name_guanicoe, start_date = start_date, end_date = end_date, count = count.toInt(), mission_expression = "")
        val Adapter = MainCardAdapter()
        Adapter.datas.add(card)
        final_add_guanicoe_cardview.adapter = Adapter


        /*이 정보들 모두 서버에 POST 해야함*/

    }
}