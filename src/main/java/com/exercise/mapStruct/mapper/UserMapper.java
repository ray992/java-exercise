package com.exercise.mapStruct.mapper;


import com.exercise.mapStruct.BaseMapper;
import com.exercise.mapStruct.UserDTO;
import com.exercise.mapStruct.UserVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<UserDTO, UserVO> {

    //MapStruct 提供了时间格式化的属性 dataFormat，支持Date、LocalDate、LocalDateTime等时间类型与String的转换
    @Mapping(target = "createAt", source = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "sex", source = "gender")
    @Override
    UserVO sourceToTarget(UserDTO userDTO);

    //自定义属性转换器
    default List<UserVO> strToListUserVO(String str){
        //todo
        return null;
    }
}
