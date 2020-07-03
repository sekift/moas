package com.moas.back.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(description="分词信息")
public class TopWordsVO extends BaseEntity {

    private Long wordid;

    private Long topid;

    private String word;

    private String wordtype;

    @ApiModelProperty(required = false, name="createtime", dataType = "date", value = "时间（yyyy-MM-dd HH:mm:ss）",
            example = "2020-07-02 12:53:18", position = 25)
    private Date createtime;

    @ApiModelProperty(required = false, name="updatetime", dataType = "date", value = "时间（yyyy-MM-dd HH:mm:ss）",
            example = "2020-07-02 12:53:18", position = 26)
    private Date updatetime;

    private Byte status;

    private Integer visits;
}
