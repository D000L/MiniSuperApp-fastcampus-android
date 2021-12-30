package com.doool.minisuperapp_android.ui.financeHome

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.jetpack.Children
import com.arkivanov.decompose.extensions.compose.jetpack.animation.child.slide
import com.arkivanov.decompose.extensions.compose.jetpack.subscribeAsState
import com.doool.minisuperapp_android.financeHome.topup.Topup
import com.doool.minisuperapp_android.financeHome.topup.TopupComponent

@OptIn(ExperimentalDecomposeApi::class)
@Composable
fun TopupUI(component: TopupComponent) {
  val router by component.routerState.subscribeAsState()

  Children(routerState = router, animation = slide()) {
    when (val child = it.instance) {
      is Topup.TopupChild.AddPaymentMethod -> AddPaymentMethodUI(child.component)
      is Topup.TopupChild.EnterAmount -> EnterAmountUI(child.component)
    }
  }
}
