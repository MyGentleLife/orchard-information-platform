package com.liyang.orchard.controller;
import com.liyang.orchard.core.Result;
import com.liyang.orchard.core.ResultGenerator;
import com.liyang.orchard.model.OwnerHouse;
import com.liyang.orchard.model.ownerhouse.AddOwnerHouse;
import com.liyang.orchard.model.ownerhouse.UpdateOwnerHouse;
import com.liyang.orchard.service.OwnerHouseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by Liyang on 2021/01/30.
*/
@RestController
@RequestMapping("/ownerHouse")
@CrossOrigin
@Api(tags = "园主之家")
public class OwnerHouseController {
    @Resource
    private OwnerHouseService ownerHouseService;

//    @ApiOperation(value = "添加-园主之家信息")
//    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    public Result add(@RequestBody OwnerHouse ownerHouse) {
//        ownerHouseService.save(ownerHouse);
//        return ResultGenerator.genSuccessResult();
//    }

    @ApiOperation(value = "删除 我发布的圆主之家")
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Result delete(@ApiParam("园主之家id") @RequestParam Integer id) {
        ownerHouseService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

//    @ApiOperation(value = "根据id更新-园主之家信息")
//    @RequestMapping(value = "/update", method = RequestMethod.PUT)
//    public Result update(@RequestBody OwnerHouse ownerHouse) {
//        ownerHouseService.update(ownerHouse);
//        return ResultGenerator.genSuccessResult();
//    }

    @ApiOperation(value = "根据id查询-园主之家信息")
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public Result detail(@ApiParam("") @RequestParam Integer id) {
        OwnerHouse ownerHouse = ownerHouseService.findById(id);
        return ResultGenerator.genSuccessResult(ownerHouse);
    }

    @ApiOperation(value = "分页查询")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result list(@ApiParam("页数") @RequestParam(defaultValue = "0") Integer page, @ApiParam("每页展示数量")  @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<OwnerHouse> list = ownerHouseService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "发布 园主之家信息")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result add(@RequestBody AddOwnerHouse addOwnerHouse) {
        ownerHouseService.addOwnerHouse(addOwnerHouse);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "修改 我发布的圆主之家")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Result update(@RequestBody UpdateOwnerHouse updateOwnerHouse) {
        ownerHouseService.updateOwnerHouse(updateOwnerHouse);
        return ResultGenerator.genSuccessResult();
    }
}
