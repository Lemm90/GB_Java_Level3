package ru.khorolskii.lesson_2;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class ProductRepository {
    private List<Product> list;

    public List<Product> getList() {
        return list;
    }

    @PostConstruct
    private void addProduct() {
        list = new ArrayList<>(Arrays.asList(
                new Product(1, "Milk", 70),
                new Product(2, "cherry", 120),
                new Product(3, "potato", 30),
                new Product(4, "Apples", 45),
                new Product(5, "tomato", 60)
        ));
    }

    public Product getProduct(int id) {
        return list.stream().filter(l -> l.getId() == id).findFirst().orElseThrow(() -> new RuntimeException());
    }

    public ArrayList getAllProduct() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(list.get(i).getName());
        }
        return arrayList;
    }
}


