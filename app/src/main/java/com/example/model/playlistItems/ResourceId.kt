package com.example.example

import com.google.gson.annotations.SerializedName

   
data class ResourceId (

   @SerializedName("kind") var kind : String,
   @SerializedName("videoId") var videoId : String

)