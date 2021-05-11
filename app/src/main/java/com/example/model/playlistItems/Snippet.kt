package com.example.example

import com.google.gson.annotations.SerializedName

   
data class Snippet (

   @SerializedName("publishedAt") var publishedAt : String,
   @SerializedName("channelId") var channelId : String,
   @SerializedName("title") var title : String,
   @SerializedName("description") var description : String,
   @SerializedName("thumbnails") var thumbnails : Thumbnails,
   @SerializedName("channelTitle") var channelTitle : String,
   @SerializedName("playlistId") var playlistId : String,
   @SerializedName("position") var position : Int,
   @SerializedName("resourceId") var resourceId : ResourceId,
   @SerializedName("videoOwnerChannelTitle") var videoOwnerChannelTitle : String,
   @SerializedName("videoOwnerChannelId") var videoOwnerChannelId : String

)