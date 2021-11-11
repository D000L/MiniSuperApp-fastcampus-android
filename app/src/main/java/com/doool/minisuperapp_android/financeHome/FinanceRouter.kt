package com.doool.minisuperapp_android.financeHome

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.push
import com.arkivanov.decompose.router.router
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import com.doool.minisuperapp_android.database.CardOnFileRepository
import com.doool.minisuperapp_android.financeHome.addPaymentMethod.AddPaymentMethodComponent
import com.doool.minisuperapp_android.financeHome.cardOnFileDashboard.CardOnFileDashboardComponent
import com.doool.minisuperapp_android.financeHome.superPayDashboard.SuperPayDashboardComponent

class FinanceRouter(
  componentContext: ComponentContext,
  private val database: CardOnFileRepository
) {

  private val router =
    componentContext.router<Config, FinanceHome.FinanceHomeChild>(
      initialConfiguration = Config.Home,
      key = "FinanceRouter",
      childFactory = ::createChild,
      handleBackButton = true
    )

  val state: Value<RouterState<Config, FinanceHome.FinanceHomeChild>> = router.state

  private fun createChild(
    config: Config,
    componentContext: ComponentContext
  ): FinanceHome.FinanceHomeChild =
    when (config) {
      Config.Home -> FinanceHome.FinanceHomeChild.Home(
        getSuperPayDashboard(componentContext),
        getCardOnFileDashboard(componentContext)
      )
      Config.AddPayment -> FinanceHome.FinanceHomeChild.AddPayment(
        getAddPaymentMethod(
          componentContext
        )
      )
    }

  private fun getAddPaymentMethod(componentContext: ComponentContext) =
    AddPaymentMethodComponent(
      componentContext,
      { number: String, cvc: String, expiry: String ->
        database
      },
      {})

  private fun getSuperPayDashboard(componentContext: ComponentContext) =
    SuperPayDashboardComponent(componentContext, database, {})

  private fun getCardOnFileDashboard(componentContext: ComponentContext) =
    CardOnFileDashboardComponent(componentContext, database) {
      router.push(Config.AddPayment)
    }

  sealed class Config : Parcelable {

    @Parcelize
    object Home : Config()

    @Parcelize
    object AddPayment : Config()
  }
}