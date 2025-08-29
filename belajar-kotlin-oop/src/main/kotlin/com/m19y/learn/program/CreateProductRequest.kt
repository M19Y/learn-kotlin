package com.m19y.learn.program

import com.m19y.learn.annotations.NotBlank

data class CreateProductRequest(
    @NotBlank val id: String,
    @NotBlank val name: String,
    @NotBlank val price: Int
) {
}

data class CreateCategoryRequest(
    @NotBlank val id: String,
    @NotBlank val name: String,
)