package krv.fit.bstu.task_2_new

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.ExperimentalFoundationApi
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
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.paging.Pager
import kotlinx.coroutines.launch
import krv.fit.bstu.task_2.ItemOnboarding
import krv.fit.bstu.task_2.getList
import krv.fit.bstu.task_2_new.navigation.Navigation
import krv.fit.bstu.task_2_new.ui.theme.Task_2_newTheme
import krv.fit.bstu.task_2_new.ui.theme.bgPage1
import krv.fit.bstu.task_2_new.ui.theme.bgPage2
import krv.fit.bstu.task_2_new.ui.theme.bgPage3
import krv.fit.bstu.task_2_new.ui.theme.bgPage4

@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Navigation()
        }
    }
}




@ExperimentalFoundationApi
@Composable
fun PagerContent(navController: NavController){

    Column(modifier = Modifier.fillMaxSize()) {

        val items = getList()
        val scope = rememberCoroutineScope()
        val pageState = rememberPagerState(
            pageCount = { items.size },
            initialPage = 0
        )


        OnboardingPage(
            items = items,
            pageState = pageState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),

            onSkipClick = {
                if (pageState.currentPage + 1 > 1) scope.launch {
                    pageState.scrollToPage(pageState.currentPage - 1)
                }
            },

            onNextClick = {
                if (pageState.currentPage + 1 < items.size) scope.launch {
                    pageState.scrollToPage(pageState.currentPage + 1)
                }
            },
            navController


        )



    }
}




@ExperimentalFoundationApi
@Composable
fun OnboardingPage(
    items: List<ItemOnboarding>,
    pageState: PagerState,
    modifier: Modifier = Modifier,
    onSkipClick: () -> Unit = {},
    onNextClick: () -> Unit = {},
    navController: NavController
){
    Box(
        modifier = modifier)
    {
        Column {

            HorizontalPager(state = pageState) {
                page ->
                val curentPage: Int = page
                OnboardingScreen(items[page], curentPage, onSkipClick, onNextClick, navController,pageState)
            }
        }
    }
}

@ExperimentalFoundationApi
@Preview(showSystemUi = true)
@Composable
fun OnboardingScreenPreview() {
    Task_2_newTheme {

    }
}


