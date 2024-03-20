import model.DataBase;
import model.GenerateId;
import model.Post;
import model.User;
import servicelmpl.PostServiceImpl;
import servicelmpl.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static model.DataBase.users;


public class Instagram {

    public static void main(String[] args) {
        PostServiceImpl postService = new PostServiceImpl();
        UserServiceImpl userService = new UserServiceImpl();
        Scanner scanner = new Scanner(System.in);


        while (true) {

            System.out.println( "САЛАМАТСЫЗБЫ" +
                                "КОМАНДАНЫ ТАНДАНЫЗ!!!");
            System.out.println("""
                   ~~~~~~~~~~~~~~~~~~~~~~~~~~~
                   | 1.Register              |
                   | 2.Login                 |
                   | 3.Get user By email     |
                   | 4.Get All User          |
                   | 5.Exit                  |
                   ~~~~~~~~~~~~~~~~~~~~~~~~~~~
                   """);
            try {

                switch (new Scanner(System.in).nextInt()) {
                    case 1:
                        System.out.println(userService.register());
                        break;
                    case 2:
                        System.out.println("Email- жаз: ");
                        String email = new Scanner(System.in).nextLine();
                        System.out.println("Password Жаз: ");
                        String password = new Scanner(System.in).nextLine();
                        for (User user : DataBase.users) {
                            if (email.equals(user.getEmail()) && password.equals(user.getPassword())) {
                                System.out.println(" ************** { КОШ КЕЛДИНИЗ АККАУНТК } ************** ");
                                boolean word = true;
                                while (word) {
                                    System.out.println("""
                                            *********************************
                                            |   1. add post                 |
                                            |   2. delete post by id        |
                                            |   3. get all post user by id  |
                                            |   4. exit                     |
                                            *********************************
                                            """);
                                    switch (new Scanner(System.in).nextInt()) {
                                        case 1:
                                            Post post = new Post();
                                            post.setId(GenerateId.genPostId());
                                            System.out.println(" imageIrl жазыныз: ");
                                            post.setImageUrl(new Scanner(System.in).nextLine());
                                            System.out.println("Коментариий жазыныз: ");
                                            post.setDescription(new Scanner(System.in).nextLine());
                                            DataBase.posts.add(post);
                                            break;
                                        case 2:
                                            System.out.println("Постун  Id- жазыныз: ");
                                            DataBase.posts.remove(postService.deletePostById(new Scanner(System.in).nextLong()));
                                            break;
                                        case 3:
                                            System.out.println("Колдонуучунун id- жазыныз: ");
                                            System.out.println(postService.getPostsByUserId(new Scanner(System.in).nextLong()));
                                            break;
                                        case 4:
                                            word = false;

                                        default:
                                            System.err.println("танданыз  1-2-3-4");
                                            break;

                                    }
                                }
                            }
                        }
                    case 3:
                        System.out.println("Email жазыныз: ");
                        System.out.println(userService.getUserByEmail(new Scanner(System.in).nextLine()));
                        break;
                    case 4:
                        System.out.println(userService.getAllUsers());
                        break;
                    case 5:
                        System.out.println("БИЗ МЕНЕН БОЛГОНУНУЗ УЧУН РАХМАТ!!!");

                        return;
                    default:
                        System.err.println("танданыз 1-2-3-4-5");
                }
            }
            catch (Exception e){
                System.out.println("Exception");
            }
            }
        }
    }



