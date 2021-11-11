package com.doool.minisuperapp_android.financeHome.cardOnFileDashboard

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.operator.map
import com.doool.minisuperapp_android.database.CardOnFileRepository
import com.doool.minisuperapp_android.database.PaymentMethodEntity
import com.doool.minisuperapp_android.financeHome.cardOnFileDashboard.CardOnFileDashboard.Model
import com.doool.minisuperapp_android.financeHome.cardOnFileDashboard.CardOnFileDashboard.PaymentMethod
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

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

  private fun PaymentMethodEntity.toPaymentMethod(): PaymentMethod {
    return PaymentMethod(name, digits, color)
  }
}