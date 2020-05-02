package com.example.school_management_system_adam;

public class Connection_constants {

    //For me localhost is 172.17.0.1 for Xampp server
    //Make sure you change the url appropriately
    //Place the Android_ADAM folder inside htdocs for Xampp server

    private static final String ROOT_URL = "http://172.17.0.1/Android_ADAM/v1/";

    public static final String REGISTER_URL = ROOT_URL + "registerUser.php";
    public static final String LOGIN_URL = ROOT_URL + "userLogin.php";
    public static final String addCLASS_URL = ROOT_URL + "addClass.php";
    public static final String addSUBJECT_URL = ROOT_URL + "addSubject.php";
}
