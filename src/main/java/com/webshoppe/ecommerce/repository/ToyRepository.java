package com.webshoppe.ecommerce.repository;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.webshoppe.ecommerce.entity.Toy;
import com.webshoppe.ecommerce.exception.DataAccessException;
import com.webshoppe.ecommerce.jdbc.JdbcConnectionManager;

public class ToyRepository {
    private final static String TOY_FIND_ALL = "SELECT tid, tname, tdesc, tprice FROM ToysDetails";
    private final static String TOY_FIND_BY_PRICE = TOY_FIND_ALL + " WHERE tprice BETWEEN ? AND ?";

    private JdbcConnectionManager jdbcConnectionManager;

    public ToyRepository(JdbcConnectionManager jdbcConnectionManager) {
        this.jdbcConnectionManager = jdbcConnectionManager;
    }

    public List<Toy> findAll() {
        try {
            final Connection connection = jdbcConnectionManager.getConnection();

            final PreparedStatement findAllQuery = connection.prepareStatement(TOY_FIND_ALL);

            final ResultSet resultSet = findAllQuery.executeQuery();
            final List<Toy> toys = new ArrayList<>();
            while (resultSet.next()) {
                Toy toy = new Toy(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getBigDecimal(4));
                toys.add(toy);
            }

            return toys;
        } catch (Exception e) {
            throw DataAccessException.instance("failed_to_retrieve_toys" + e.getMessage());
        }
    }

    public List<Toy> findByPrice(BigDecimal minimumPrice, BigDecimal maximumPrice) {
        try {
            final Connection connection = jdbcConnectionManager.getConnection();

            final PreparedStatement findAllQuery = connection.prepareStatement(TOY_FIND_BY_PRICE);
            findAllQuery.setBigDecimal(1, minimumPrice);
            findAllQuery.setBigDecimal(2, maximumPrice);

            final ResultSet resultSet = findAllQuery.executeQuery();
            final List<Toy> toys = new ArrayList<>();
            while (resultSet.next()) {
                Toy toy = new Toy(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getBigDecimal(4));
                toys.add(toy);
            }

            return toys;
        } catch (Exception e) {
            throw DataAccessException.instance("failed_to_retrieve_toys_by_price" + e.getMessage());
        }
    }
}
