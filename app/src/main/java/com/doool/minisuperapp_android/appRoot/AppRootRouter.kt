package com.doool.minisuperapp_android.appRoot

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.replaceCurrent
import com.arkivanov.decompose.router.router
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import com.doool.minisuperapp_android.appHome.AppHomeComponent
import com.doool.minisuperapp_android.financeHome.FinanceHomeComponent

class AppRootRouter(
  componentContext: ComponentContext
) {

  private val router =
    componentContext.router<Config, AppRoot.AppRootChild>(
      initialConfiguration = Config.Home,
      key = "AppRootRouter",
      childFactory = ::createChild
    )

  val state: Value<RouterState<Config, AppRoot.AppRootChild>> = router.state

  private fun createChild(
    config: Config,
    componentContext: ComponentContext
  ): AppRoot.AppRootChild =
    when (config.tab) {
      AppRoot.Tab.Home -> AppRoot.AppRootChild.Home(AppHomeComponent(componentContext))
      AppRoot.Tab.FinanceHome -> AppRoot.AppRootChild.FinanceHome(
        FinanceHomeComponent(
          componentContext
        )
      )
    }

  fun changeTab(tab: AppRoot.Tab) {
    val next = when (tab) {
      AppRoot.Tab.Home -> Config.Home
      AppRoot.Tab.FinanceHome -> Config.FinanceHome
    }
    if (router.state.value.activeChild.configuration != next) router.replaceCurrent(next)
  }

  sealed class Config(val tab: AppRoot.Tab) : Parcelable {

    @Parcelize
    object Home : Config(AppRoot.Tab.Home)

    @Parcelize
    object FinanceHome : Config(AppRoot.Tab.FinanceHome)
  }
}
