package com.doool.minisuperapp_android.ui.financeHome

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetpack.Children
import com.arkivanov.decompose.extensions.compose.jetpack.subscribeAsState
import com.doool.minisuperapp_android.financeHome.FinanceHome

@Composable
fun FinanceHomeUI(component: FinanceHome) {
  val router by component.routerState.subscribeAsState()

  Children(routerState = router) {
    when (val child = it.instance) {
      is FinanceHome.FinanceHomeChild.Home -> FinanceHomeDashboardUI(child)
      is FinanceHome.FinanceHomeChild.AddPayment -> AddPaymentMethodUI(child.component)
    }
  }
}

@Composable
fun FinanceHomeDashboardUI(component: FinanceHome.FinanceHomeChild.Home) {
  Column(Modifier.verticalScroll(rememberScrollState())) {
    SuperPayDashboardUI(component = component.superPayDashboard)
    CardOnFileDashboardUI(component = component.cardOnFileDashboard)
  }
}
