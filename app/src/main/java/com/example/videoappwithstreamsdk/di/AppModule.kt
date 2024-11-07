package com.example.videoappwithstreamsdk.di

import com.example.videoappwithstreamsdk.VideoCallingApp
import com.example.videoappwithstreamsdk.connect.ConnectViewModel
import com.example.videoappwithstreamsdk.video.VideoCallViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module


val appModule = module {
    factory {
        val app = androidContext().applicationContext as VideoCallingApp
        app.client
    }

    viewModelOf(::ConnectViewModel)
    viewModelOf(::VideoCallViewModel)
}