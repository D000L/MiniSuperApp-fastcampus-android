package com.doool.minisuperapp_android.database

import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import kotlin.properties.ObservableProperty

interface CardOnFileRepository {

  fun getBalance(): AccountBalanceEntity

  val paymentMethods : Value<List<PaymentMethodEntity>>

  fun addCard(info : AddPaymentInfo)
}

data class AccountBalanceEntity(
  val balance: Double
)

data class PaymentMethodEntity(
  val id: String,
  val name: String,
  val digits: String,
  val color: String,
  val isPrimary: Boolean
)

data class AddPaymentInfo(
  val number : String,
  val cvc :String,
  val expiry: String
)


class CardOnFileRepositoryImp : CardOnFileRepository {

  override fun getBalance(): AccountBalanceEntity {
    return AccountBalanceEntity(10000.0)
  }

  private val _paymentMethods = MutableValue(listOf(
    PaymentMethodEntity(id ="0",name ="우리은행", digits= "0123", color = "#f19a38ff", isPrimary = false),
    PaymentMethodEntity(id ="1",name ="신한은행", digits= "0223", color = "#f39a38ff", isPrimary = false),
    PaymentMethodEntity(id ="2",name ="국민은행", digits= "0323", color = "#f19338ff", isPrimary = false),
    PaymentMethodEntity(id ="3",name ="삼성은행", digits= "0423", color = "#f19a26ff", isPrimary = false),
    PaymentMethodEntity(id ="4",name ="현대은행", digits= "0423", color = "#f192452f", isPrimary = false),
  ))
  override val paymentMethods: Value<List<PaymentMethodEntity>> = _paymentMethods

  override fun addCard(info: AddPaymentInfo) {
    val paymentMethod = PaymentMethodEntity(id ="00",name ="New 카드", digits= info.number.dropLast(4), color = "#f19a38ff", isPrimary = false)

    val new = _paymentMethods.value + paymentMethod
    _paymentMethods.value = new
  }
}