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

        var dump1 = PastCardData(0, true, "성공카드", 7)
        var dump2 = PastCardData(1, true, "실패카드", 14)
        var dump3 = PastCardData(2, true, "성공카드", 21)
        var dump4 = PastCardData(3, true, "성공카드", 7)
        var dump5 = PastCardData(4, true, "실패카드", 14)
        var dump6 = PastCardData(0, false, "실패카드", 21)
        var dump7 = PastCardData(1, false, "실패카드", 7)
        var dump8 = PastCardData(2, false, "실패카드", 14)
        var dump9 = PastCardData(3, false, "실패카드", 21)
        var dump10 = PastCardData(4, false, "실패카드", 7)

        val No = PastCardAdapter()
        No.datas.add(dump1)
        No.datas.add(dump2)
        No.datas.add(dump3)
        No.datas.add(dump4)
        No.datas.add(dump5)
        No.datas.add(dump6)
        No.datas.add(dump7)
        No.datas.add(dump8)
        No.datas.add(dump9)
        No.datas.add(dump10)
        past_card_list.adapter = No

    }
}