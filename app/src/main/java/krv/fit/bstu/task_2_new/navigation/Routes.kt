package krv.fit.bstu.task_2_new.navigation

sealed class Routes(val route: String) {

    object Onboarding : Routes("onboarding")
    object Home : Routes("home")
}
