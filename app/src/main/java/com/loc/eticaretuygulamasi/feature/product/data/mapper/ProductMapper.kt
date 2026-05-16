package com.loc.eticaretuygulamasi.feature.product.data.mapper

import com.loc.eticaretuygulamasi.feature.product.data.remote.dto.ProductDto
import com.loc.eticaretuygulamasi.feature.product.domain.model.Product


fun ProductDto.toDomain(): Product {

    return Product(
        id = id,
        title = title,
        price = price,
        description = description,
        category = category,
        image = image,
        rating = rating.rate
    )
}