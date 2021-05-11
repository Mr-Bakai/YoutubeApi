package com.example.example

import com.google.gson.annotations.SerializedName

   
data class PageInfo (

   @SerializedName("totalResults") var totalResults : Int,
   @SerializedName("resultsPerPage") var resultsPerPage : Int

)