package krv.fit.bstu.task_2_new

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import krv.fit.bstu.task_2_new.ui.theme.Task_2_newTheme
import krv.fit.bstu.task_2_new.ui.theme.bgPage1

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Task_2_newTheme {
                Surface {
                    OnboardingScreen()
                }
            }
        }
    }
}

@Composable
fun OnboardingScreen() {

    Box(
        modifier = Modifier.fillMaxSize().background(bgPage1)
    ){

        Column(horizontalAlignment = Alignment.CenterHorizontally) {


           Row {
               Text(
                   text="Your first car without a driver's license",
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
                    text = "Goes to meet people who just got their license",
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
               painter = painterResource(id = R.drawable.img_car1),
               contentDescription = "",
               modifier = Modifier.fillMaxWidth().height(458.dp)
                   .padding(top = 10.dp)
               )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier.weight(1f)
                ) {
                    PagerIndicator(size = 4, currentPage = 4)

                    Text(
                        text = "Skip",
                        fontFamily = FontFamily.Monospace,
                        color = Color.White,
                        modifier = Modifier.fillMaxWidth()
                            .padding(start = 24.dp)
                            .clickable {
                            },
                        textAlign = TextAlign.Left,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                }

                Column(
                    horizontalAlignment = Alignment.End,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.weight(1f),

                ) {
                    Button(
                        modifier = Modifier
                            .size(80.dp)
                            .padding(end = 24.dp,top = 30.dp),
                        shape = CircleShape,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                            contentColor = bgPage1
                        ),
                        onClick = {}
                    ) {
                        Icon(
                            imageVector = Icons.Filled.KeyboardArrowRight,
                            contentDescription = "Arrow Icon",
                            tint = bgPage1,
                            modifier = Modifier.width(20.dp)
                        )
                    }
                }
            }

        }
    }
}


@Composable
fun PagerIndicator(
    size: Int,
    currentPage: Int
){
    Row(
        modifier = Modifier
            .padding(top = 40.dp, start = 24.dp, bottom = 16.dp)
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

@Preview(showSystemUi = true)
@Composable
fun OnboardingScreenPreview() {
    Task_2_newTheme {
        OnboardingScreen()
    }
}