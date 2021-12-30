package com.doool.minisuperapp_android.ui.financeHome

import android.widget.Space
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.jetpack.Children
import com.arkivanov.decompose.extensions.compose.jetpack.animation.child.slide
import com.arkivanov.decompose.extensions.compose.jetpack.subscribeAsState
import com.doool.minisuperapp_android.financeHome.FinanceHome

@OptIn(ExperimentalDecomposeApi::class)
@Composable
fun FinanceHomeUI(component: FinanceHome) {
  val router by component.routerState.subscribeAsState()

  Children(routerState = router, animation = slide()) {
    when (val child = it.instance) {
      is FinanceHome.FinanceHomeChild.Home -> FinanceHomeDashboardUI(child)
      is FinanceHome.FinanceHomeChild.AddPayment -> AddPaymentMethodUI(child.component)
      is FinanceHome.FinanceHomeChild.Topup -> TopupUI(child.component)
    }
  }
}

@Composable
fun FinanceHomeDashboardUI(component: FinanceHome.FinanceHomeChild.Home) {
  Column(Modifier.verticalScroll(rememberScrollState())) {
    SuperPayDashboardUI(component = component.superPayDashboard)
    Spacer(Modifier.height(20.dp))
    CardOnFileDashboardUI(component = component.cardOnFileDashboard)
  }
}
