package krv.fit.bstu.task_2

import androidx.compose.ui.graphics.Color
import krv.fit.bstu.task_2_new.R
import krv.fit.bstu.task_2_new.ui.theme.bgPage1
import krv.fit.bstu.task_2_new.ui.theme.bgPage2
import krv.fit.bstu.task_2_new.ui.theme.bgPage3
import krv.fit.bstu.task_2_new.ui.theme.bgPage4

data class ItemOnboarding(
    val img: Int,
    val title: String,
    val text: String,
    val bgColor: Color
){

    companion object{

        fun getList(): List<ItemOnboarding>{
            return listOf(
                ItemOnboarding(
                    R.drawable.img_car1,
                    "Your first car without a driver's license",
                    "Goes to meet people who just got their license",
                    bgPage1
                ),
                ItemOnboarding(
                    R.drawable.img_car2,
                    "Always there: more than 1000 cars in Tbilisi",
                    "Our company is a leader by the number of cars in the fleet",
                    bgPage2
                ),
                ItemOnboarding(
                    R.drawable.img_car3,
                    "Do not pay for parking, maintenance and gasoline",
                    "We will pay for you, all expenses related to the car",
                    bgPage3
                ),
                ItemOnboarding(
                    R.drawable.img_car4,
                    "29 car models: from Skoda Octavia to Porsche 911",
                    "Choose between regular car models or exclusive ones",
                    bgPage4
                ),
                ItemOnboarding(
                    R.drawable.img_car4,
                    "",
                    "",
                    bgPage4
                )
            )
        }
    }
}


