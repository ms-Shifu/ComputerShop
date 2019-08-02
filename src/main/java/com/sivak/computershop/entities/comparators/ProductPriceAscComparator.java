package com.sivak.computershop.entities.comparators;

import com.sivak.computershop.entities.Products;

import java.util.Comparator;

public class ProductPriceAscComparator implements Comparator<Products> {

    @Override
    public int compare(Products o1, Products o2) {
        return Double.compare(o1.getPrice(), o2.getPrice());
    }

}
