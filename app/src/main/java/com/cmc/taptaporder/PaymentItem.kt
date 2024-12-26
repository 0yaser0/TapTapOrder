package com.cmc.taptaporder

import android.os.Parcel
import android.os.Parcelable

data class PaymentItem(
    val id: Long,
    val title: String,
    val description: String,
    val imageRes: Int,
    val price: Double,
    var quantity: Int
) :
    Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt().toLong(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readInt(),
        parcel.readInt().toDouble(),
        parcel.readInt()
    ) {
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        TODO("Not yet implemented")
    }

    companion object CREATOR : Parcelable.Creator<PaymentItem> {
        override fun createFromParcel(parcel: Parcel): PaymentItem {
            return PaymentItem(parcel)
        }

        override fun newArray(size: Int): Array<PaymentItem?> {
            return arrayOfNulls(size)
        }
    }
}
