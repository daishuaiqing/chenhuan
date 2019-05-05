package com.daishuaiqing.chenhuan.dto;

import lombok.Data;
import io.swagger.annotations.ApiModelProperty;

@Data
public class ServiceCustomerParam  {

    private Long id;

    /**
     * 服务的企业名称
     */
    @ApiModelProperty(value="服务的企业名称")
    private String customerName;

    /**
     * 企业Logo
     */
    @ApiModelProperty(value="企业Logo")
    private String url;

}