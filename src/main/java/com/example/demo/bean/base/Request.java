package com.example.demo.bean.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Request {

    private Long id;

    private String username;

    private String role;

    private String code;

    private String name;

    private String bankcode;

}
