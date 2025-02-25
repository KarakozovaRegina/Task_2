package krv.fit.bstu.task_2_new

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class onboardingViewModel: ViewModel() {

    // инкапсуляция
    private var _currentPage = MutableStateFlow(0)
    val currentPage = _currentPage.value

    fun setCurrentPage(currentPage: Int){

        _currentPage.value = currentPage
    }
}