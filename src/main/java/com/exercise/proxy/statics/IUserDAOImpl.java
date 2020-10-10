package com.exercise.proxy;

/**
 * @ClassName IUserDAOImpl
 * @Description TODO
 * @Author yeqiang
 * @Date 2020/10/9 9:59 下午
 * @Version 1.0
 **/
public class IUserDAOImpl implements IUserDAO {

    @Override
    public void save() {
        System.out.println("save");
    }
}
