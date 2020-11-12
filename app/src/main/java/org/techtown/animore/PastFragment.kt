package org.techtown.animore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class PastFragment : Fragment() {

    lateinit var pastcardAdapter : PastCardAdapter
    val datas : MutableList<PastCardData> = mutableListOf<PastCardData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_past, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        pastcardAdapter = PastCardAdapter(view.context)
    }
}