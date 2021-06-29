
/*
@Author Prasann Kumar

This class is used to define uri path for model objects.

*/


package com.jsonplaceholder.utilities;

public class Routes {

    public static String getBaseUrl() {
        return BASE_URL;
    }

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    private static final String USERS_PATH = "/users";
    private static final String POSTS_PATH = "/posts";
    private static final String TODOS_PATH = "/todos";
    private static final String PHOTOS_PATH = "/posts";
    private static final String ALBUMS_PATH = "/posts";
    private static final String COMMENTS_PATH = "/comments";


    public static String getPostsPath() {
        return POSTS_PATH;
    }

    public static String getTodosPath() {
        return TODOS_PATH;
    }

    public static String getPhotosPath() {
        return PHOTOS_PATH;
    }

    public static String getAlbumsPath() {
        return ALBUMS_PATH;
    }

    public static String getCommentsPath() {
        return COMMENTS_PATH;
    }

    public static String getUsersPath(){
        return USERS_PATH;
    }

    public static String getPostById(String postId){
        return POSTS_PATH + "/" + postId;
    }

    public static String GetCommentsByPostIdAbsolutePath(long postId){
        return POSTS_PATH + "/" + postId + COMMENTS_PATH;
    }
}
