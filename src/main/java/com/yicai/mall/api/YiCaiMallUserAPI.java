package com.yicai.mall.api;

import com.yicai.mall.api.param.YiCaiMallUserLoginParam;
import com.yicai.mall.common.Result;
import com.yicai.mall.service.impl.YiCaiMallUserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@Api(value = "用户模块", tags = "用户接口模块")
public class YiCaiMallUserAPI {

    @Resource
    private YiCaiMallUserServiceImpl service;

    @PostMapping("/login")
    @ApiOperation(value = "用户登录", notes = "返回 Token")
    public ResponseEntity<Result> login(@RequestBody @Valid YiCaiMallUserLoginParam param) {
        return service.login(param.getUsername(), param.getPassword());
    }

    @PostMapping("/register")
    @ApiOperation(value = "用户注册")
    public ResponseEntity<Result> register(@RequestBody @Valid YiCaiMallUserLoginParam param) {
        return service.register(param.getUsername(), param.getPassword());
    }

    @GetMapping("/info")
    @ApiOperation(value = "用户信息")
    public ResponseEntity<Result> info(@RequestParam("id") String id) {
        return service.info(id);
    }

}
