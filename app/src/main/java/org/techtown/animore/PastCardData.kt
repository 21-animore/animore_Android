package org.techtown.animore

data class PastCardData(
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