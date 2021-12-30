package com.doool.minisuperapp_android.financeHome.topup

import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value
import com.doool.minisuperapp_android.financeHome.addPaymentMethod.AddPaymentMethodComponent
import com.doool.minisuperapp_android.financeHome.topup.enterAmount.EnterAmountComponent

interface Topup {

  val routerState: Value<RouterState<*, TopupChild>>

  sealed class TopupChild {
    class AddPaymentMethod(val component: AddPaymentMethodComponent) : TopupChild()
    class EnterAmount(val component: EnterAmountComponent) : TopupChild()
  }
}