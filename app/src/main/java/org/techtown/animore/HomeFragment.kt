package org.techtown.animore

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.*

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

/*
        view.findViewById<Button>(R.id.home_fragment).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_home_fragment_to_add_fragment)
        }

*/
        //arguments!!.getString("title")?.let { Log.d("title", it) }
        //Log.d("title : ", arguments!!.getString("title").toString())

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("title", arguments?.getString("title").toString())

        //bundle에 담겨온 데이터를 title이라는 변수에 넣어준다
        val title = arguments?.getString("title").toString()

        val MyData:MutableList<NormalCardData> = mutableListOf<NormalCardData>(NormalCardData(title))

        val No = NormalCardAdapter(requireContext(), MyData)
        normal_card_list.adapter = No

    }
}