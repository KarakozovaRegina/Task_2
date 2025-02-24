package krv.fit.bstu.task_2_new

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import krv.fit.bstu.task_2_new.ui.theme.Task_2_newTheme

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

}

@Preview(showSystemUi = true)
@Composable
fun OnboardingScreenPreview() {
    Task_2_newTheme {
        OnboardingScreen()
    }
}