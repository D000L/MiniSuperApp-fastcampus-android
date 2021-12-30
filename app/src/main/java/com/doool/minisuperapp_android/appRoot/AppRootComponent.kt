package com.doool.minisuperapp_android.appRoot

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value

class AppRootComponent(
  componentContext: ComponentContext
) : AppRoot, ComponentContext by componentContext {

  override val models: MutableValue<AppRoot.Model> = MutableValue(AppRoot.Model(AppRoot.Tab.Home))

  private val appHomeRouter = AppRootRouter(componentContext = this)

  override val routerState: Value<RouterState<*, AppRoot.AppRootChild>> = appHomeRouter.state

  override fun changeTab(tab: AppRoot.Tab) {
    models.value = AppRoot.Model(tab)
    appHomeRouter.changeTab(tab)
  }
}
