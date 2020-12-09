package org.techtown.animore

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home_card_more.*
import kotlinx.android.synthetic.main.fragment_home_card_more.view.*
import org.techtown.animore.nework.HomeRandomTextData
import org.techtown.animore.nework.RequestCardInterface
import org.techtown.animore.nework.RetrofitClient
import org.techtown.animore.nework.SimpleDataResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeMoreFragment : Fragment() {

    val retrofitClient = RetrofitClient.create(RequestCardInterface::class.java)

    val user_idx = 1
    var bundle_mission_name = ""
    var bundle_mission_category = ""
    var bundle_continue_flag = ""
    var bundle_mission_acheive_count = ""
    var bundle_mission_period = ""
    var bundle_mission_start_date = ""
    var bundle_mission_end_date = ""
    var bundle_mission_content = ""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home_card_more, container, false)


        /*--------------------------------받아온 하나의 정보로 카드 1개 그림--------------------------------*/
        bundle_mission_name = arguments?.getString("bundle_mission_name").toString()
        bundle_mission_category = arguments?.getString("bundle_mission_category").toString()
        bundle_continue_flag = arguments?.getString("bundle_continue_flag").toString()
        bundle_mission_acheive_count = arguments?.getString("bundle_mission_acheive_count").toString()
        bundle_mission_period = arguments?.getString("bundle_mission_period").toString()
        bundle_mission_start_date = arguments?.getString("bundle_mission_start_date").toString()
        bundle_mission_end_date = arguments?.getString("bundle_mission_end_date").toString()
        bundle_mission_content = arguments?.getString("bundle_mission_content").toString()
        /*-----------------------------------------------------------------------------------------------*/


        view.home_more_card_btn_giveup.setOnClickListener { view ->
            home_more_card_btn_cancle.visibility = View.VISIBLE;
            home_more_card_btn_reallygiveup.visibility = View.VISIBLE;
            home_more_card_tv_reallydelete.visibility = View.VISIBLE;
            home_more_card_reallydelete.visibility = View.VISIBLE;
        }

        view.home_more_card_btn_cancle.setOnClickListener { view ->
            home_more_card_tv_deletefin.visibility = GONE;
            home_more_card_btn_cancle.visibility = GONE;
            home_more_card_btn_reallygiveup.visibility = GONE;
            home_more_card_tv_reallydelete.visibility = GONE;
            home_more_card_reallydelete.visibility = GONE;
        }

        view.home_more_card_btn_reallygiveup.setOnClickListener { view ->
            home_more_card_tv_deletefin.visibility = View.VISIBLE;
            home_more_card_btn_cancle.visibility = GONE;
            home_more_card_btn_reallygiveup.visibility = GONE;
            home_more_card_tv_reallydelete.visibility = GONE;
            home_more_card_reallydelete.visibility = View.VISIBLE;

            deleteCard()
            //3초 후에 메인 뷰로 돌아가게 하고 싶은데 그건 어떻게 해결할까??
        }
        return view;
    }

    fun deleteCard() {
        retrofitClient.deleteCardRequest(user_idx, bundle_mission_name).enqueue(object :
            Callback<SimpleDataResponse> {
            override fun onFailure(call: Call<SimpleDataResponse>, t: Throwable) {
                if (t.message != null) {
                    Log.d("delete Card", t.message!!)

                } else {
                    Log.d("delete Card", "통신실패")
                }
            }
            override fun onResponse(
                call: Call<SimpleDataResponse>,
                response: Response<SimpleDataResponse>
            ) {
                Log.d("들어왔니..?", ""+user_idx+bundle_mission_name)
                if (response.isSuccessful) {
                    if (response.body()!!.success) {
                        Log.d("delete Card", "전체 데이터 : ${response.body()!!}")
                    } else {
                        Log.d("delete Card", "통신실패")
                    }
                } else {
                    Log.d("delete Card", "${response.message()}, ${response.errorBody()}")
                }
            }
        })
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*처음에 안 보여야 하는 부분들*/
        home_more_card_tv_deletefin.visibility = GONE;
        home_more_card_btn_cancle.visibility = GONE;
        home_more_card_btn_reallygiveup.visibility = GONE;
        home_more_card_tv_reallydelete.visibility = GONE;
        home_more_card_reallydelete.visibility = GONE;


        var card = HomeMoreCardData(
                index = bundle_mission_category.toInt(),
                flag = bundle_continue_flag.toInt(),
                dayDuring = bundle_mission_period.toInt(),
                start_date = bundle_mission_start_date,
                end_date = bundle_mission_end_date,
                count = bundle_mission_acheive_count.toInt(),
                mission_name = bundle_mission_name,
                mission_expression = bundle_mission_content)
        val Adapter = HomeMoreCardAdapter(requireContext())
        Adapter.homemoreitems.add(card)

        /*---------------------------------------------------이것저것 적용중------------------------------------------------*/
        var HorizontalLayout2 = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL,false)
        home_more_card.layoutManager = HorizontalLayout2

        home_more_card.adapter = Adapter
        Adapter.notifyDataSetChanged()


        /*---------------------------------------------------상단바 커스텀------------------------------------------------*/
        home_more_card_tv_mission_name.text = bundle_mission_name;

        if(Adapter.homemoreitems[0].index === 0){
            home_more_card_topbar.setImageResource(R.drawable.ic_top_bar_guanicoe)
            home_more_card_tv_mission_name.setTextColor(ContextCompat.getColor(requireActivity(), R.color.stroke_guanicoe))
            home_more_card_back_btn_to_add_frag.setImageResource(R.drawable.ic_back_btn_guanicoe)
        }else if(Adapter.homemoreitems[0].index === 1){
            home_more_card_topbar.setImageResource(R.drawable.ic_top_bar_illipika)
            home_more_card_tv_mission_name.setTextColor(ContextCompat.getColor(requireActivity(), R.color.stroke_illipika))
            home_more_card_back_btn_to_add_frag.setImageResource(R.drawable.ic_back_btn_illipika)
        }else if(Adapter.homemoreitems[0].index === 2){
            home_more_card_topbar.setImageResource(R.drawable.ic_top_bar_harpseal)
            home_more_card_tv_mission_name.setTextColor(ContextCompat.getColor(requireActivity(), R.color.stroke_harpseal))
            home_more_card_back_btn_to_add_frag.setImageResource(R.drawable.ic_back_btn_harpseal)
        }else if(Adapter.homemoreitems[0].index === 3){
            home_more_card_topbar.setImageResource(R.drawable.ic_top_bar_javahornhawk)
            home_more_card_tv_mission_name.setTextColor(ContextCompat.getColor(requireActivity(), R.color.stroke_java))
            home_more_card_back_btn_to_add_frag.setImageResource(R.drawable.ic_back_btn_java)
        }else{
            home_more_card_topbar.setImageResource(R.drawable.ic_top_bar_bengaltiger)
            home_more_card_tv_mission_name.setTextColor(ContextCompat.getColor(requireActivity(), R.color.stroke_bengaltiger))
            home_more_card_back_btn_to_add_frag.setImageResource(R.drawable.ic_back_btn_bengal)
        }

    }
}