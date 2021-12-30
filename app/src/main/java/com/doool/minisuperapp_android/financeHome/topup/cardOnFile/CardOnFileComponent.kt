package com.doool.minisuperapp_android.financeHome.topup.cardOnFile

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.operator.map
import com.doool.minisuperapp_android.database.CardOnFileRepository
import com.doool.minisuperapp_android.financeHome.topup.models.PaymentMethod
import com.doool.minisuperapp_android.financeHome.topup.models.toPaymentMethod

class CardOnFileComponent(
  componentContext: ComponentContext,
  private val repository: CardOnFileRepository,
  private val showAddPaymentMethod : () -> Unit,
  private val selectPaymentMethod: (PaymentMethod) -> Unit
) : CardOnFile, ComponentContext by componentContext {

  override val models: Value<CardOnFile.Model> = repository.paymentMethods.map {
    CardOnFile.Model(it.map { it.toPaymentMethod() })
  }

  override fun cardOnFileDidTapAddCard() {
    showAddPaymentMethod()
  }

  override fun cardOnFileDidSelect(paymentMethod: PaymentMethod) {
    selectPaymentMethod(paymentMethod)
  }

  override fun cardOnFileDidTapClose() {
    TODO("Not yet implemented")
  }
}