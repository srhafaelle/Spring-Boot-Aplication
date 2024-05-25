package com.serviciosconector.rest.models.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name = "paymentMethod")
public class PaymentMethod {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Column(name = "id")
    String transactionId;
    @Column(name = "amount")
    String amount;
    @Column(name = "idClientPayment")
    String idClientPayment;
    @Column(name = "idReceiver")
    String idReceiver;
    @Column(name = "typePayment")
    String typePayment;


}
