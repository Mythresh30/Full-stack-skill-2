package com.fsad.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.fsad.entity.Product;
import com.fsad.util.HibernateUtil;

public class ProductHQLDAO {

    // Sort price ascending
    public void sortPriceAsc(){

        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Product> list = session.createQuery(
                "FROM Product ORDER BY price ASC", Product.class).list();

        list.forEach(p -> System.out.println(p.getName()+" "+p.getPrice()));

        session.close();
    }

    // Sort price descending
    public void sortPriceDesc(){

        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Product> list = session.createQuery(
                "FROM Product ORDER BY price DESC", Product.class).list();

        list.forEach(p -> System.out.println(p.getName()+" "+p.getPrice()));

        session.close();
    }

    // Sort quantity highest
    public void sortQuantity(){

        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Product> list = session.createQuery(
                "FROM Product ORDER BY quantity DESC", Product.class).list();

        list.forEach(p -> System.out.println(p.getName()+" "+p.getQuantity()));

        session.close();
    }

    // Pagination first 3
    public void firstThree(){

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<Product> q = session.createQuery("FROM Product", Product.class);

        q.setFirstResult(0);
        q.setMaxResults(3);

        q.list().forEach(p -> System.out.println(p.getName()));

        session.close();
    }

    // Pagination next 3
    public void nextThree(){

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<Product> q = session.createQuery("FROM Product", Product.class);

        q.setFirstResult(3);
        q.setMaxResults(3);

        q.list().forEach(p -> System.out.println(p.getName()));

        session.close();
    }

    // Count products
    public void countProducts(){

        Session session = HibernateUtil.getSessionFactory().openSession();

        Long count = (Long) session.createQuery(
                "SELECT COUNT(*) FROM Product").uniqueResult();

        System.out.println("Total Products : "+count);

        session.close();
    }

    // Min Max price
    public void minMaxPrice(){

        Session session = HibernateUtil.getSessionFactory().openSession();

        Object[] result = (Object[]) session.createQuery(
                "SELECT MIN(price), MAX(price) FROM Product").uniqueResult();

        System.out.println("Min Price : "+result[0]);
        System.out.println("Max Price : "+result[1]);

        session.close();
    }

    // Group by description
    public void groupByDescription(){

        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Object[]> list = session.createQuery(
                "SELECT description, COUNT(*) FROM Product GROUP BY description").list();

        list.forEach(r -> System.out.println(r[0]+" "+r[1]));

        session.close();
    }

    // Price range
    public void priceRange(){

        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Product> list = session.createQuery(
                "FROM Product WHERE price BETWEEN 1000 AND 20000", Product.class).list();

        list.forEach(p -> System.out.println(p.getName()+" "+p.getPrice()));

        session.close();
    }

    // LIKE queries
    public void likeQueries(){

        Session session = HibernateUtil.getSessionFactory().openSession();

        System.out.println("Names starting with M");

        session.createQuery(
                "FROM Product WHERE name LIKE 'M%'", Product.class)
                .list()
                .forEach(p -> System.out.println(p.getName()));

        System.out.println("Names ending with r");

        session.createQuery(
                "FROM Product WHERE name LIKE '%r'", Product.class)
                .list()
                .forEach(p -> System.out.println(p.getName()));

        System.out.println("Names containing top");

        session.createQuery(
                "FROM Product WHERE name LIKE '%top%'", Product.class)
                .list()
                .forEach(p -> System.out.println(p.getName()));

        System.out.println("Names length 5");

        session.createQuery(
                "FROM Product WHERE name LIKE '_____'", Product.class)
                .list()
                .forEach(p -> System.out.println(p.getName()));

        session.close();
    }
}