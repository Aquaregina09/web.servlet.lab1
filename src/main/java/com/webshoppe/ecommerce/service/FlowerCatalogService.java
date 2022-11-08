package com.webshoppe.ecommerce.service;

import java.math.BigDecimal;
import java.util.List;

import com.webshoppe.ecommerce.entity.Flower;
import com.webshoppe.ecommerce.exception.DataAccessException;
import com.webshoppe.ecommerce.exception.ServiceException;
import com.webshoppe.ecommerce.repository.FlowerRepository;

public class FlowerCatalogService {
    private FlowerRepository flowerRepository;

    public FlowerCatalogService(FlowerRepository flowerRepository) {
        this.flowerRepository = flowerRepository;
    }

    public List<Flower> getFlowerCatalog() {
        try {
            return flowerRepository.findAll();
        } catch (DataAccessException e) {
            throw ServiceException.instance(e.getMessage());
        }

    }

    public List<Flower> getFlowerCatalog(BigDecimal minimumPrice, BigDecimal maximumPrice) {
        try {
            return flowerRepository.findByPrice(minimumPrice, maximumPrice);
        } catch (DataAccessException e) {
            throw ServiceException.instance(e.getMessage());
        }

    }
}
