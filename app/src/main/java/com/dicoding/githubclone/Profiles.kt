package com.dicoding.githubclone

import android.os.Parcel
import android.os.Parcelable

data class Profiles(
    var fullName: String?= "",
    var username: String?= "",
    var bio: String?= "",
    var profilePicture: Int?= 0
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readInt()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(fullName)
        parcel.writeString(username)
        parcel.writeString(bio)
        parcel.writeValue(profilePicture)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Profiles> {
        override fun createFromParcel(parcel: Parcel): Profiles {
            return Profiles(parcel)
        }

        override fun newArray(size: Int): Array<Profiles?> {
            return arrayOfNulls(size)
        }
    }
}