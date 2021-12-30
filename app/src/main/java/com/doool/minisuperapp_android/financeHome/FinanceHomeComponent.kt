package com.doool.minisuperapp_android.financeHome

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value
import com.doool.minisuperapp_android.database.CardOnFileRepositoryImp

class FinanceHomeComponent(
  componentContext: ComponentContext
) : FinanceHome, ComponentContext by componentContext {

  private val repository = CardOnFileRepositoryImp()

  private val financeRouter = FinanceRouter(componentContext = this, repository = repository)

  override val routerState: Value<RouterState<*, FinanceHome.FinanceHomeChild>> =
    financeRouter.state
}