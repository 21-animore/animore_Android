package org.techtown.animore

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.eco_card_layout_guanicoe.*
import kotlinx.android.synthetic.main.eco_card_layout_guanicoe.ecocard_guanicoe_tv_mission_name
import kotlinx.android.synthetic.main.eco_card_layout_harpseal.*
import kotlinx.android.synthetic.main.fragment_add_random_guanicoe.*
import kotlinx.android.synthetic.main.fragment_add_random_guanicoe.random_animal_card_tv_mission_name_guanicoe
import kotlinx.android.synthetic.main.fragment_add_random_harpseal.*
import kotlinx.android.synthetic.main.fragment_add_random_harpseal.view.*
import kotlinx.android.synthetic.main.fragment_add_random_illipika.view.*
import kotlinx.android.synthetic.main.fragment_add_random_illipika.view.random_animal_card_btn_to_select_illipika_card_again
import org.techtown.animore.R
import org.techtown.animore.nework.AddRandomMissionData
import org.techtown.animore.nework.RequestCardInterface
import org.techtown.animore.nework.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddFragementMissionHarpseal : Fragment() {

    val card_category_flag = 2;
    val retrofitClient = RetrofitClient.create(RequestCardInterface::class.java)

    var mission_name = ""
    var mission_content = ""
    var bundle = bundleOf("mission_name" to mission_name, "mission_content" to mission_content)

    fun getRandomMission() {
        retrofitClient.responseRandomMisionData(card_category_flag).enqueue(object :
            Callback<AddRandomMissionData> {
            override fun onFailure(call: Call<AddRandomMissionData>, t: Throwable) {
                if (t.message != null) {
                    Log.d("getRandomMission - Harpseal", t.message!!)

                } else {
                    Log.d("getRandomMission - Harpseal", "통신실패")
                }
            }
            override fun onResponse(
                call: Call<AddRandomMissionData>,
                response: Response<AddRandomMissionData>
            ) {
                if (response.isSuccessful) {
                    if (response.body()!!.success) {
                        Log.d("getRandomMission - Harpseal", "전체 데이터 : ${response.body()!!}")
                        random_animal_card_tv_mission_name_harpseal.setText(response.body()!!.data.mission_name)
                        ecocard_harpseal_tv_mission_name.setText(response.body()!!.data.mission_name)
                        ecocard_harpseal_tv_mission_content.setText(response.body()!!.data.mission_content)

                        mission_name = response.body()!!.data.mission_name
                        mission_content = response.body()!!.data.mission_content
                        bundle = bundleOf("mission_name" to mission_name, "mission_content" to mission_content)

                    } else {
                        Log.d("getRandomMission - Harpseal", "통신실패")
                    }
                } else {
                    Log.d("getRandomMission - Harpseal", "${response.message()}, ${response.errorBody()}")
                }
            }
        })
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_random_harpseal, container, false)

        getRandomMission()  //화면에 들어올 때 실행

        //이후 버튼을 누를 때마다 실행
        view.random_animal_card_btn_to_select_harpseal_card_again.setOnClickListener { view ->
            getRandomMission()
        }

        view.findViewById<Button>(R.id.random_animal_card_btn_to_select_mode_harpseal).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_add_random_harpseal_to_add_choose_normal_harpseal, bundle)
        }

        view.findViewById<ImageButton>(R.id.random_animal_card_back_btn_to_add_frag_harpseal).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_add_random_harpseal_to_add_animal_harpseal)
        }

        return view;
    }
}