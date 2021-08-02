package com.example.xmlex.service;


import com.example.xmlex.model.dto.ProductSeedDto;
import com.example.xmlex.model.dto.ProductViewRootDto;
import com.example.xmlex.model.entity.Product;

import java.util.List;

public interface ProductService {
    long getCount();

    void seedProducts(List<ProductSeedDto> products);

    ProductViewRootDto findProductsInRangeWithoutBuyer();


}
