package com.linwu.project.building.projectbuilding.service;

import com.linwu.project.building.projectbuilding.mapper.UserMapper;
import com.linwu.project.building.projectbuilding.model.entity.User;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.linwu.project.building.projectbuilding.plus.MyService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息 服务实现类
 * </p>
 *
 * @author 林雾
 * @since 2019-05-29
 */
@Service
public class UserService extends MyService<UserMapper, User> {

}
