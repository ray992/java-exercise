package com.exercise.mapStruct;

import com.exercise.mapStruct.mapper.UserComplexMapper;
import com.exercise.mapStruct.mapper.UserMapper;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import java.util.Date;
import java.util.UUID;

/**
 * @ClassName UserMapStructTest
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/1/4 下午7:51
 * @Version 1.0
 **/

public class UserMapStructTest {

    @Test
    public void test(){
        System.out.println("test...");
    }

    @Test
    public void testCopyObject(){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        userDTO.setName("mike");
        userDTO.setAge(27);
        userDTO.setGender("female");
        userDTO.setCreateTime(new Date());
        UserMapper userMapper = Mappers.getMapper(UserMapper.class);
        UserVO userVO = userMapper.sourceToTarget(userDTO);
        System.out.println(userVO);
    }

    @Test
    public void testCopyComplexObject(){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        userDTO.setName("mike");
        userDTO.setAge(27);
        userDTO.setGender("female");
        userDTO.setCreateTime(new Date());
        UserWalletDTO userWalletDTO = new UserWalletDTO();
        userWalletDTO.setAddress("abc");
        userWalletDTO.setAmount(12.4);
        UserComplexMapper userComplexMapper = Mappers.getMapper(UserComplexMapper.class);
        UserVO userVO = userComplexMapper.userInfoAndWalletToUserVO(userDTO, userWalletDTO);
        System.out.println(userVO);
    }


    @Test
    public void testUpdate(){
        UserWalletDTO userWalletDTO = new UserWalletDTO();
        userWalletDTO.setAddress("abc");
        userWalletDTO.setAmount(12.4);
        UserWallet userWallet = new UserWallet();
        userWallet.setId(UUID.randomUUID().toString());
        UserComplexMapper userComplexMapper = Mappers.getMapper(UserComplexMapper.class);
        userComplexMapper.updateUserWallet(userWalletDTO, userWallet);
        System.out.println(userWallet);
    }
}
