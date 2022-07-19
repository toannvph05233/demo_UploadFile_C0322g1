package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements CRUD<Product> {
    private List<Product> products;

    @Autowired
    CategoryService categoryService;

    public ProductService() {
        products = new ArrayList<>();
        }


    @Override
    public void create(Product product) {
        products.add(product);
    }

    @Override
    public void edit(Product product, int index) {
        products.set(index, product);
    }

    @Override
    public void delete(int index) {
        products.remove(index);
    }

    @Override
    public List<Product> getAll() {
        products.add(new Product(1, 500, "Hoàng", "https://kenh14cdn.com/thumb_w/660/2020/7/17/brvn-15950048783381206275371.jpg", false, categoryService.getAll().get(0)));
        products.add(new Product(2, 1000, "Thế", "https://danviet.mediacdn.vn/296231569849192448/2021/11/13/2-16367909122982007907284.jpg", true, categoryService.getAll().get(1)));
        return products;
    }
}
