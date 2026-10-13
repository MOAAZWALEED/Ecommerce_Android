package com.route.ecommerce.c19_mobile_track.GMonThu


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.route.ecommerce.c19_mobile_track.GMonThu.ui.navigation.AppRoutes
import com.route.ecommerce.c19_mobile_track.GMonThu.ui.screens.HomeScreen
import com.route.ecommerce.c19_mobile_track.GMonThu.ui.theme.EcommerceTheme

class EcommerceActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EcommerceTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = AppRoutes.Home,
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                        ) {
                        composable<AppRoutes.Home> {
                            HomeScreen()
                        }
                        composable<AppRoutes.AuthDestination.Login> {
                        }
                    }
                }
            }
        }
    }
}



