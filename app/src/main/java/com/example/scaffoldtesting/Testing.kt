package com.example.scaffoldtesting

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MainView() {


    val navController = rememberNavController()

    Scaffold(
        topBar = { MyTopBar() },
        bottomBar = { MyBottomBar(navController) },
    ){
        NavHost(navController = navController, startDestination = "wifi"){
            composable(route="wifi"){
                Box(modifier = Modifier.fillMaxSize().background(Color.Cyan))
            }
            composable(route="home"){
                Box(modifier = Modifier.fillMaxSize().background(Color.LightGray))
            }
            composable(route="music"){
                Box(modifier = Modifier.fillMaxSize().background(Color.Yellow))
            }
        }
    }
}

@Composable
fun MyTopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFD8AF24))
            .padding(5.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_baseline_menu_24),
            contentDescription = "")
        OutlinedTextField(
            value = "",
            onValueChange = {},
            trailingIcon = {
                Icon(painter = painterResource(id = R.drawable.ic_baseline_search_24 ),
                    contentDescription = "")
            },
            modifier = Modifier
                .border(1.dp, Color.Black)
                .background(Color.White)
        )
    }
}


@Composable
fun MyBottomBar(navContoller: NavHostController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFD8AF24))
            .padding(10.dp, 5.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_baseline_wifi_24),
            contentDescription = "",
            modifier = Modifier.clickable { navContoller.navigate("wifi")  }
        )
        Icon(
            painter = painterResource(R.drawable.ic_baseline_home_24),
            contentDescription = "",
            modifier = Modifier.clickable { navContoller.navigate("home")  }
        )
        Icon(
            painter = painterResource(R.drawable.ic_baseline_library_music_24),
            contentDescription = "",
            modifier = Modifier.clickable { navContoller.navigate("music")  }
        )
    }
}
