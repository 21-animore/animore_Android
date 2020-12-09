package org.techtown.animore.nework

data class HomecardData (
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: List<HomecardDataList>
)

data class HomecardDataList(
    val card_idx : Int,
    val user_idx : Int,
    val now_flag : Int,
    val mission_name : String,
    val mission_category : Int,
    val mission_period : Int,
    val mission_start_date : String,
    val mission_end_date : String,
    val mission_acheieve_count : Int,
    val mission_content : String,
    val success_flag : Int,
    val continue_flag : Int
)
