package com.daishuaiqing.chenhuan.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BannerParam  {

    private Long id;

    /**
     * 名称
     */
    @ApiModelProperty(value="名称")
    private String bannerName;

    /**
     * 地址
     */
    @ApiModelProperty(value="地址")
    private String bannerUrl;


}