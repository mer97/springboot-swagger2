package top.leemer.springbootswagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import top.leemer.springbootswagger.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LEEMER
 * Create Date: 2019-09-29
 */
@Api(value = "用户模块", description = "用户模块的接口信息")
@RestController
public class UserRestController {

    //模拟数据库
    private static List<User> users = new ArrayList<>();
    static {
        users.add(new User("张三", "123456"));
        users.add(new User("李四", "123456"));
        users.add(new User("王五", "123456"));
    }

    //获取所有用户列表
    @ApiOperation(value = "获取用户列表", notes = "获取所有用户列表")
    @GetMapping("/users")
    public Object users(){
        Map<String, Object> map = new HashMap<>();
        map.put("users", users);
        return map;
    }

    //根据用户ID获取某个用户
    @ApiOperation(value = "获取单个用户", notes = "根据用户ID获取某个用户")
    @ApiImplicitParam(value = "用户的ID", paramType = "path")
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") int id){
        return users.get(id);
    }

    //添加用户
    @ApiOperation(value = "添加用户", notes = "根据传入的用户信息添加用户")
    @ApiImplicitParam(value = "用户对象", paramType = "query")
    @PostMapping("/user")
    public Object addUser(User user){
        return users.add(user);
    }

    //删除用户
    @ApiOperation(value = "删除用户", notes = "用户传入的用户ID删除对应的用户")
    @ApiImplicitParam(value = "用户的ID", paramType = "path")
    @DeleteMapping("/user/{id}")
    public Object deleteUserById(@PathVariable("id") int id){
        return users.remove(id);
    }

}
