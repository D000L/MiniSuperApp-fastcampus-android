package com.doool.minisuperapp_android.financeHome.topup

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.router
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import com.doool.minisuperapp_android.database.AddPaymentInfo
import com.doool.minisuperapp_android.database.CardOnFileRepository
import com.doool.minisuperapp_android.financeHome.addPaymentMethod.AddPaymentMethodComponent
import com.doool.minisuperapp_android.financeHome.cardOnFileDashboard.CardOnFileDashboard
import com.doool.minisuperapp_android.financeHome.topup.enterAmount.EnterAmountComponent

class TopupRouter(
  componentContext: ComponentContext,
  private val repository: CardOnFileRepository,
  private val selectedPaymentMethod: MutableValue<CardOnFileDashboard.PaymentMethod>
) {

  private fun getInitConfig() = repository.paymentMethods.value.firstOrNull()?.let{
      Config.EnterAmount
    } ?: Config.EnterAmount

  private val router =
    componentContext.router<Config, Topup.TopupChild>(
      initialConfiguration = getInitConfig(),
      key = "TopupRouter",
      childFactory = ::createChild,
      handleBackButton = true
    )

  val state: Value<RouterState<Config, Topup.TopupChild>> = router.state

  private fun createChild(
    config: Config,
    componentContext: ComponentContext
  ): Topup.TopupChild =
    when (config) {
      Config.AddPaymentMethod -> Topup.TopupChild.AddPaymentMethod(
        getAddPaymentMethod(componentContext),
      )
      Config.EnterAmount -> Topup.TopupChild.EnterAmount(
        getEnterAmount(
          componentContext
        )
      )
    }

  private fun getAddPaymentMethod(componentContext: ComponentContext) =
    AddPaymentMethodComponent(
      componentContext,
      { number: String, cvc: String, expiry: String ->
        repository.addCard(AddPaymentInfo(number, cvc, expiry))
      },
      {})

  private fun getEnterAmount(componentContext: ComponentContext) =
    EnterAmountComponent(componentContext, repository, selectedPaymentMethod)


  sealed class Config : Parcelable {

    @Parcelize
    object EnterAmount : Config()

    @Parcelize
    object AddPaymentMethod : Config()
  }

}
