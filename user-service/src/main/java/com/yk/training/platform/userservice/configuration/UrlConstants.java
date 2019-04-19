package com.yk.training.platform.userservice.configuration;

public class UrlConstants {

    public static final String USER_ID = "userId";

    public static final String URI_USER_ID = "/{" + USER_ID + "}";

    public static final String API_USER_SERVICE = "/user-service";
    public static final String API_USER_SERVICE_USER = API_USER_SERVICE + "/user";

    public static final String API_USER_ITEM = API_USER_SERVICE_USER + URI_USER_ID;
}
