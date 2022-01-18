package com.exercise.mapStruct.mapper;

import com.exercise.mapStruct.UserDTO;
import com.exercise.mapStruct.UserVO;
import com.exercise.mapStruct.UserWallet;
import com.exercise.mapStruct.UserWalletDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface UserComplexMapper {

    UserVO userInfoAndWalletToUserVO(UserDTO userDTO, UserWalletDTO userWalletDTO);

    void updateUserWallet(UserWalletDTO userWalletDTO, @MappingTarget UserWallet userWallet);
}
