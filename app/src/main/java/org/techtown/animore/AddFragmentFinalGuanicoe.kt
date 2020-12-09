package org.techtown.animore

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_add_random_guanicoe.view.*
import kotlinx.android.synthetic.main.fragment_add_random_guanicoe.view.random_animal_card_btn_to_select_guanicoe_card_again
import kotlinx.android.synthetic.main.fragment_final_add_guanicoe.*
import kotlinx.android.synthetic.main.fragment_final_add_guanicoe.view.*
import kotlinx.android.synthetic.main.fragment_home.*
import org.techtown.animore.nework.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddFragmentFinalGuanicoe : Fragment() {
    val retrofitClient = RetrofitClient.create(RequestCardInterface::class.java)

    var user_idx = 1
    var mission_name = ""
    var mission_category = 0
    var mission_period = 0
    var mission_start_date = ""
    var mission_end_date = ""
    var mission_content = ""
    var continue_flag = 0

    val mission_acheive_count = 0
    val index = 0;

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_final_add_guanicoe, container, false)

        //이후 버튼을 누르면 POST
        view.findViewById<Button>(R.id.final_animal_card_btn_to_get_maincard_guanicoe).setOnClickListener {
            postMainCard()

            val intent = Intent(requireActivity(), SplashAddCardActivity::class.java)
            startActivity(intent)
        }

        return view;
    }

    fun postMainCard(){

        retrofitClient.postProductRequest(user_idx, mission_name, mission_category, mission_period, mission_start_date, mission_end_date, mission_content, continue_flag).enqueue(object :
            Callback<SimpleDataResponse> {
            override fun onFailure(call: Call<SimpleDataResponse>, t: Throwable) {
                if (t.message != null) {
                    Log.d("AddCard", t.message!!)

                } else {
                    Log.d("AddCard", "통신실패")
                }
            }
            override fun onResponse(
                call: Call<SimpleDataResponse>,
                response: Response<SimpleDataResponse>
            ) {
                if (response.isSuccessful) {
                    if (response.body()!!.success) {
                        Log.d("AddCard", "전체 데이터 : ${response.body()!!}")
                    } else {
                        Log.d("AddCard", "통신실패")
                    }
                } else {
                    Log.d("AddCard", "${response.message()}, ${response.errorBody()}")
                }
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mission_name = arguments?.getString("mission_name").toString()
        mission_content = arguments?.getString("mission_content").toString()

        continue_flag =  arguments?.getString("continue_flag").toString().toInt()
        mission_period = arguments?.getString("mission_period").toString().toInt()
        mission_start_date= arguments?.getString("mission_start_date").toString()
        mission_end_date= arguments?.getString("mission_end_date").toString()

        var card = HomecardDataList(
            card_idx = 0,
            user_idx = user_idx,
            now_flag = 1,
            mission_category = index,
            continue_flag = continue_flag,
            mission_period = mission_period,
            mission_name = mission_name,
            mission_start_date = mission_start_date,
            mission_end_date = mission_end_date,
            mission_acheive_count = mission_acheive_count,
            mission_content = mission_content,
            success_flag = 0)

        val Adapter = MainCardAdapter()
        Adapter.datas.add(card)
        final_add_guanicoe_cardview.adapter = Adapter

    }
}