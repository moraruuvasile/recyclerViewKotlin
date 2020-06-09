package com.example.recyclerviewkotlin

import android.os.Parcel
import android.os.Parcelable

data class ExampleItem(val imageResource: Int, val text1: String, val text2: String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(imageResource)
        parcel.writeString(text1)
        parcel.writeString(text2)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ExampleItem> {
        override fun createFromParcel(parcel: Parcel): ExampleItem {
            return ExampleItem(parcel)
        }

        override fun newArray(size: Int): Array<ExampleItem?> {
            return arrayOfNulls(size)
        }
    }
}