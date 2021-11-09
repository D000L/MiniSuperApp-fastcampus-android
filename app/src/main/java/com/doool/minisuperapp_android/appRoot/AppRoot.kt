package com.doool.minisuperapp_android.appRoot

import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value
import com.doool.minisuperapp_android.appHome.AppHome
import com.doool.minisuperapp_android.financeHome.FinanceHomeComponent

interface AppRoot {

  val models: Value<Model>

  val routerState: Value<RouterState<*, AppRootChild>>

  fun changeTab(tab: Tab)

  enum class Tab {
    Home, FinanceHome
  }

  class Model(
    val tab: Tab
  )

  sealed class AppRootChild {
    class Home(val component: AppHome) : AppRootChild()
    class FinanceHome(val component: FinanceHomeComponent) : AppRootChild()
  }
}