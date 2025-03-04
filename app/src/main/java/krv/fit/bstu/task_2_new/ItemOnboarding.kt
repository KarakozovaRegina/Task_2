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
                    TextOnBoarding.text_1.value,
                    TextOnBoarding.title_1.value,
                    bgPage1
                ),
                ItemOnboarding(
                    R.drawable.img_car2,
                    TextOnBoarding.text_2.value,
                    TextOnBoarding.title_2.value,
                    bgPage2
                ),
                ItemOnboarding(
                    R.drawable.img_car3,
                    TextOnBoarding.text_3.value,
                    TextOnBoarding.title_3.value,
                    bgPage3
                ),
                ItemOnboarding(
                    R.drawable.img_car4,
                    TextOnBoarding.text_4.value,
                    TextOnBoarding.title_4.value,
                    bgPage4
                )
            )
        }
    }
}


enum class TextOnBoarding(val value: String) {

    title_1("Your first car without a driver's license"),
    title_2("Always there: more than 1000 cars in Tbilisi"),
    title_3("Do not pay for parking, maintenance and gasoline"),
    title_4("29 car models: from Skoda Octavia to Porsche 911"),
    text_1("Goes to meet people who just got their license"),
    text_2("Our company is a leader by the number of cars in the fleet"),
    text_3("We will pay for you, all expenses related to the car"),
    text_4("Choose between regular car models or exclusive ones"),
}