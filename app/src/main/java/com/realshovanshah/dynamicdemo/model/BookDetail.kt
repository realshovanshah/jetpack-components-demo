package com.realshovanshah.dynamicdemo.model

import com.google.gson.annotations.SerializedName

class BookDetail {
    @SerializedName("Name")
    lateinit var name: String

    @SerializedName("Id")
    lateinit var id: String

    override fun toString(): String {
        return "Book Details are name:$name, id:$id,"
    }

}