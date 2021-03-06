package com.liyang.orchard.model.ownerhouse;

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
@ApiModel(value = "修改 园主之家")
public class UpdateOwnerHouse {

    @Id
    @ApiModelProperty(value = "园主之家ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "owner_house_id")
    private Integer ownerHouseId;

//    @ApiModelProperty(value = "用户ID")
//    @Column(name = "user_id")
//    private Integer userId;

    @ApiModelProperty(value = "描述")
    @Column(name = "description")
    private String description;

    @ApiModelProperty(value = "图片urlList")
    private List<String> imgList;

    @ApiModelProperty(value = "视频源")
    @Column(name = "video_source")
    private String videoSource;

}