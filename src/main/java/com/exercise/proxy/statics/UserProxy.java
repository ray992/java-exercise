package com.exercise.proxy;

/**
 * @ClassName UserProxy
 * @Description TODO
 * @Author yeqiang
 * @Date 2020/10/9 10:00 下午
 * @Version 1.0
 **/
public class UserProxy implements IUserDAO{

    private IUserDAO iUserDAO;

    public UserProxy(IUserDAO iUserDAO) {
        this.iUserDAO = iUserDAO;
    }

    @Override
    public void save() {
        iUserDAO.save();
    }
}
