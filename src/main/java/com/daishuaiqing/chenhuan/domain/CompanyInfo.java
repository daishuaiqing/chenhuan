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
@SQLDelete(sql = "update company_info set is_deleted=1 where id=?")
@Where(clause = "is_deleted = 0")
@Table(name = "company_info")
@Data
public class CompanyInfo  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 公司名称
     */
    @Column(name = "company_name")
    private String companyName;

    /**
     * 简介
     */
    @Column(name = "short_describe")
    private String shortDescribe;

    /**
     * 声明
     */
    @Column(name = "notice")
    private String notice;

    /**
     * 联系人
     */
    @Column(name = "contacts")
    private String contacts;

    /**
     * 电话
     */
    @Column(name = "phone_number")
    private String phoneNumber;

    /**
     * 微信二维码
     */
    @Column(name = "wx_qr_code")
    private String wxQrCode;

    /**
     * 邮箱
     */
    @Column(name = "email")
    private String email;

    /**
     * 地址
     */
    @Column(name = "address")
    private String address;

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