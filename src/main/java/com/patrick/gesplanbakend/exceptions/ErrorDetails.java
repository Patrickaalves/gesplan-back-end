package com.patrick.gesplanbakend.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class ErrorDetails {
    private int statusCode;
    private String message;
    private String details;
}
