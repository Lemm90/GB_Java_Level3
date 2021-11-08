package ru.khorolskii.lesson_2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("ru.khorolskii.lesson_2");
        ProductRepository productRepository = context.getBean(ProductRepository.class);
        Cart cart = context.getBean(Cart.class);
        Scanner scanner = new Scanner(System.in);
        boolean end = false;
        System.out.println("Добрый день.");
        System.out.println("Что бы посмотреть весь список товаров в магазине введите '0'");

        int commandShowAll = scanner.nextInt();
        if (commandShowAll == 0) {
            System.out.println("Список товаров: " + productRepository.getAllProduct());
            System.out.println("Что бы добавить товар в корзину введите его номер");
            System.out.println("Что бы убрать товар из корзины введите его номер со знаком минус");
        } else System.out.println("Введена неверная команда");
        while (!end) {
                int commandAddProduct = scanner.nextInt();
                if (commandAddProduct > 0 && commandAddProduct <= 5) {
                    cart.addProductToCart(commandAddProduct);
                    System.out.println("Ваша корзина: " + cart.showCart());
                }
                if(commandAddProduct <0 && commandAddProduct >=-5){
                    int id = commandAddProduct * -1;
                    cart.deleteProductToCart(id);
                    System.out.println("Ваша корзина: " + cart.showCart());
                }
        }

    }
}
