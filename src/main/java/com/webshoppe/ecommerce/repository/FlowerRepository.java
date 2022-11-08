package com.webshoppe.ecommerce.repository;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.webshoppe.ecommerce.entity.Flower;
import com.webshoppe.ecommerce.exception.DataAccessException;
import com.webshoppe.ecommerce.jdbc.JdbcConnectionManager;

public class FlowerRepository {
    private final static String FLOWER_FIND_ALL = "SELECT fid, fname, fdesc, fprice FROM FlowersDetails";
    private final static String FLOWER_FIND_BY_PRICE = FLOWER_FIND_ALL + " WHERE fprice BETWEEN ? AND ?";

    private JdbcConnectionManager jdbcConnectionManager;

    public FlowerRepository(JdbcConnectionManager jdbcConnectionManager) {
        this.jdbcConnectionManager = jdbcConnectionManager;
    }

    public List<Flower> findAll() {
        try {
            final Connection connection = jdbcConnectionManager.getConnection();

            final PreparedStatement findAllQuery = connection.prepareStatement(FLOWER_FIND_ALL);

            final ResultSet resultSet = findAllQuery.executeQuery();
            final List<Flower> flowers = new ArrayList<>();
            while (resultSet.next()) {
                Flower flower = new Flower(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getBigDecimal(4));
                flowers.add(flower);
            }

            return flowers;
        } catch (Exception e) {
            throw DataAccessException.instance("failed_to_retrieve_flowers" + e.getMessage());
        }
    }

    public List<Flower> findByPrice(BigDecimal minimumPrice, BigDecimal maximumPrice) {
        try {
            final Connection connection = jdbcConnectionManager.getConnection();

            final PreparedStatement findAllQuery = connection.prepareStatement(FLOWER_FIND_BY_PRICE);
            findAllQuery.setBigDecimal(1, minimumPrice);
            findAllQuery.setBigDecimal(2, maximumPrice);

            final ResultSet resultSet = findAllQuery.executeQuery();
            final List<Flower> flowers = new ArrayList<>();
            while (resultSet.next()) {
                Flower flower = new Flower(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getBigDecimal(4));
                flowers.add(flower);
            }

            return flowers;
        } catch (Exception e) {
            throw DataAccessException.instance("failed_to_retrieve_flowers_by_price" + e.getMessage());
        }
    }
}
