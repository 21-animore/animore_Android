package org.techtown.animore.nework

import retrofit2.Call
import retrofit2.http.*

interface RequestCardInterface {

    //메인 뷰 접속시마다 - 카드 전체 출력
    @GET("/card/getallcards/{user_idx}")
    fun responseHomecardData(
        @Path("user_idx") user_idx : Int) : Call<HomecardData>

    //버튼 클릭 시마다 - 일반 카드 전체 출력
    @GET("/card/getcontinuouscards/{user_idx}")
    fun responseHomecardContinuousData(
        @Path("user_idx") user_idx : Int) : Call<HomecardData>

    //버튼 클릭 시마다 - 연속 카드 전체 출력
    @GET("/card/getnormalcards/{user_idx}")
    fun responseHomecardNormalData(
        @Path("user_idx") user_idx : Int) : Call<HomecardData>

    //과거 뷰 접속시마다 - 카드 전체 출력
    @GET("/card/getallpastcards/{user_idx}")
    fun responsePastcardData(
        @Path("user_idx") user_idx : Int) : Call<PastcardData>

    //과거 뷰 접속시마다 - 성공 카드 수 출력
    @GET("/card/getallpastcards/count/{user_idx}")
    fun responsePastcardcountData(
        @Path("user_idx") user_idx : Int) : Call<PastSuccessCardCount>

    //미션 받기 버튼 클릭 시마다 - 새로운 랜덤 미션 출력
    @GET("/card/showrandomcard/{card_category_flag}")
    fun responseRandomMisionData(
        @Path("card_category_flag") card_category_flag : Int) : Call<AddRandomMissionData>

    //메인 뷰 접속시마다 - 상단에 랜덤 메세지 출력
    @GET("/card/getrandomsentence")
    fun responseRandomMainTextData() : Call<HomeRandomTextData>

    @FormUrlEncoded
    @POST("/card/start")
    fun postProductRequest(
        @Field("user_idx") user_idx: Int,
        @Field("mission_name") mission_name: String,
        @Field("mission_category") mission_category: Int,
        @Field("mission_period") mission_period: Int,
        @Field("mission_start_date") mission_start_date: String,
        @Field("mission_end_date") mission_end_date: String,
        @Field("mission_content") mission_content: String,
        @Field("continue_flag") continue_flag: Int
    ): Call<AddNewCardData>

    @FormUrlEncoded
    @PUT("/card/addachievecount")
    fun addCountRequest(
        @Field("user_idx") user_idx: Int,
        @Field("mission_name") mission_name: String,
        @Field("mission_period") mission_period: Int,
        @Field("click_date") click_date: String
    ): Call<RandomCheerupData>

    @FormUrlEncoded
    @POST("/card/giveup")
    fun deleteCardRequest(
        @Field("user_idx") user_idx: Int,
        @Field("mission_name") mission_name: String
    ): Call<SimpleDataResponse>

}