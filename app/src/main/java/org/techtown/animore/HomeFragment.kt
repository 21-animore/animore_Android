package org.techtown.animore

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.fragment_home.*
import org.techtown.animore.nework.HomecardData
import org.techtown.animore.nework.RequestCardInterface
import org.techtown.animore.nework.HomeRandomTextData
import org.techtown.animore.nework.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    var bundle_mission_name = ""
    var bundle_index = ""
    var bundle_count = ""
    var bundle_total_count = ""
    var bundle_start_date = ""
    var bundle_end_date = ""
    var bundle_mission_expression = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        return view
    }

    override fun onStart() {
        super.onStart()

        val retrofitClient = RetrofitClient.create(RequestCardInterface::class.java)

        retrofitClient.responseRandomMainTextData().enqueue(object :
            Callback<HomeRandomTextData> {
            override fun onFailure(call: Call<HomeRandomTextData>, t: Throwable) {
                if (t.message != null) {
                    Log.d("Main Random Text", t.message!!)

                } else {
                    Log.d("Main Random Text", "통신실패")
                }
            }
            override fun onResponse(
                call: Call<HomeRandomTextData>,
                response: Response<HomeRandomTextData>
            ) {
                if (response.isSuccessful) {
                    if (response.body()!!.success) {
                        Log.d("Main Random Text", "전체 데이터 : ${response.body()!!}")
                        home_randomText.setText(response.body()!!.data)

                    } else {
                        Log.d("Main Random Text", "통신실패")
                    }
                } else {
                    Log.d("Main Random Text", "${response.message()}, ${response.errorBody()}")
                }
            }
        })

        val user_idx = 1;
        retrofitClient.responseHomecardData(user_idx).enqueue(object :
            Callback<HomecardData> {
            override fun onFailure(call: Call<HomecardData>, t: Throwable) {
                if (t.message != null) {
                    Log.d("Homecard", t.message!!)

                } else {
                    Log.d("Homecard", "통신실패")
                }
            }
            override fun onResponse(
                call: Call<HomecardData>,
                response: Response<HomecardData>
            ) {
                if (response.isSuccessful) {
                    if (response.body()!!.success) {
                        Log.d("Homecard", "전체 데이터 : ${response.body()!!}")

                    } else {
                        Log.d("Homecard", "통신실패")
                    }
                } else {
                    Log.d("Homecard", "${response.message()}, ${response.errorBody()}")
                }
            }
        })
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var maincard1 = MainCardData(0, true, 7, "2020-11-23", "2020-12-24", 5, "미션이름입니다", "")
        var maincard2 = MainCardData(1, true, 14, "2020-11-25", "2020-12-24", 2, "미션이름입니다", "")
        var maincard3 = MainCardData(2, true, 14, "2020-11-26", "2020-12-24", 13, "미션이름입니다", "")
        var maincard4 = MainCardData(3, true, 21, "2020-11-27", "2020-12-24", 14, "미션이름입니다", "")
        var maincard5 = MainCardData(4, true, 21, "2020-11-28", "2020-12-24", 10, "미션이름입니다", "")

        val Adapter = MainCardAdapter()
        Adapter.datas.add(maincard1)
        Adapter.datas.add(maincard2)
        Adapter.datas.add(maincard3)
        Adapter.datas.add(maincard4)
        Adapter.datas.add(maincard5)
        main_card_list.adapter = Adapter

        //MyData에 넘겨 받은 카드 개수에 맞춰 width 조절
        if(Adapter.datas.size === 3){
            var layout = LinearLayout.LayoutParams(2787,LinearLayout.LayoutParams.WRAP_CONTENT)
            main_card_list.layoutParams = layout
        }else if(Adapter.datas.size === 4){
            var layout = LinearLayout.LayoutParams(3715,LinearLayout.LayoutParams.WRAP_CONTENT)
            main_card_list.layoutParams = layout
        }else if(Adapter.datas.size === 5){
            //카드가 5개일 경우 디폴트 카드 삭제
            default_card.visibility = View.GONE;
            var layout = LinearLayout.LayoutParams(4645,LinearLayout.LayoutParams.WRAP_CONTENT)
            main_card_list.layoutParams = layout
        }
        //No.notifyDataSetChanged()

    }
}