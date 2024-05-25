package com.serviciosconector.rest.models.dao;

import com.serviciosconector.rest.models.entity.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymendMothodDao extends JpaRepository<PaymentMethod,String> {
}
