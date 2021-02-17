package com.realshovanshah.dynamicdemo.model

import com.google.gson.annotations.SerializedName

class TeacherDetail {
    @SerializedName("Name")
    lateinit var name: String

    @SerializedName("Address")
    lateinit var address: String

    @SerializedName("EmailId")
    lateinit var email: String

    @SerializedName("DateOfBirthAD")
    lateinit var dob: String

    override fun toString(): String{
        return "Name: $name, Email: $email, Address: $address "
    }

}