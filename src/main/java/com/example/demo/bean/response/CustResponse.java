package com.example.demo.bean.response;

import com.example.demo.bean.Cust;
import com.example.demo.bean.base.BaseResponse;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustResponse extends BaseResponse {

    private Cust cust;

}
