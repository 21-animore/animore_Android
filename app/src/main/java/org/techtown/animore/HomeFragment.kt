package org.techtown.animore

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_add_random_guanicoe.view.*
import kotlinx.android.synthetic.main.fragment_add_random_guanicoe.view.random_animal_card_btn_to_select_guanicoe_card_again
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import org.techtown.animore.nework.HomecardData
import org.techtown.animore.nework.RequestCardInterface
import org.techtown.animore.nework.HomeRandomTextData
import org.techtown.animore.nework.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {
    val retrofitClient = RetrofitClient.create(RequestCardInterface::class.java)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        view.findViewById<CardView>(R.id.default_card).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_home_fragment_to_add_fragment)
        }

        view.button_normal.setOnClickListener { view ->
            getNormalCard()
        }

        view.button_continous.setOnClickListener { view ->
            getCountinuousCard()
        }

        view.button_all.setOnClickListener { view ->
            getCardSetting()
        }

        return view
    }

    override fun onStart() {
        super.onStart()
        getCardSetting()
        getRandomMainText()
    }

    fun getNormalCard(){
        val user_idx = 1;
        retrofitClient.responseHomecardNormalData(user_idx).enqueue(object :
            Callback<HomecardData> {
            override fun onFailure(call: Call<HomecardData>, t: Throwable) {
                if (t.message != null) {
                    Log.d("Homecard Normal", t.message!!)

                } else {
                    Log.d("Homecard Normal", "통신실패")
                }
            }
            override fun onResponse(
                call: Call<HomecardData>,
                response: Response<HomecardData>
            ) {
                if (response.isSuccessful) {
                    if (response.body()!!.success) {
                        Log.d("Homecard Normal", "전체 데이터 : ${response.body()!!}")

                        val responseData = response.body()!!.data
                        val Adapter = MainCardAdapter()
                        Adapter.datas.addAll(responseData)
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
                        }else if(Adapter.datas.size === 2){
                            //너비 확인 필요
                            var layout = LinearLayout.LayoutParams(1600,LinearLayout.LayoutParams.WRAP_CONTENT)
                            main_card_list.layoutParams = layout
                        }else if(Adapter.datas.size === 1){
                            //너비 확인 필요
                            var layout = LinearLayout.LayoutParams(800,LinearLayout.LayoutParams.WRAP_CONTENT)
                            main_card_list.layoutParams = layout
                        }

                    } else {
                        Log.d("Homecard Normal", "통신실패")
                    }
                } else {
                    Log.d("Homecard Normal", "${response.message()}, ${response.errorBody()}")
                }
            }
        })
    }

    fun getCountinuousCard(){
        val user_idx = 1;
        retrofitClient.responseHomecardContinuousData(user_idx).enqueue(object :
            Callback<HomecardData> {
            override fun onFailure(call: Call<HomecardData>, t: Throwable) {
                if (t.message != null) {
                    Log.d("Homecard Continuous", t.message!!)

                } else {
                    Log.d("Homecard Continuous", "통신실패")
                }
            }
            override fun onResponse(
                call: Call<HomecardData>,
                response: Response<HomecardData>
            ) {
                if (response.isSuccessful) {
                    if (response.body()!!.success) {
                        Log.d("Homecard Continuous", "전체 데이터 : ${response.body()!!}")

                        val responseData = response.body()!!.data
                        val Adapter = MainCardAdapter()
                        Adapter.datas.addAll(responseData)
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

                    } else {
                        Log.d("Homecard Continuous", "통신실패")
                    }
                } else {
                    Log.d("Homecard Continuous", "${response.message()}, ${response.errorBody()}")
                }
            }
        })
    }

    fun getRandomMainText(){
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
    }

    fun getCardSetting(){
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

                        val responseData = response.body()!!.data
                        val Adapter = MainCardAdapter()
                        Adapter.datas.addAll(responseData)
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

        /*
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
         */

        //response 그대로 가져오면 될 것 같은데 다른 함수에 있어서 음 음 음

        //No.notifyDataSetChanged()

    }
}