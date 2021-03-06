package com.liyang.orchard.controller;
import com.liyang.orchard.core.Result;
import com.liyang.orchard.core.ResultGenerator;
import com.liyang.orchard.model.User;
import com.liyang.orchard.model.user.UpdateUser;
import com.liyang.orchard.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by Liyang on 2021/01/25.
*/
@RestController
@RequestMapping("/user")
@CrossOrigin
@Api(tags = "用户")
public class UserController {
    @Resource
    private UserService userService;

    @ApiOperation(value = "添加-用户")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result add(@RequestBody User user) {
        userService.save(user);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "根据id删除-用户")
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Result delete(@ApiParam("") @RequestParam Integer id) {
        userService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @ApiIgnore
    @ApiOperation(value = "根据id更新-用户")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Result update(@RequestBody User user) {
        userService.update(user);
        return ResultGenerator.genSuccessResult();
    }

    @ApiIgnore
    @ApiOperation(value = "根据id查询-用户")
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public Result detail(@ApiParam("") @RequestParam Integer id) {
        User user = userService.findById(id);
        return ResultGenerator.genSuccessResult(user);
    }

    @ApiOperation(value = "分页查询")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result list(@ApiParam("页数") @RequestParam(defaultValue = "0") Integer page, @ApiParam("每页展示数量")  @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<User> list = userService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @ApiOperation(value = "用户个人信息（简单）")
    @RequestMapping(value = "/simpleinfo", method = RequestMethod.GET)
    public Result getSimpleUserInfo(@ApiParam("用户ID") @RequestParam("userId") Integer id) {
        return ResultGenerator.genSuccessResult(userService.getSimpleUserInfo(id));
    }

    @ApiOperation(value = "用户个人信息（详细）")
    @RequestMapping(value = "/detailinfo", method = RequestMethod.GET)
    public Result getDetailUserInfo(@ApiParam("用户ID") @RequestParam("userId") Integer id) {
        return ResultGenerator.genSuccessResult(userService.getDetailUserInfo(id));
    }

    @ApiOperation(value = "更新个人信息")
    @RequestMapping(value = "/updateinfo", method = RequestMethod.PUT)
    public Result setUserInfo(@ApiParam("用户更新后的信息") @RequestBody UpdateUser updateUser) {
        userService.setUserInfo(updateUser);
        return ResultGenerator.genSuccessResult();
    }
}
