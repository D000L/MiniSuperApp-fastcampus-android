package com.doool.minisuperapp_android

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.graphics.Color
import com.arkivanov.decompose.defaultComponentContext
import com.doool.minisuperapp_android.appRoot.AppRootComponent
import com.doool.minisuperapp_android.ui.appRoot.AppRootUI

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    val root = AppRootComponent(defaultComponentContext())
//    val topup = TopupComponent(defaultComponentContext())
    setContent {
      MaterialTheme(
        colors = MaterialTheme.colors.copy(
          background = Color(red = 0.95f, green = 0.96f, blue = 0.98f, alpha = 1f),
          primary = Color.White,
          onPrimary = Color.LightGray,
        )
      ) {
        Surface(color = MaterialTheme.colors.background) {
          AppRootUI(root)
//          TopupUI(topup)
        }
      }
    }
  }
}