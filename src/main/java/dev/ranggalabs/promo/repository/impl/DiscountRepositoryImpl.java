package dev.ranggalabs.promo.repository.impl;

import dev.ranggalabs.promo.model.Discount;
import dev.ranggalabs.promo.repository.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by erlangga on 17/01/19.
 */
@Repository
public class DiscountRepositoryImpl implements DiscountRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Discount> findOne(Integer id) {
        StringBuilder sql = new StringBuilder("SELECT * FROM discount ");
        sql.append("WHERE id = :id ");

        List<Discount> entities = null;
        try (Connection conn = sql2o.open(); Query query = conn.createQuery(sql.toString())) {
            entities = query.addParameter("id", id)
                    .executeAndFetch(Discount.class);
            return entities;
        }
    }
}

