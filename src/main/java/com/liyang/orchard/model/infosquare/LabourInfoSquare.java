package com.liyang.orchard.model.infosquare;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "信息广场-发布劳务")
public class LabourInfoSquare {

    @JsonIgnore
    @Id
    @ApiModelProperty(value = "信息ID")
    @Column(name = "info_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer infoId;

    @ApiModelProperty(value = "用户ID")
    @Column(name = "user_id")
    private Integer userId;

    @ApiModelProperty(value = "标题")
    @Column(name = "title")
    private String title;

    @ApiModelProperty(value = "描述")
    @Column(name = "description")
    private String description;

    @ApiModelProperty(value = "地址")
    @Column(name = "address")
    private String address;

    @ApiModelProperty(value = "昵称")
    @Column(name = "nikename")
    private String userNikename;

    @ApiModelProperty(value = "联系电话")
    @Column(name = "phone")
    private String phone;

    @ApiModelProperty(value = "招聘人数")
    @Column(name = "recruit_num")
    private String recruitNum;

    @ApiModelProperty(value = "图片列表")
    private List<String> imgList;

    @ApiModelProperty(value = "信息标签")
    @Column(name = "tags")
    private String tags;

    @ApiModelProperty(value = "富文本")
    @Column(name = "rich_text")
    private String richText;
}
