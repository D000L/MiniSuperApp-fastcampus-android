package com.doool.minisuperapp_android.financeHome.topup

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.*
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import com.doool.minisuperapp_android.database.AddPaymentInfo
import com.doool.minisuperapp_android.database.CardOnFileRepository
import com.doool.minisuperapp_android.financeHome.addPaymentMethod.AddPaymentMethodComponent
import com.doool.minisuperapp_android.financeHome.topup.cardOnFile.CardOnFileComponent
import com.doool.minisuperapp_android.financeHome.topup.enterAmount.EnterAmountComponent
import com.doool.minisuperapp_android.financeHome.topup.models.PaymentMethod

class TopupRouter(
  componentContext: ComponentContext,
  private val repository: CardOnFileRepository,
  private val selectedPaymentMethod: MutableValue<PaymentMethod>
) {

  private fun getInitConfig() = repository.paymentMethods.value.firstOrNull()?.let {
    Config.EnterAmount
  } ?: Config.AddPaymentMethod

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
      Config.CardOnFile -> Topup.TopupChild.CardOnFile(
        getCardOnFile(
          componentContext
        )
      )
    }

  private fun getAddPaymentMethod(componentContext: ComponentContext) =
    AddPaymentMethodComponent(
      componentContext,
      { number: String, cvc: String, expiry: String ->
        val newCard = AddPaymentInfo(number, cvc, expiry)
        repository.addCard(newCard)
        selectedPaymentMethod.value = PaymentMethod("새 카드", "0101", "#fff241ff")

        router.popWhile { it != Config.EnterAmount }
      },
      {})

  private fun getEnterAmount(componentContext: ComponentContext) =
    EnterAmountComponent(componentContext, repository, selectedPaymentMethod) {
      router.push(Config.CardOnFile)
    }

  private fun getCardOnFile(componentContext: ComponentContext) =
    CardOnFileComponent(componentContext, repository, {
      router.push(Config.AddPaymentMethod)
    }, {
      selectedPaymentMethod.value = it
      router.pop()
    })


  sealed class Config : Parcelable {

    @Parcelize
    object EnterAmount : Config()

    @Parcelize
    object AddPaymentMethod : Config()

    @Parcelize
    object CardOnFile : Config()
  }

}
