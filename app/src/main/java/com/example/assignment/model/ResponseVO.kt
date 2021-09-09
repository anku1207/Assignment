package com.example.assignment.model

import com.google.gson.annotations.SerializedName

data class ResponseVO(
    @field:SerializedName("data")
    val data: List<GalleryVO>? = null,

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("status")
    val status: String? = null,

    @field:SerializedName("code")
    val code: Int? = null
)

data class GalleryVO(
    @field:SerializedName("GALLERY")
    val GALLERY: List<GalleryDataVO>? = null,
)

data class GalleryDataVO(
    @field:SerializedName("filename")
    val filename: String,


)
