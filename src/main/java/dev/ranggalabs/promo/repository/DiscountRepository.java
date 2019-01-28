package dev.ranggalabs.promo.repository;

import dev.ranggalabs.promo.model.Discount;

import java.util.List;

/**
 * Created by erlangga on 17/01/19.
 */
public interface DiscountRepository {
    List<Discount> findOne(Integer id);
}
