package com.codegym.repository;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.io.File;

@Repository
public class BaseRepository {
    public static SessionFactory sessionFactory;
    public static EntityManager entityManager;

    static {
        try {
            sessionFactory = new Configuration().configure(new File("D:\\C0720G1_NguyenHoangTu_Module4\\module4\\_05_thao_tac_csdl_va_orm\\bai_tap\\product_manager\\src\\main\\resources\\hibernate.conf.xml")).
                    buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}
