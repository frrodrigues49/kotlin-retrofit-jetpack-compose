package com.frodrigues.kotlin_retrofit_jetpack_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.frodrigues.kotlin_retrofit_jetpack_compose.network.model.Movie
import com.frodrigues.kotlin_retrofit_jetpack_compose.ui.theme.KotlinretrofitjetpackcomposeTheme
import com.frodrigues.kotlin_retrofit_jetpack_compose.view.MovieItem
import com.frodrigues.kotlin_retrofit_jetpack_compose.viewModel.MovieViewModel

class MainActivity : ComponentActivity() {

    private val movieViewModel by viewModels<MovieViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinretrofitjetpackcomposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MovieList(movieList = movieViewModel.movieListResponse)
                    movieViewModel.getMovieList()

                }
            }
        }
    }
}

@Composable
fun MovieList(movieList: List<Movie>) {
    LazyColumn {
        itemsIndexed(items = movieList) { _, item ->
            MovieItem(movie = item)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    KotlinretrofitjetpackcomposeTheme {
        val movie = Movie(
            "Coco",
            "https://howtodoandroid.com/images/coco.jpg",
            "Coco is a 2017 American 3D computer-animated musical fantasy adventure film produced by Pixar",
            "Latest"
        )

        MovieItem(movie = movie )
    }
}