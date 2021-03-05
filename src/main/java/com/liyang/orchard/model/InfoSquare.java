package com.liyang.orchard.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "信息广场")
@Table(name = "info_square")
public class InfoSquare {

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

    @ApiModelProperty(value = "联系人")
    @Column(name = "name")
    private String name;

    @ApiModelProperty(value = "联系电话")
    @Column(name = "phone")
    private String phone;

//    @ApiModelProperty(value = "图片地址列表")
//    @Transient
//    private List<ImgList> imgList;

    @ApiModelProperty(value = "图片地址列表")
    @Transient
    private List<ImgList> imgList;

    @ApiModelProperty(value = "视频源")
    @Column(name = "video_url")
    private String videoUrl;

    @ApiModelProperty(value = "求购重量")
    @Column(name = "buy_weight")
    private String buyWeight;

    @ApiModelProperty(value = "招聘人数")
    @Column(name = "recruit_num")
    private String recruitNum;

    @ApiModelProperty(value = "信息类型")
    @Column(name = "info_type_id")
    private Integer infoTypeId;

    @ApiModelProperty(value = "发布时间")
    @Column(name = "release_date")
    private Date releaseDate;

    @ApiModelProperty(value = "信息标签")
    @Column(name = "tags")
    private String tags;

    @ApiModelProperty(value = "富文本")
    @Column(name = "rich_text")
    private String richText;
}