package com.doool.minisuperapp_android.financeHome.cardOnFileDashboard

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.doool.minisuperapp_android.database.FinanceDatabase
import com.doool.minisuperapp_android.database.PaymentMethodEntity
import com.doool.minisuperapp_android.financeHome.addPaymentMethod.AddPaymentMethod
import com.doool.minisuperapp_android.financeHome.cardOnFileDashboard.CardOnFileDashboard.Model
import com.doool.minisuperapp_android.financeHome.cardOnFileDashboard.CardOnFileDashboard.PaymentMethod

class CardOnFileDashboardComponent(
  componentContext: ComponentContext,
  database: FinanceDatabase,
  private val showAddPaymentMethod: () -> Unit
) : CardOnFileDashboard, ComponentContext by componentContext {

  override val models: Value<Model> = MutableValue(
    Model(database.getPaymentMethods().map { it.toPaymentMethod() }.take(5))
  )

  override fun didTabAddPaymentMethod() {
    showAddPaymentMethod()
  }

  private fun PaymentMethodEntity.toPaymentMethod(): PaymentMethod {
    return PaymentMethod(name, digits, color)
  }
}