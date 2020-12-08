package org.techtown.animore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_past.*

class PastFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_past, container, false)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        //서버에서 과거 카드 정보 받아와서 넣기

        var pastcard1 = PastCardData(0,true,7,"2020-11-08","2020-12-01",7,"미션이름입니다","어쩌구저쩌구",true)
        var pastcard2 = PastCardData(1,false,21,"2020-11-08","2020-12-01",21,"미션이름입니다","어쩌구저쩌구",true)
        var pastcard3 = PastCardData(2,true,14,"2020-11-08","2020-12-01",14,"미션이름입니다","어쩌구저쩌구",true)
        var pastcard4 = PastCardData(3,false,21,"2020-11-08","2020-12-01",21,"미션이름입니다","어쩌구저쩌구",true)
        var pastcard5 = PastCardData(4,true,21,"2020-11-08","2020-12-01",21,"미션이름입니다","어쩌구저쩌구",true)
        var pastcard6 = PastCardData(0,false,21,"2020-11-08","2020-12-01",1,"미션이름입니다","어쩌구저쩌구",false)
        var pastcard7 = PastCardData(1,true,7,"2020-11-08","2020-12-01",1,"미션이름입니다","어쩌구저쩌구",false)
        var pastcard8 = PastCardData(2,false,21,"2020-11-08","2020-12-01",1,"미션이름입니다","어쩌구저쩌구",false)
        var pastcard9 = PastCardData(3,true,14,"2020-11-08","2020-12-01",1,"미션이름입니다","어쩌구저쩌구",false)
        var pastcard10 = PastCardData(4,false,21,"2020-11-08","2020-12-01",1,"미션이름입니다","어쩌구저쩌구",false)

        val Adapter = PastCardAdapter()
        Adapter.datas.add(pastcard1)
        Adapter.datas.add(pastcard2)
        Adapter.datas.add(pastcard3)
        Adapter.datas.add(pastcard4)
        Adapter.datas.add(pastcard5)
        Adapter.datas.add(pastcard6)
        Adapter.datas.add(pastcard7)
        Adapter.datas.add(pastcard8)
        Adapter.datas.add(pastcard9)
        Adapter.datas.add(pastcard10)
        past_card_list.adapter = Adapter

    }
}