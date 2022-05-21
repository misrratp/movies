package poot.fausto.movie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import coil.annotation.ExperimentalCoilApi
import poot.fausto.movie.ui.theme.MyMoviesApp
import poot.fausto.movie.ui.theme.screens.detail.DetailScreen
import poot.fausto.movie.ui.theme.screens.main.MainScreen


@ExperimentalFoundationApi
@ExperimentalCoilApi
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyMoviesApp{
                //Greeting("Android")
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "main"){



                    composable("main"){
                        MainScreen(navController)


                    }
                    composable(



                        route = "detail/{mediaId}",
                        arguments = listOf(
                            navArgument("mediaId"){type = NavType.IntType}
                        )
                    ){ backStrackEntry ->
                        val id = backStrackEntry.arguments?.getInt("mediaId")
                        requireNotNull(id, {"Error de id"})
                        DetailScreen(id)
                    }
                }

            }
        }//SetContent
    }
}
