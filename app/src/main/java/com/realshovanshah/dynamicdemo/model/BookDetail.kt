package com.realshovanshah.dynamicdemo.model

import com.google.gson.annotations.SerializedName

class BookDetail(@SerializedName("Name") var name: String, @SerializedName("Id") var id: String) {

}