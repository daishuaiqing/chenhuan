package com.daishuaiqing.chenhuan.dto;

import lombok.Data;
import io.swagger.annotations.ApiModelProperty;

@Data
public class LinkParam  {

    private Long id;

    /**
     * 名称
     */
    @ApiModelProperty(value="名称")
    private String linkName;

    /**
     * 地址
     */
    @ApiModelProperty(value="地址")
    private String linkUrl;


}