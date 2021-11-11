package com.doool.minisuperapp_android.financeHome.superPayDashboard

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.doool.minisuperapp_android.database.CardOnFileRepository

class SuperPayDashboardComponent(
  componentContext: ComponentContext,
  database: CardOnFileRepository,
  private val showTopup : ()->Unit
) : SuperPayDashboard, ComponentContext by componentContext {

  override val models: Value<SuperPayDashboard.Model> = MutableValue(
    SuperPayDashboard.Model(balance = database.getBalance().balance)
  )

  override fun onClickTopup() {
    showTopup()
  }
}