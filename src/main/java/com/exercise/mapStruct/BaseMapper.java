package com.exercise.mapStruct;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.MapperConfig;


import java.util.List;
import java.util.stream.Stream;

/** 转换基类 **/
@MapperConfig
public interface BaseMapper<SOURCE, TARGET> {


    TARGET sourceToTarget(SOURCE source); //映射同名属性

    @InheritInverseConfiguration(name = "sourceToTarget")
    SOURCE targetToSource(TARGET target); //反向

    @InheritConfiguration(name = "sourceToTarget")
    List<TARGET> targetToSource(List<SOURCE> sourceList); //集合形式

    List<TARGET> targetToSource(Stream<SOURCE> stream);//流形式
}

