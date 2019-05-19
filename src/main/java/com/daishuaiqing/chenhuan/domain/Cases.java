package com.daishuaiqing.chenhuan.domain;

import javax.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import java.time.LocalDateTime;


@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@SQLDelete(sql = "update cases set is_deleted=1 where id=?")
@Where(clause = "is_deleted = 0")
@Table(name = "cases")
@Data
public class Cases  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 案例名称
     */
    @Column(name = "case_name")
    private String caseName;

    /**
     * 案例简述
     */
    @Column(name = "case_describe")
    private String caseDescribe;

    /**
     * 关键词
     */
    @Column(name = "key_words")
    private String keyWords;

    /**
     * 内容
     */
    @Column(name = "content")
    private String content;

    /**
     * 小图
     */
    @Column(name = "small_image")
    private String smallImage;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private LocalDateTime createTime;

    /**
     * 上次更新时间
     */
    @Column(name = "update_time")
    private LocalDateTime updateTime;

    /**
     * 是否删除
     */
    @Column(name = "is_deleted")
    private Integer deleted;


}