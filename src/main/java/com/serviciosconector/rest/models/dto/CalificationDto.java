package com.serviciosconector.rest.models.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
@Data
@ToString
@Builder
public class CalificationDto implements Serializable {

    private String id;
    private int  valueClient;
    private int valueDriver;
    private String idTravel;
}
