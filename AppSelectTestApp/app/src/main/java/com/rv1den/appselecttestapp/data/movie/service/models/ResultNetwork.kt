package com.rv1den.appselecttestapp.data.movie.service.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResultNetwork(
    @SerialName("display_title")
    val displayTitle: String,
    @SerialName("multimedia")
    val multimedia: MultimediaNetwork,
    @SerialName("summary_short")
    val summaryShort: String
)