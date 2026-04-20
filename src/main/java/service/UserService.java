package service;
import api.ApiClient;
import model.Comment;
import model.User;
import model.Posts;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserService {
    ApiClient client;
    ObjectMapper mapper = new ObjectMapper();
    public UserService() {
        client = new ApiClient();

    }
    private String getUsersJsonBody() {
        return client.get("users");
    }
    private String getCommentsJsonBody() {
        return client.get("comments");
    }
    private String getPostsJsonBody() {
        return client.get("posts");
    }

    //get list of objects filled with api data
    public User[] generateUserList() {
        try {
            String jsonBody = getUsersJsonBody();
            User[] users = mapper.readValue(jsonBody, User[].class);
            return users;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    public Comment[] generateCommentList() {
        try {
            String jsonBody = getCommentsJsonBody();
            Comment[] comments = mapper.readValue(jsonBody, Comment[].class);
            return comments;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    public Posts[] generatePostList() {
        try {
            String jsonBody = getPostsJsonBody();
            Posts[] posts = mapper.readValue(jsonBody, Posts[].class);
            return posts;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

}
