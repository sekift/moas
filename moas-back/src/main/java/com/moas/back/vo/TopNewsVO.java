package com.moas.back.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(description="热点信息")
public class TopNewsVO extends BaseEntity {

    private Long topid;

    private String md5;

    private Integer sortindex;

    private String content;

    private Integer toprank;

    private String linkurl;

    private String imageurl;

    private Integer sourceid;

    private String source;

    private Byte status;

    private Integer visits;

    private Integer noteint;

    private String notestring;

    @ApiModelProperty(required = false, name="posttime", dataType = "date", value = "时间（yyyy-MM-dd HH:mm:ss）",
            example = "2019-07-02 12:53:18", position = 24)
    private Date posttime;

    @ApiModelProperty(required = false, name="createtime", dataType = "date", value = "时间（yyyy-MM-dd HH:mm:ss）",
            example = "2019-07-02 12:53:18", position = 25)
    private Date createtime;

    @ApiModelProperty(required = false, name="updatetime", dataType = "date", value = "时间（yyyy-MM-dd HH:mm:ss）",
            example = "2019-07-02 12:53:18", position = 26)
    private Date updatetime;

    private String remark;
}