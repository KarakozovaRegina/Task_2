package krv.fit.bstu.task_2_new.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import krv.fit.bstu.task_2_new.HomePage
import krv.fit.bstu.task_2_new.PagerContent

@ExperimentalFoundationApi
@Composable
fun Navigation() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.Onboarding.route) {

        composable(Routes.Onboarding.route) { PagerContent(navController) }
        composable(Routes.Home.route) { HomePage()  }
    }
}