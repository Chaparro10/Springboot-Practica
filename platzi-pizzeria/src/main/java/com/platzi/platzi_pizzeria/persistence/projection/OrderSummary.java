package com.platzi.platzi_pizzeria.persistence.projection;

import com.platzi.platzi_pizzeria.persistence.entity.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public interface OrderSummary {
    Integer getIdOrder();
    String getCustomer();
    LocalDateTime getOrderDate();
    Double getPrice();
    String getName();
}
