package com.example.practise2.dao;

import com.example.practise2.Dao;
import com.example.practise2.model.ProductModel;
import com.example.practise2.model.UserModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDao implements Dao<ProductModel> {
    private static int PRODUCT_COUNT;
    private List<ProductModel> products = new ArrayList<>();
    @Override
    public ProductModel show(int id) {
        return products.stream().filter(productModel -> productModel.getId() == id).findAny().orElse(null);
    }

    @Override
    public List<ProductModel> index() {
        return products;
    }

    @Override
    public void save(ProductModel productModel) {
        productModel.setId(++PRODUCT_COUNT);
        products.add(productModel);
    }

    @Override
    public void update(ProductModel productModel, int id) {
        ProductModel updatedProduct = show(id);
        updatedProduct.setName(productModel.getName());
        updatedProduct.setDescription(productModel.getDescription());
        updatedProduct.setPrice(productModel.getPrice());
    }

    @Override
    public void delete(int id) {
        products.removeIf(p -> p.getId() == id);
    }
}
