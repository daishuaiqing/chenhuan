
import lombok.Data;
import io.swagger.annotations.ApiModelProperty;

@Data
public class ${model_name_uc}Param  {

<#if model_column?exists>
    <#list model_column as model>
        <#if model.column_name = 'id'>
    private Long id;

        <#elseif model.column_name = 'create_time'>
    /**
     * 创建时间
     */
    private LocalDateTime createTime;

        <#elseif model.column_name = 'update_time'>
    /**
     * 上次更新时间
     */
    private LocalDateTime updateTime;

        <#elseif model.column_name = 'is_deleted'>
    /**
     * 是否删除
     */
    private Integer deleted;

        <#else>
            <#if (model.data_type = 'varchar' || model.data_type = 'text' || model.data_type = 'char')>
    /**
     * ${model.column_comment!}
     */
    @ApiModelProperty(value="${model.column_comment!}")
    private String ${model.column_name_uc?uncap_first};

            </#if>
            <#if model.data_type = 'datetime'>
    /**
     * ${model.column_comment!}
     */
    @ApiModelProperty(value="${model.column_comment!}")
    private LocalDateTime ${model.column_name_uc?uncap_first};

            </#if>
            <#if model.data_type = 'date'>
    /**
     * ${model.column_comment!}
     */
    @ApiModelProperty(value="${model.column_comment!}")
    private LocalDate ${model.column_name_uc?uncap_first};

            </#if>
            <#if model.data_type = 'time'>
    /**
     * ${model.column_comment!}
     */
    @ApiModelProperty(value="${model.column_comment!}")
    private LocalTime ${model.column_name_uc?uncap_first};

            </#if>
            <#if model.data_type = 'int'>
    /**
     * ${model.column_comment!}
     */
    @ApiModelProperty(value="${model.column_comment!}")
    private Integer ${model.column_name_uc?uncap_first};

            </#if>
            <#if (model.data_type = 'int unsigned' || model.data_type = 'tinyint' || model.data_type = 'tinyint unsigned')>
    /**
     * ${model.column_comment!}
     */
    @ApiModelProperty(value="${model.column_comment!}")
    private Integer ${model.column_name_uc?uncap_first};

            </#if>
            <#if model.data_type = 'bigint unsigned'>
    /**
     * ${model.column_comment!}
     */
    @ApiModelProperty(value="${model.column_comment!}")
    private Long ${model.column_name_uc?uncap_first};

            </#if>
            <#if model.data_type = 'bigint'>
    /**
     * ${model.column_comment!}
     */
    @ApiModelProperty(value="${model.column_comment!}")
    private Long ${model.column_name_uc?uncap_first};

            </#if>
            <#if model.data_type = 'bit' || model.data_type = 'tinyint unsigned'>
    /**
     * ${model.column_comment!}
     */
    @ApiModelProperty(value="${model.column_comment!}")
    private Integer ${model.column_name_uc?uncap_first};

            </#if>
            <#if (model.data_type = 'decimal unsigned' || model.data_type = 'decimal')>
    /**
     * ${model.column_comment!}
     */
    @ApiModelProperty(value="${model.column_comment!}")
    private BigDecimal ${model.column_name_uc?uncap_first};

            </#if>
            <#if model.data_type = 'json'>
    /**
     * ${model.column_comment!}
     */
    @ApiModelProperty(value="${model.column_comment!}")
    private JSONObject ${model.column_name_uc?uncap_first};

            </#if>
        </#if>
    </#list>
</#if>

}