package com.example.demo.bean.request;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UpdateAccountRequest {

    private String code;

    private String name;

    private String bankcode;

}
