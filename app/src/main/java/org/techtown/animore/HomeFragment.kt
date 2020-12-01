package org.techtown.animore

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        //클릭하는 카드마다 다른 정보를 넘겨줘야 되는데 list로 받아오는게 맞는지..? 아니네 덜덜..
        /*
        view.findViewById<CardView>(R.id.normal_card_list).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_home_fragment_to_home_more_card_fragment)
        }
        */
        
        return view

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var dump1 = MainCardData(4, "안드어린이에게", true, 7)
        var dump2 = MainCardData(3, "리사이클러뷰는",true, 14)
        var dump3 = MainCardData(2, "너무어려워허엉", true, 21)

        //val MyData:MutableList<NormalCardData> = mutableListOf<NormalCardData>(NormalCardData(title,))
        val MyData:MutableList<MainCardData> = mutableListOf<MainCardData>(dump1, dump2, dump3)

        //MyData에 넘겨 받은 카드 개수에 맞춰 width 조절
        var width = (MyData.size +1) * 697
        var layout = LinearLayout.LayoutParams(width,LinearLayout.LayoutParams.WRAP_CONTENT)

        normal_card_list.layoutParams = layout

        val No = MainCardAdapter()
        No.datas.add(dump1)
        No.datas.add(dump2)
        No.datas.add(dump3)

        normal_card_list.adapter = No
        //No.notifyDataSetChanged()

/*
        Log.d("title", arguments?.getString("title").toString())
        //bundle에 담겨온 데이터를 title이라는 변수에 넣어준다
        val title = arguments?.getString("title").toString()
 */

    }
}