package com.serviciosconector.rest.models.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
@Data
@ToString
@Builder
public class PaymentMethodDto implements Serializable {
    final String id;
    final String amount;
    final  String typePayment;


}
