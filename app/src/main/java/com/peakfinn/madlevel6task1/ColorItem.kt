package com.peakfinn.madlevel6task1

/**
 * Created by Finn Bon on 13/12/2020.
 */
data class ColorItem(
    var hex: String,
    var name: String
) {
    fun getImageUrl() = "http://singlecolorimage.com/get/$hex/1080x1080"
}