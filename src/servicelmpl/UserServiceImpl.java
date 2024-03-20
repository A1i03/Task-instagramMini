package servicelmpl;

import enums.Gender;
import model.DataBase;
import model.GenerateId;
import model.User;
import service.UserService;

import java.util.List;
import java.util.Scanner;

import static model.DataBase.users;

public class UserServiceImpl implements UserService {

    @Override
    public String register() {
        User user = new User();
        user.setId(GenerateId.genUserId());
       /** user.setID(GenerateId.generateUserId());*/
        user.setFullName();
        user.setEmail();
        user.setPassword();
        user.setGender();
        DataBase.users.add(user);
        return "User " + user.getFullName() + " successfully added ";
    }

    @Override
    public String login(String email, String password) {
        for (User user : DataBase.users){
            if (user.getEmail().equals(email) && user.getPassword().equals(password)){
                return "Login succsess";
            }
        }
        return "Lolin failed = invalid email, password";
    }

    @Override
    public User getUserByEmail(String email) {
        for (User user : DataBase.users){
            if (user.getEmail().equals(email)){
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {

        return users;
    }
}