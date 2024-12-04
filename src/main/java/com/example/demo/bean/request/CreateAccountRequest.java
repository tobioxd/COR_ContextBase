package com.example.demo.bean.request;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateAccountRequest {

    private String username;

    private String code;

    private String name;

    private String bankcode;

}
