package org.techtown.animore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.min.flipanimation.MyCard
import com.min.flipanimation.MyDATA
import kotlinx.android.synthetic.main.test_layout.*

class MyTest: Fragment() {

    var isflip = false

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.test_layout, container, false)

        return view;
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var my_data = mutableListOf<MyDATA>((MyDATA(1,"에헷",false)),(MyDATA(2,"이런",false)),(MyDATA(3,"어머!",false)))
        var HorizontalLayout2 = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL,false)

        var myadap = MyCard(requireContext(),my_data)
        myrecycler.layoutManager = HorizontalLayout2
        myrecycler.adapter = myadap
        myadap.notifyDataSetChanged()

    }

    fun flipcard(){
    }



}