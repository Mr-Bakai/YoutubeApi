package com.example.model.playlistItems

import com.example.example.PageInfo
import com.google.gson.annotations.SerializedName

data class PlayListItems (

   @SerializedName("kind") var kind : String,
   @SerializedName("etag") var etag : String,
   @SerializedName("items") var items : List<Items>,
   @SerializedName("pageInfo") var pageInfo : PageInfo

)

