package com.doool.minisuperapp_android.financeHome.topup

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.doool.minisuperapp_android.database.CardOnFileRepositoryImp
import com.doool.minisuperapp_android.financeHome.cardOnFileDashboard.CardOnFileDashboard

class TopupComponent(
  componentContext: ComponentContext
) : Topup, ComponentContext by componentContext {

  private val repository = CardOnFileRepositoryImp()
  private val selectedPaymentMethod = MutableValue(CardOnFileDashboard.PaymentMethod("",",",""))
  private val topupRouter = TopupRouter(componentContext = this, repository = repository, selectedPaymentMethod)

  override val routerState: Value<RouterState<*, Topup.TopupChild>> = topupRouter.state
}