package org.techtown.animore

class MainCardData (
        //유형 파악용
        val mission_category: Int,

        //캘린더 or 일반 파악용
        val continue_flag: Int,

        //연속일 경우 캘린더 기간 파악 용
        val mission_period: Int,

        //시작날짜 끝날짜
        val mission_start_date: String,
        val mission_end_date: String,

        //몇번수행했는가
        val mission_acheieve_count: Int,

        //미션이름
        val mission_name : String,

        //미션 부가 설명
        val mission_expression : String
)