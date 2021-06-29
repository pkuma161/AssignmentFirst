package com.jsonplaceholder.scenarios;

import com.jsonplaceholder.utilities.Endpoints;
import com.jsonplaceholder.utilities.Routes;
import com.jsonplaceholder.model.Comment;
import com.jsonplaceholder.model.Post;
import com.jsonplaceholder.model.User;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

class GivenIamUserDelphineIneedToValidateTests {

    static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    static final String USER_NAME_PARAM = "username";
    static final String USER_ID_PARAM = "userid";
    static final String POST_ID_PARAM = "postId";

    static final String USER_POSTS_PATH = "/{userid}/posts";
    static final String USERS_PATH = "/users";
    static final String COMMENTS_PATH = "/comments";

    static final String emailRegex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";


    static final String userName = "Delphine";
    static List<User> user;
    static List<Post> posts;
    static List<Comment> comments;

    @Test
    void emailFormatForEachCommentsUnderEachPosts(){
        user = Arrays.asList(Endpoints.getMethodWithParam(Routes.getUsersPath(), USER_NAME_PARAM, userName)
                .then().assertThat().statusCode(SC_OK).contentType(ContentType.JSON)
                .extract().body().as(User[].class));


        posts = Arrays.asList(given().baseUri(BASE_URL).basePath(USERS_PATH).pathParam(USER_ID_PARAM, user.get(0).getId())
                .when().get(USER_POSTS_PATH)
                .then().assertThat().statusCode(SC_OK).contentType(ContentType.JSON)
                .extract().body().as(Post[].class));


        for ( Post post:posts) {
            comments = Arrays.asList(given().baseUri(BASE_URL).basePath(COMMENTS_PATH).param(POST_ID_PARAM, post.getId())
                    .when().get()
                    .then().assertThat().statusCode(SC_OK).contentType(ContentType.JSON)
                    .extract().body().as(Comment[].class));

            for (Comment comment:comments) {
                Assertions.assertTrue(comment.getEmail().matches(emailRegex));
            }
        }
    }
}
