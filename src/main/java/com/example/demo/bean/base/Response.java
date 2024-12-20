package com.example.demo.bean.base;


import com.example.demo.bean.Cust;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Response {

    private Cust cust;

    private List<Cust> custs;

}
