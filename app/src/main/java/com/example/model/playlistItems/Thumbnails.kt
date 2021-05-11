package com.example.example

import com.google.gson.annotations.SerializedName

   
data class Thumbnails (

   @SerializedName("default") var default : Default,
   @SerializedName("medium") var medium : Medium,
   @SerializedName("high") var high : High,
   @SerializedName("standard") var standard : Standard,
   @SerializedName("maxres") var maxres : Maxres

)