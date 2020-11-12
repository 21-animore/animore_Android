package org.techtown.animore

import java.util.*

data class PastCardData(
    val card_success_flag : Int,
    val card_name : String,
    val achieve_count : Int,
    val total_count : Int,
    val start_date : Date,
    val end_date : Date,
    val card_category : Int
)