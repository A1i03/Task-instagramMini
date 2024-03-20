package service;

import model.Post;

import java.util.List;

public interface PostService {
 //   String addPostToUser(Post post);

    Post addPostToUser(Post post);

    //String deletePostById(Long postId);

    Post deletePostById(Long postId);

 //   List<Post> getPostsByUserId(Long userId);

    List<Post> getPostsByUserId(Long userId);
}