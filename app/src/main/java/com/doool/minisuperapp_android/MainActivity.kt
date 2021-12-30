package com.doool.minisuperapp_android

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.graphics.Color
import com.arkivanov.decompose.defaultComponentContext
import com.doool.minisuperapp_android.appRoot.AppRootComponent
import com.doool.minisuperapp_android.financeHome.topup.TopupComponent
import com.doool.minisuperapp_android.ui.appRoot.AppRootUI
import com.doool.minisuperapp_android.ui.financeHome.TopupUI

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    val root = AppRootComponent(defaultComponentContext())
//    val topup = TopupComponent(defaultComponentContext())
    setContent {
      MaterialTheme(
        colors = MaterialTheme.colors.copy(
          background = Color.White,
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