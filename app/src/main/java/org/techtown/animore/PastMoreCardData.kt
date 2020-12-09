package org.techtown.animore

data class PastMoreCardData(
        //유형 파악용
        val index: Int,

        //캘린더 or 일반 파악용
        val flag: Boolean,

        //연속일 경우 캘린더 기간 파악 용
        val dayDuring: Int,

        //시작날짜 끝날짜
        val start_date: String,
        val end_date: String,

        //몇번수행했는가
        val count: Int,

        //미션이름
        val mission_name : String,

        //미션 부가 설명
        val mission_expression : String,

        //성공 여부
        val success_flag : Boolean
)