package com.peakfinn.madlevel6task1

/**
 * Created by Finn Bon on 13/12/2020.
 */
class ColorRepository {
    fun getColorItems(): List<ColorItem> {
        return arrayListOf(
            ColorItem("000000", "Black"),
            ColorItem("FF0000", "Red"),
            ColorItem("0000FF", "Blue"),
            ColorItem("FFFF00", "Yellow"),
            ColorItem("008000", "Green")
        )
    }
}