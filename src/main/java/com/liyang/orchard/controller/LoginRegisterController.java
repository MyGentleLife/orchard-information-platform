package com.liyang.orchard.controller;

import com.liyang.orchard.core.Result;
import com.liyang.orchard.core.ResultGenerator;
import com.liyang.orchard.model.User;
import com.liyang.orchard.service.SmsService;
import com.liyang.orchard.service.UserService;
import com.liyang.orchard.utils.MD5Utils;
import com.liyang.orchard.utils.verify.VerifyCharCodeGenImpl;
import com.liyang.orchard.utils.verify.VerifyCode;
import com.liyang.orchard.utils.verify.VerifyCodeGen;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

@RestController
@RequestMapping("/")
@CrossOrigin
@Api(tags = "登录、注册")
public class LoginRegisterController {
    @Resource
    private UserService userService;
    @Resource
    private SmsService smsService;

    /**
     * 注册功能
     * @param user 用户
     * @return 注册结果
     */
    @ApiOperation(value = "注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Result register(@RequestBody User user){
        // 调用MD5工具类进行加密
        user.setPassword(MD5Utils.inputPassToFormPass(user.getPassword()));
        // 添加注册用户
        userService.save(user);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 登录功能
     * @param phone 电话
     * @param password 密码
     * @return 验证结果
     */
    @ApiOperation(value = "登录")
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public Result login(@RequestParam("phone") String phone, @RequestParam("password") String password){
        // 调用MD5工具类进行加密
        String inputEncryptionPassword=MD5Utils.inputPassToFormPass(password);
        // 调用自己编写的根据用户名查询方法
        User user=userService.findByPhone(phone);
        // 进行逻辑判断数据库是否有这个用户
        if(user==null){
            // 没有此用户,返回错误信息
            return ResultGenerator.genFailResult("您未注册账号,请先注册");
        }
        // 如果不为空,根据用户对象获取数据的密码
        String dbEncryptionPassword=user.getPassword();
        // 将数据的密码和前端传进来的密码进行匹配
        if(dbEncryptionPassword.equals(inputEncryptionPassword)) {
            //匹配成功输入SUCCESS
            return ResultGenerator.genSuccessResult();
        }
        else {
            // 匹配失败输出错误信息
            return ResultGenerator.genFailResult("密码或账户输入错误,请重新输入");
        }
    }

    @ApiOperation(value = "验证码")
    @RequestMapping(value = "/verifyCode", method = RequestMethod.GET)
    public void verifyCode(HttpServletRequest request, HttpServletResponse response) {
        VerifyCodeGen verifyCodeGen = new VerifyCharCodeGenImpl();
        try {
            //设置长宽
            VerifyCode verifyCode = verifyCodeGen.generate(80, 28);
            String code = verifyCode.getCode();
            LOGGER.info(code);
            //将VerifyCode绑定session
            request.getSession().setAttribute("VerifyCode", code);
            //设置响应头
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            //在代理服务器端防止缓冲
            response.setDateHeader("Expires", 0);
            //设置响应内容类型
            response.setContentType("image/jpeg");
            response.getOutputStream().write(verifyCode.getImgBytes());
            response.getOutputStream().flush();
            // 设置Cookie
            Cookie cookie = new Cookie("verifyCode",code);
            response.addCookie(cookie);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @ApiOperation(value = "短信验证码登录")
    @RequestMapping(value = "/sms",method = RequestMethod.GET)
    public Result sendSms(@RequestParam(value = "phone")String phone){
        smsService.sendSms(phone);
        return ResultGenerator.genSuccessResult();
    }
}