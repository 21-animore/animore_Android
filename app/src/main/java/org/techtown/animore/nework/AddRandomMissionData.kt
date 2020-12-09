package org.techtown.animore.nework

data class AddRandomMissionData(
    val status : Int,
    val success : Boolean,
    val message : String,
    val data :RandomMissionData
)

data class RandomMissionData (
    val mission_name : String,
    val mission_content : String
)
