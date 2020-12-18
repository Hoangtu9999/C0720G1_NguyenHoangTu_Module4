package com.hoangtu.admin.entity.generator;

import java.io.Serializable;
import java.util.stream.Stream;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class MyGenerator implements IdentifierGenerator {
    private String prefixProduct = "KH-";

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object obj) throws HibernateException {
        String query = "SELECT c.id FROM customer c";
        Stream<String> ids = session.createQuery(query, String.class).stream();
        Long max = ids.map(o -> o.replace(prefixProduct, "")).mapToLong(Long::parseLong).max().orElse(0L);
        return prefixProduct + (String.format("%04d", max + 1));
    }
}