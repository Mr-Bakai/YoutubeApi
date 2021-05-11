package com.example.example

import com.google.gson.annotations.SerializedName

   
data class Default (

   @SerializedName("url") var url : String,
   @SerializedName("width") var width : Int,
   @SerializedName("height") var height : Int

)