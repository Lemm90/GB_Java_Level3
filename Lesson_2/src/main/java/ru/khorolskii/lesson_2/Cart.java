package ru.khorolskii.lesson_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope ("prototype")
public class Cart {
    private ProductRepository productRepository;
    private List<Product> cartList = new ArrayList();;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProductToCart(int id){
        cartList.add(productRepository.getProduct(id));
    }

    public void deleteProductToCart(int id){
        cartList.remove(productRepository.getProduct(id));
    }

    public ArrayList showCart() {
        ArrayList list = new ArrayList();
        for (int i = 0; i < cartList.size(); i++) {
            list.add(cartList.get(i).getName());
        }
        return list;
    }
}
