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
import kotlinx.android.synthetic.main.eco_card_layout_illipika.*
import kotlinx.android.synthetic.main.fragment_add_random_guanicoe.*
import kotlinx.android.synthetic.main.fragment_add_random_illipika.*
import kotlinx.android.synthetic.main.fragment_add_random_illipika.view.*
import kotlinx.android.synthetic.main.fragment_add_random_java.view.*
import kotlinx.android.synthetic.main.fragment_add_random_java.view.random_animal_card_btn_to_select_java_card_again
import org.techtown.animore.R
import org.techtown.animore.nework.AddRandomMissionData
import org.techtown.animore.nework.RequestCardInterface
import org.techtown.animore.nework.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddFragementMissionIllipika : Fragment() {

    val card_category_flag = 1;
    val retrofitClient = RetrofitClient.create(RequestCardInterface::class.java)

    var mission_name = ""
    var mission_content = ""
    var bundle = bundleOf("mission_name" to mission_name, "mission_content" to mission_content)

    fun getRandomMission() {
        retrofitClient.responseRandomMisionData(card_category_flag).enqueue(object :
            Callback<AddRandomMissionData> {
            override fun onFailure(call: Call<AddRandomMissionData>, t: Throwable) {
                if (t.message != null) {
                    Log.d("getRandomMission - Illipika", t.message!!)

                } else {
                    Log.d("getRandomMission - Illipika", "통신실패")
                }
            }
            override fun onResponse(
                call: Call<AddRandomMissionData>,
                response: Response<AddRandomMissionData>
            ) {
                if (response.isSuccessful) {
                    if (response.body()!!.success) {
                        Log.d("getRandomMission - Illipika", "전체 데이터 : ${response.body()!!}")
                        random_animal_card_tv_mission_name_illipika.setText(response.body()!!.data.mission_name)
                        ecocard_illipika_tv_mission_name.setText(response.body()!!.data.mission_name)
                        ecocard_illipika_tv_mission_content.setText(response.body()!!.data.mission_content)

                        mission_name = response.body()!!.data.mission_name
                        mission_content = response.body()!!.data.mission_content
                        bundle = bundleOf("mission_name" to mission_name, "mission_content" to mission_content)

                    } else {
                        Log.d("getRandomMission - Illipika", "통신실패")
                    }
                } else {
                    Log.d("getRandomMission - Illipika", "${response.message()}, ${response.errorBody()}")
                }
            }
        })
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_random_illipika, container, false)

        getRandomMission()  //화면에 들어올 때 실행

        //이후 버튼을 누를 때마다 실행
        view.random_animal_card_btn_to_select_illipika_card_again.setOnClickListener { view ->
            getRandomMission()
        }

        view.findViewById<Button>(R.id.random_animal_card_btn_to_select_mode_illipika).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_add_random_illipika_to_add_choose_normal_illipika, bundle)
        }

        view.findViewById<ImageButton>(R.id.random_animal_card_back_btn_to_add_frag_illipika).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_add_random_illipika_to_add_animal_illipika)
        }

        return view;
    }
}