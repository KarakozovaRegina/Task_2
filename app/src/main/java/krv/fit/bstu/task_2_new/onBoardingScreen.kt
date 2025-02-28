package krv.fit.bstu.task_2_new

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import krv.fit.bstu.task_2.ItemOnboarding
import krv.fit.bstu.task_2_new.ui.theme.bgPage4


@Composable
fun OnboardingScreen(
    itemOnboarding: ItemOnboarding,
    currentPage: Int,
    onSkipClick: () -> Unit = {},
    onNextClick: () -> Unit = {}) {

    if(currentPage == 4){
        FinishedPage()
    }else{
        Box(
            modifier = Modifier.fillMaxSize().background(itemOnboarding.bgColor),
        ){

            Column(horizontalAlignment = Alignment.CenterHorizontally) {


                Row {
                    Text(
                        text= itemOnboarding.title,
                        fontFamily = FontFamily.Monospace,
                        modifier = Modifier.fillMaxWidth()
                            .padding(start = 24.dp, end = 24.dp, top = 83.dp),
                        textAlign = TextAlign.Left,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )
                }
                Row {
                    Text(
                        text = itemOnboarding.text,
                        fontFamily = FontFamily.Monospace,
                        modifier = Modifier.fillMaxWidth()
                            .padding(start = 24.dp, top = 20.dp, end = 24.dp, bottom = 65.dp),
                        textAlign = TextAlign.Left,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.White
                    )
                }
                Image(
                    painter = painterResource(id = itemOnboarding.img),
                    contentDescription = "",
                    modifier = Modifier.fillMaxWidth().height(480.dp)
                        .padding(top = 10.dp)
                )

                BottomSection(onSkipClick, onNextClick,itemOnboarding, currentPage)

            }
        }
    }

}


@Composable
fun BottomSection(
    onSkipClick: () -> Unit = {},
    onNextClick: () -> Unit = {},
    itemOnboarding: ItemOnboarding,
    currentPage: Int,
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ){
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {

            Column(modifier = Modifier.weight(1f)){

                PagerIndicator(4, currentPage)
                TextButton(
                    onClick = onSkipClick,
                ) {
                    Text(
                        text = "Skip",
                        fontFamily = FontFamily.Monospace,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.White)
                }
            }


            FloatingActionButton(
                onNextClick,
                modifier = Modifier.padding(end = 12.dp, top=6.dp),
                shape = CircleShape,
                containerColor = Color.White,
                elevation = FloatingActionButtonDefaults.elevation(0.dp)
                ) {
                Icon(
                    Icons.Filled.KeyboardArrowRight,
                    contentDescription = "Next",
                    tint = itemOnboarding.bgColor)
            }
        }

    }

}
@Composable
fun PagerIndicator(size: Int, currentPage: Int){
    Row(
        modifier = Modifier
            .padding(top = 22.dp, start = 12.dp, bottom = 10.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Start
    ) {
        repeat(size){
            IndicatorIcon(isSelected = it == currentPage)
        }
    }
}

@Composable
fun IndicatorIcon(isSelected: Boolean){

    val width = animateDpAsState(
        targetValue = if(isSelected) 25.dp else 10.dp
    )

    Box(
        modifier = Modifier
            .padding(2.dp)
            .height(10.dp)
            .width(width.value)
            .clip(CircleShape)
            .background(
                if(isSelected){
                    Color.White
                }else{
                    Color.White.copy(alpha = 0.4f)
                }
            )
    )
}


@Composable
fun  FinishedPage(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(bgPage4),
    )
    {
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ){
            Text(
                text = "You are a clever person!",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontFamily = FontFamily.Monospace
            )
        }
    }
}