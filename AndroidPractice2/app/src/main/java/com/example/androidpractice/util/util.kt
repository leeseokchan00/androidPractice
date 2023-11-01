package com.example.androidpractice.util

import android.content.Intent
import android.os.Build.VERSION.SDK_INT
import android.os.Build.VERSION_CODES.TIRAMISU
import android.os.Parcelable

fun <T : Parcelable> Intent.getParcelable(key: String, c: Class<T>): T? = when {
    SDK_INT >= TIRAMISU -> getParcelableExtra(key, c)
    else -> getParcelableExtra(key) as? T
}
// getParcelable 함수 버전 나눠줘야됨