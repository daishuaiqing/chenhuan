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
@SQLDelete(sql = "update link set is_deleted=1 where id=?")
@Where(clause = "is_deleted = 0")
@Table(name = "link")
@Data
public class Link  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 名称
     */
    @Column(name = "link_name")
    private String linkName;

    /**
     * 地址
     */
    @Column(name = "link_url")
    private String linkUrl;

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