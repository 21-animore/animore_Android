package org.techtown.animore

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_past.*
import org.techtown.animore.nework.PastcardData
import org.techtown.animore.nework.RequestCardInterface
import org.techtown.animore.nework.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PastFragment : Fragment() {
    val retrofitClient = RetrofitClient.create(RequestCardInterface::class.java)

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_past, container, false)

        return view
    }

    override fun onStart() {
        super.onStart()
        getPastCardSetting()
    }

    fun getPastCardSetting(){
        val user_idx = 1;

        retrofitClient.responsePastcardData(user_idx).enqueue(object :
            Callback<PastcardData> {
            override fun onFailure(call: Call<PastcardData>, t: Throwable) {
                if (t.message != null) {
                    Log.d("Pastcard", t.message!!)

                } else {
                    Log.d("Pastcard", "통신실패")
                }
            }
            override fun onResponse(
                call: Call<PastcardData>,
                response: Response<PastcardData>
            ) {
                if (response.isSuccessful) {
                    if (response.body()!!.success) {
                        Log.d("Pastcard", "전체 데이터 : ${response.body()!!}")

                        val responseData = response.body()!!.data
                        val Adapter = PastCardAdapter()
                        Adapter.datas.addAll(responseData)
                        past_card_list.adapter = Adapter

                    } else {
                        Log.d("Pastcard", "통신실패")
                    }
                } else {
                    Log.d("Pastcard", "${response.message()}, ${response.errorBody()}")
                }
            }
        })
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}