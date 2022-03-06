package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class FakeModel  implements Model{
    private ModelData modelData = new ModelData();
    private UserService userService = new UserServiceImpl();


    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("Kiryl",1, 25));
        users.add(new User("Iryna",2, 1));
        users.add(new User("Marya",3, 1));
        users.add(new User("Darya",4, 1));
        modelData.setUsers(users);

    }

    @Override
    public void loadDeletedUsers() {
      throw new UnsupportedOperationException();

    }

    @Override
    public void loadUserById(long userId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteUserById(long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void changeUserData(String name, long id, int level) {
        throw new UnsupportedOperationException();
    }
}
