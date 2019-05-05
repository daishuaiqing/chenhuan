package com.daishuaiqing.chenhuan.dto;

import lombok.Data;
import io.swagger.annotations.ApiModelProperty;

@Data
public class RequesterInfoParam  {

    private Long id;

    /**
     * 姓名
     */
    @ApiModelProperty(value="姓名")
    private String requesterName;

    /**
     * 电话
     */
    @ApiModelProperty(value="电话")
    private String phoneNumber;


}