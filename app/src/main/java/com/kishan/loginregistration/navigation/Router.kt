package com.kishan.loginregistration.navigation


sealed class Router(val route:String){
    data object MainRoute:Router("main_screen")
    data object LoginRoute:Router("login_screen")
    data object RegisterRoute:Router("register_screen")

    data object LoginRoute2:Router("login_screen_2")
    data object RegisterRoute2:Router("register_screen_2")
    data object VerifyRoute2:Router("verify_router")

    data object LoginRoute3:Router("login_screen_3")
    data object RegisterRoute3:Router("register_route_3")
    data object VerifyRoute3:Router("verify_route_3")

}

