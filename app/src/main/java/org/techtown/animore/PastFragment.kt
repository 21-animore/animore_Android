package org.techtown.animore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
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

        /*
        잘 되는 것 확인함 이후 서버에서 종료된 카드 정보 불러와서 데이터 바인딩하기
        */

        var dump1 = PastCardData(0, true, "성공카드")
        var dump2 = PastCardData(1, true, "실패카드")
        var dump3 = PastCardData(2, true, "성공카드")
        var dump4 = PastCardData(3, true, "성공카드")
        var dump5 = PastCardData(4, true, "실패카드")
        var dump6 = PastCardData(0, false, "실패카드")
        var dump7 = PastCardData(1, false, "실패카드")
        var dump8 = PastCardData(2, false, "실패카드")
        var dump9 = PastCardData(3, false, "실패카드")
        var dump10 = PastCardData(4, false, "실패카드")

        val MyData:MutableList<PastCardData> = mutableListOf<PastCardData>(dump1, dump2, dump3, dump4, dump5, dump6, dump7, dump8, dump9, dump10)

        val No = PastCardAdapter(requireContext(), MyData)
        past_card_list.adapter = No

    }
}