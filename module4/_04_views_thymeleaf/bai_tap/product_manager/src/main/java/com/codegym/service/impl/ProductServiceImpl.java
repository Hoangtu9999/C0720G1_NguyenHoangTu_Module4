package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class ProductServiceImpl implements ProductService {
        private static Map<Integer, Product> productMap ;

        static {
            productMap = new TreeMap<>();
            productMap.put(1,new Product(1,"Tivi","Do dien tu",2000));
            productMap.put(2,new Product(2,"Tivi 1","Do dien tu",3000));
            productMap.put(3,new Product(3,"Tivi 2","Do dien tu",4000));
            productMap.put(4,new Product(4,"Tivi 3","Do dien tu",5000));
            productMap.put(5,new Product(5,"Tivi 3","Do dien tu",6000));
        }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void create(Product product) {
        product.setId((int) (Math.random() * 100));
        productMap.put(product.getId(),product);
    }

    @Override
    public Product findById(Integer id) {
        return productMap.get(id);
    }

    @Override
    public void edit(Integer id, Product product) {
        productMap.put(id,product);
    }

    @Override
    public void delete(Integer id) {
        productMap.remove(id);
    }
}
