package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoHibernateImpl();

        userDao.dropUsersTable();
        userDao.createUsersTable();

        userDao.saveUser("Ivan", "Ivanov", (byte) 25);
        System.out.printf("User с именем – %s добавлен в базу данных\n", userDao.getAllUsers().get(0).getName());
        userDao.saveUser("Petr", "Petrov", (byte) 20);
        System.out.printf("User с именем – %s добавлен в базу данных\n", userDao.getAllUsers().get(1).getName());
        userDao.saveUser("Anna", "Ivanova", (byte) 22);
        System.out.printf("User с именем – %s добавлен в базу данных\n", userDao.getAllUsers().get(2).getName());
        userDao.saveUser("Olga", "Petrova", (byte) 19);
        System.out.printf("User с именем – %s добавлен в базу данных\n", userDao.getAllUsers().get(3).getName());
        userDao.getAllUsers().stream().forEach(System.out::println);
        userDao.cleanUsersTable();
        userDao.dropUsersTable();
        Util.closeSessionFactory();
    }
}
