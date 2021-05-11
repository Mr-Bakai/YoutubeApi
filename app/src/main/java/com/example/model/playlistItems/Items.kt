package com.example.model.playlistItems

import com.example.example.ContentDetails
import com.example.example.Snippet
import com.google.gson.annotations.SerializedName

   
data class Items (

   @SerializedName("kind") var kind : String,
   @SerializedName("etag") var etag : String,
   @SerializedName("id") var id : String,
   @SerializedName("snippet") var snippet : Snippet,
   @SerializedName("contentDetails") var contentDetails : ContentDetails

)