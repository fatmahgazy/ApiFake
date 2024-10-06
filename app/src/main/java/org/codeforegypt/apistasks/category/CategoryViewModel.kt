package org.codeforegypt.apistasks.category
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.codeforegypt.apistasks.domain.Repositry


class CategoryViewModel: ViewModel() {
    private val repo = Repositry()

    private val _state = mutableStateOf(CategoryState())
     var state: State<CategoryState> = _state

    init {
        getAllCategory()
    }

    private fun getAllCategory(){
        viewModelScope.launch {
            val response = repo.getAllCategory()
            _state.value = state.value.copy(
                category = response
            )
        }


    }


}