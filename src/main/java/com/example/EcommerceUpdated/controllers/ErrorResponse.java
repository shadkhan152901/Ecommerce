package com.example.EcommerceUpdated.controllers;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@Builder
public class ErrorResponse {

    private int status;

    private String message;

    private LocalDateTime datetime;

    ErrorResponse(int status,String message,LocalDateTime datetime){
        this.status = status;
        this.datetime = datetime;
        this.message = message;
    }
}
