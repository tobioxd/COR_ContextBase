package com.example.demo.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Cust {

    private Long id;

    private String username;

    private String role;

    private String code;

    private String name;

    @JsonProperty("bank_cd")
    private String bankcode;


}