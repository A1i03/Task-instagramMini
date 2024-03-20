package servicelmpl;

import model.DataBase;
import model.Post;
import model.User;
import service.PostService;

import java.util.List;

public  class PostServiceImpl implements PostService {


    @Override
    public Post addPostToUser(Post post) {
        DataBase.posts.add(post);
        return post;
    }

    @Override
    public Post deletePostById(Long postId) {
        for (Post post : DataBase.posts){
            if (postId.equals(post.getId())){
                DataBase.posts.remove(post);
                return post;
                }
            }
        return null;
    }


    @Override
    public List<Post> getPostsByUserId(Long userId) {
        for (User user : DataBase.users){
            if (user.getId() == userId){
                return user.getPosts();
            }else {
                System.out.println(" not found");
            }
        }
        return null;
    }
}