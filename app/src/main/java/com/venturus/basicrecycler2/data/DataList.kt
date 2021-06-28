package com.venturus.basicrecycler2.data

import com.google.gson.annotations.SerializedName

data class DataList(
    @SerializedName("drinks")
    val datas: List<DataEntity>
    // variavel para inflar a recycle


)