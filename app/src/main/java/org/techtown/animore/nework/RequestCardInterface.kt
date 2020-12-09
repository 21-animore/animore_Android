package org.techtown.animore.nework

import retrofit2.Call
import retrofit2.http.*

interface RequestCardInterface {

    //메인 뷰 접속시마다 - 카드 전체 출력
    @GET("/card/getallcards/{user_idx}")
    fun responseHomecardData(
        @Path("user_idx") user_idx : Int) : Call<HomecardData>

    //과거 뷰 접속시마다 - 카드 전체 출력
    @GET("/card/getallpastcards/{user_idx}")
    fun responsePastcardData(
        @Path("user_idx") user_idx : Int) : Call<ArrayList<HomeRandomTextData>>

    //미션 받기 버튼 클릭 시마다 - 새로운 랜덤 미션 출력
    @GET("/card/showrandomcard/{card_category_flag}")
    fun responseRandomMisionData(
        @Path("card_category_flag") card_category_flag : Int) : Call<AddRandomMissionData>

    //메인 뷰 접속시마다 - 상단에 랜덤 메세지 출력
    @GET("/card/getrandomsentence")
    fun responseRandomMainTextData() : Call<HomeRandomTextData>

    /*
    //count 버튼 누를> +1
    @PUT("/card/addachievecount")
    fun unScrapCard(
        @Body cardMemoModel: CardMemoModel) : Call<SimpleResponse>

    //새로운 카드 추가
    @POST("/card/memo createMemo(
        @Body cardMemoModel: CardMemoModel) : Call<SimpleResponse>

    //도전 중인 카드 삭제
    @PUT("/card/card/missionfail")
    fun unScrapCard(
        @Body cardMemoModel: CardMemoModel) : Call<SimpleResponse>
    */

}