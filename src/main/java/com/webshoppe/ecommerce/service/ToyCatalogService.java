package com.webshoppe.ecommerce.service;

import java.math.BigDecimal;
import java.util.List;

import com.webshoppe.ecommerce.entity.Toy;
import com.webshoppe.ecommerce.exception.DataAccessException;
import com.webshoppe.ecommerce.exception.ServiceException;
import com.webshoppe.ecommerce.repository.ToyRepository;

public class ToyCatalogService {
    private ToyRepository toyRepository;

    public ToyCatalogService(ToyRepository toyRepository) {
        this.toyRepository = toyRepository;
    }

    public List<Toy> getToyCatalog() {
        try {
            return toyRepository.findAll();
        } catch (DataAccessException e) {
            throw ServiceException.instance(e.getMessage());
        }

    }

    public List<Toy> getToyCatalog(BigDecimal minimumPrice, BigDecimal maximumPrice) {
        try {
            return toyRepository.findByPrice(minimumPrice, maximumPrice);
        } catch (DataAccessException e) {
            throw ServiceException.instance(e.getMessage());
        }

    }
}
