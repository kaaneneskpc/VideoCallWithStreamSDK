package com.example.videoappwithstreamsdk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.videoappwithstreamsdk.connect.ConnectScreen
import com.example.videoappwithstreamsdk.connect.ConnectViewModel
import com.example.videoappwithstreamsdk.ui.theme.VideoAppWithStreamSDKTheme
import com.example.videoappwithstreamsdk.video.CallState
import com.example.videoappwithstreamsdk.video.VideoCallScreen
import com.example.videoappwithstreamsdk.video.VideoCallViewModel
import io.getstream.video.android.compose.theme.VideoTheme
import org.koin.androidx.compose.koinViewModel
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VideoAppWithStreamSDKTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = ConnectRoute,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable<ConnectRoute> {
                            val viewModel = koinViewModel<ConnectViewModel>()
                            val state = viewModel.state

                            LaunchedEffect(key1 = state.isConnected) {
                                if(state.isConnected) {
                                    navController.navigate(VideoCallRoute) {
                                        popUpTo(ConnectRoute) {
                                            inclusive = true
                                        }
                                    }
                                }
                            }

                            ConnectScreen(state = state, onAction = viewModel::onAction)
                        }
                        composable<VideoCallRoute> {
                            val viewModel = koinViewModel<VideoCallViewModel>()
                            val state = viewModel.state

                            LaunchedEffect(key1 = state.callState) {
                                if(state.callState == CallState.ENDED) {
                                    navController.navigate(ConnectRoute) {
                                        popUpTo(VideoCallRoute) {
                                            inclusive = true
                                        }
                                    }
                                }
                            }

                            VideoTheme {
                                VideoCallScreen(state = state, onAction = viewModel::onAction)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Serializable
data object ConnectRoute

@Serializable
data object VideoCallRoute