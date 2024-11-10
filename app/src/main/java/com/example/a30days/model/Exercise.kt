package com.example.a30days.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Exercise(
    @StringRes val name: Int,
    @DrawableRes val imgUrl: Int,
    @StringRes val description: Int
)
