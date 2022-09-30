package com.example.data.util

import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

object Constants {

    const val BASE_URL = "https://gateway.marvel.com"
    const val API_KEY = "32188d9ca179a43a1562e71f116b90da"
    const val PRIVATE_KEY = "e4c5417152dc349547daca11edde46d5bb0e047f"
    val COMICS_URL = "/v1/public/comics"


    val TIME_STAMP = Timestamp(System.currentTimeMillis()).time.toString()


    fun hashGen():String {
        val input = "$TIME_STAMP$PRIVATE_KEY$API_KEY"
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1,md.digest(input.toByteArray())).toString(16).padStart(32,'0')
    }

    fun getURl(endpoint:String):String{
        return "$BASE_URL$endpoint"
    }

}