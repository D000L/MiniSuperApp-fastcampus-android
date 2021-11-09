package com.doool.minisuperapp_android

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.arkivanov.decompose.defaultComponentContext
import com.doool.minisuperapp_android.appRoot.AppRoot
import com.doool.minisuperapp_android.appRoot.AppRootComponent
import com.doool.minisuperapp_android.financeHome.FinanceHomeComponent
import com.doool.minisuperapp_android.ui.appRoot.AppRootUI
import com.doool.minisuperapp_android.ui.financeHome.FinanceHomeUI

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    val root = AppRootComponent(defaultComponentContext())

    setContent {
      MaterialTheme() {
        Surface(color = MaterialTheme.colors.background) {
          AppRootUI(root)
        }
      }
    }
  }
}