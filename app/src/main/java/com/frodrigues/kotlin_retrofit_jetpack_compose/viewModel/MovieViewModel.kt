package com.frodrigues.kotlin_retrofit_jetpack_compose.viewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.frodrigues.kotlin_retrofit_jetpack_compose.network.ApiService
import com.frodrigues.kotlin_retrofit_jetpack_compose.network.model.Movie
import kotlinx.coroutines.launch

class MovieViewModel: ViewModel() {
    var movieListResponse:List<Movie> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")
    fun getMovieList() {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
                val movieList = apiService.getMovies()
                movieListResponse = movieList
                Log.d("Movie", movieListResponse.toString())
            }
            catch (e: Exception) {
                errorMessage = e.message.toString()
                Log.d("Ops -> erro : ", errorMessage.toString())
            }
        }
    }
}