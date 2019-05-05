package com.daishuaiqing.chenhuan.dto;

import lombok.Data;
import io.swagger.annotations.ApiModelProperty;

@Data
public class ForumParam  {

    private Long id;

    /**
     * 讲堂名称
     */
    @ApiModelProperty(value="讲堂名称")
    private String forumName;

    /**
     * 讲堂简述
     */
    @ApiModelProperty(value="讲堂简述")
    private String forumDescribe;

    /**
     * 关键词
     */
    @ApiModelProperty(value="关键词")
    private String keyWords;

}