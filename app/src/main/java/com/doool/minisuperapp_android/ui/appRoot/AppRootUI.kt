package com.doool.minisuperapp_android.ui.appRoot

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.extensions.compose.jetpack.Children
import com.arkivanov.decompose.extensions.compose.jetpack.subscribeAsState
import com.doool.minisuperapp_android.appRoot.AppRoot
import com.doool.minisuperapp_android.ui.appHome.AppHomeUI
import com.doool.minisuperapp_android.ui.financeHome.FinanceHomeUI

@Composable
fun AppRootUI(component: AppRoot) {
  val model by component.models.subscribeAsState()
  val router by component.routerState.subscribeAsState()

  Scaffold(bottomBar = {
    BottomNavigation {
      AppRoot.Tab.values().forEach {
        BottomNavigationItem(
          selected = model.tab == it,
          onClick = { component.changeTab(it) },
          icon = {
            Icon(imageVector = Icons.Default.Home, contentDescription = null)
          })
      }
    }
  }) {
    Children(routerState = router) {
      when (val child = it.instance) {
        is AppRoot.AppRootChild.FinanceHome -> FinanceHomeUI(child.component)
        is AppRoot.AppRootChild.Home -> AppHomeUI(child.component)
      }
    }
  }
}