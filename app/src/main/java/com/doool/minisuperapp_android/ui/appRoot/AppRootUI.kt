package com.doool.minisuperapp_android.ui.appRoot

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
          unselectedContentColor = Color.LightGray,
          selectedContentColor = Color.Black,
          selected = model.tab == it,
          onClick = { component.changeTab(it) },
          icon = {
            val icon = when (it) {
              AppRoot.Tab.Home -> Icons.Default.Home
              AppRoot.Tab.FinanceHome -> Icons.Default.AccountBox
              AppRoot.Tab.Profile -> Icons.Default.Person
            }
            Icon(imageVector = icon, contentDescription = null)
          }, label = {
            Text(text = it.label, fontSize = 10.sp)
          })
      }
    }
  }) { paddingValues ->
    Children(routerState = router) {
      Box(Modifier.padding(bottom = paddingValues.calculateBottomPadding())) {
        when (val child = it.instance) {
          is AppRoot.AppRootChild.FinanceHome -> FinanceHomeUI(child.component)
          is AppRoot.AppRootChild.Home -> AppHomeUI(child.component)
          AppRoot.AppRootChild.Profile -> ProfileUI()
        }
      }
    }
  }
}

@Composable
private fun ProfileUI() {

}
