
import lombok.Data;
import io.swagger.annotations.ApiModelProperty;

@Data
public class CompanyInfoParam  {

    private Long id;

    /**
     * 公司名称
     */
    @ApiModelProperty(value="公司名称")
    private String companyName;

    /**
     * 简介
     */
    @ApiModelProperty(value="简介")
    private String shortDescribe;

    /**
     * 声明
     */
    @ApiModelProperty(value="声明")
    private String notice;

    /**
     * 联系人
     */
    @ApiModelProperty(value="联系人")
    private String contacts;

    /**
     * 电话
     */
    @ApiModelProperty(value="电话")
    private String phoneNumber;

    /**
     * 微信二维码
     */
    @ApiModelProperty(value="微信二维码")
    private String wxQrCode;

    /**
     * 邮箱
     */
    @ApiModelProperty(value="邮箱")
    private String email;

    /**
     * 地址
     */
    @ApiModelProperty(value="地址")
    private String address;

    /**
     * 网站标题
     */
    @ApiModelProperty(value="网站标题")
    private String title;

    /**
     * head代码
     */
    @ApiModelProperty(value="head代码")
    private String headWord;

    /**
     * icp网站备案
     */
    @ApiModelProperty(value="icp网站备案")
    private String icp;

    /**
     * 关键字
     */
    @ApiModelProperty(value="关键字")
    private String keyword;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 上次更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否删除
     */
    private Integer deleted;


}