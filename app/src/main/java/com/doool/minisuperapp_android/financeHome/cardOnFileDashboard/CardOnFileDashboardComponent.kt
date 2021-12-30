package com.doool.minisuperapp_android.financeHome.cardOnFileDashboard

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.operator.map
import com.doool.minisuperapp_android.database.CardOnFileRepository
import com.doool.minisuperapp_android.financeHome.cardOnFileDashboard.CardOnFileDashboard.Model
import com.doool.minisuperapp_android.financeHome.topup.models.toPaymentMethod

class CardOnFileDashboardComponent(
  componentContext: ComponentContext,
  repository: CardOnFileRepository,
  private val showAddPaymentMethod: () -> Unit
) : CardOnFileDashboard, ComponentContext by componentContext {

  override val models: Value<Model> = repository.paymentMethods.map {
    Model(it.map { it.toPaymentMethod() })
  }

  override fun didTabAddPaymentMethod() {
    showAddPaymentMethod()
  }

  override fun didTabMore() {
    TODO("Not yet implemented")
  }
}