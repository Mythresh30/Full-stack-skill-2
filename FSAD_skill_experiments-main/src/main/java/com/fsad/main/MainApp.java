package com.fsad.main;

import com.fsad.dao.ProductDAO;
import com.fsad.dao.ProductHQLDAO;
import com.fsad.entity.Product;

public class MainApp {

    public static void main(String[] args) {

        ProductDAO dao = new ProductDAO();

        // Insert products
        dao.insertProduct(new Product("Laptop","Electronics",50000,10));
        dao.insertProduct(new Product("Mobile","Electronics",20000,20));
        dao.insertProduct(new Product("Headphones","Accessories",3000,15));
        dao.insertProduct(new Product("Keyboard","Accessories",1500,12));
        dao.insertProduct(new Product("Mouse","Accessories",800,18));
        dao.insertProduct(new Product("Monitor","Electronics",12000,7));
        dao.insertProduct(new Product("Printer","Office",9000,5));
        dao.insertProduct(new Product("Tablet","Electronics",25000,9));

        ProductHQLDAO hql = new ProductHQLDAO();

        System.out.println("Price Ascending");
        hql.sortPriceAsc();

        System.out.println("Price Descending");
        hql.sortPriceDesc();

        System.out.println("Quantity Highest");
        hql.sortQuantity();

        System.out.println("First 3 Products");
        hql.firstThree();

        System.out.println("Next 3 Products");
        hql.nextThree();

        hql.countProducts();

        hql.minMaxPrice();

        hql.groupByDescription();

        hql.priceRange();

        hql.likeQueries();
    }
}