package com.fsad.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fsad.entity.Product;
import com.fsad.util.HibernateUtil;

public class ProductDAO {

    public void insertProduct(Product p){

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(p);

        tx.commit();
        session.close();
    }
}