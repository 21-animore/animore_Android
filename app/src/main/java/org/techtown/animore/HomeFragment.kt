package org.techtown.animore

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)


        //임시로 테스트
        view.findViewById<ImageView>(R.id.main_logo).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_home_fragment_to_home_more_card_fragment)
        }
        view.findViewById<ImageView>(R.id.main_title).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_home_fragment_to_test_fragment)
        }

        //카드를 클릭할 때 넘어가게 하려면 어떤 아이디를 줘야되나??
        
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var dump1 = MainCardData(0, false, 0, "연속7일")
        var dump2 = MainCardData(1, false, 0, "연속14일")
        var dump3 = MainCardData(2, false, 0, "연속21일")
        var dump4 = MainCardData(3, false, 0, "일반")
        var dump5 = MainCardData(4, false, 0, "연속7일")

        //val MyData:MutableList<NormalCardData> = mutableListOf<NormalCardData>(NormalCardData(title,))
        //val MyData:MutableList<MainCardData> = mutableListOf<MainCardData>(dump1, dump2, dump3, dump4)

        val No = MainCardAdapter()
        No.datas.add(dump1)
        No.datas.add(dump2)
        No.datas.add(dump3)
        No.datas.add(dump4)
        No.datas.add(dump5)
        main_card_list.adapter = No

        //MyData에 넘겨 받은 카드 개수에 맞춰 width 조절
        if(No.datas.size === 3){
            var layout = LinearLayout.LayoutParams(2787,LinearLayout.LayoutParams.WRAP_CONTENT)
            main_card_list.layoutParams = layout
        }else if(No.datas.size === 4){
            var layout = LinearLayout.LayoutParams(3715,LinearLayout.LayoutParams.WRAP_CONTENT)
            main_card_list.layoutParams = layout
        }else if(No.datas.size === 5){
            //카드가 5개일 경우 디폴트 카드 삭제
            default_card.visibility = View.GONE;
            var layout = LinearLayout.LayoutParams(4645,LinearLayout.LayoutParams.WRAP_CONTENT)
            main_card_list.layoutParams = layout
        }
        //No.notifyDataSetChanged()

/*
        Log.d("title", arguments?.getString("title").toString())
        //bundle에 담겨온 데이터를 title이라는 변수에 넣어준다
        val title = arguments?.getString("title").toString()
 */

    }
}