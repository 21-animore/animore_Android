package org.techtown.animore

import java.util.*

class MainCardData (
    //유형 파악용
    val index: Int,

    //캘린더 or 일반 파악용
    val flag: Boolean,

    //연속일 경우 캘린더 기간 파악 용
    val dayDuring: Int,

    //이외 서버로부터 받아야 하는 정보들
    //시작날짜 끝날짜
    //몇번수행했는가
    //미션이름
    val mission_name : String,
)