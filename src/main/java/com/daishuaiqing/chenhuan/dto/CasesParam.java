package com.daishuaiqing.chenhuan.dto;

import lombok.Data;
import io.swagger.annotations.ApiModelProperty;

@Data
public class CasesParam  {

    private Long id;

    /**
     * 案例名称
     */
    @ApiModelProperty(value="案例名称")
    private String caseName;

    /**
     * 案例简述
     */
    @ApiModelProperty(value="案例简述")
    private String caseDescribe;

    /**
     * 关键词
     */
    @ApiModelProperty(value="关键词")
    private String keyWords;

    /**
     * 内容
     */
    @ApiModelProperty(value="内容")
    private String content;

    /**
     * 小图
     */
    @ApiModelProperty(value="小图")
    private String smallImage;

}