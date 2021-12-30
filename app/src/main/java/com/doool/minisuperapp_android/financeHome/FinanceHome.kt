package com.doool.minisuperapp_android.financeHome

import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value
import com.doool.minisuperapp_android.financeHome.addPaymentMethod.AddPaymentMethod
import com.doool.minisuperapp_android.financeHome.cardOnFileDashboard.CardOnFileDashboard
import com.doool.minisuperapp_android.financeHome.superPayDashboard.SuperPayDashboard
import com.doool.minisuperapp_android.financeHome.topup.TopupComponent

interface FinanceHome {

  val routerState: Value<RouterState<*, FinanceHomeChild>>

  sealed class FinanceHomeChild {
    class Home(
      val superPayDashboard: SuperPayDashboard,
      val cardOnFileDashboard: CardOnFileDashboard
    ) : FinanceHomeChild()

    class AddPayment(val component: AddPaymentMethod) : FinanceHomeChild()

    class Topup(val component: TopupComponent) : FinanceHomeChild()
  }
}