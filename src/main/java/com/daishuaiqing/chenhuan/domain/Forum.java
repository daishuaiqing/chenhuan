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
@SQLDelete(sql = "update forum set is_deleted=1 where id=?")
@Where(clause = "is_deleted = 0")
@Table(name = "forum")
@Data
public class Forum  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 讲堂名称
     */
    @Column(name = "forum_name")
    private String forumName;

    /**
     * 讲堂简述
     */
    @Column(name = "forum_describe")
    private String forumDescribe;

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