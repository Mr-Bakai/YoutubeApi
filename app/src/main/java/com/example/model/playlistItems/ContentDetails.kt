package com.example.example

import com.google.gson.annotations.SerializedName

   
data class ContentDetails (

   @SerializedName("videoId") var videoId : String,
   @SerializedName("videoPublishedAt") var videoPublishedAt : String

)