package com.doool.minisuperapp_android.database

interface FinanceDatabase {

  fun getBalance(): AccountBalanceEntity

  fun getPaymentMethods(): List<PaymentMethodEntity>
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

class DefaultFinanceDatabase : FinanceDatabase {

  override fun getBalance(): AccountBalanceEntity {
    return AccountBalanceEntity(10000.0)
  }

  override fun getPaymentMethods(): List<PaymentMethodEntity> {
    return listOf(
      PaymentMethodEntity(id ="0",name ="우리은행", digits= "0123", color = "#f19a38ff", isPrimary = false),
      PaymentMethodEntity(id ="1",name ="신한은행", digits= "0223", color = "#f39a38ff", isPrimary = false),
      PaymentMethodEntity(id ="2",name ="국민은행", digits= "0323", color = "#f19338ff", isPrimary = false),
      PaymentMethodEntity(id ="3",name ="삼성은행", digits= "0423", color = "#f19a26ff", isPrimary = false),
      PaymentMethodEntity(id ="4",name ="현대은행", digits= "0423", color = "#f192452f", isPrimary = false),
    )
  }
}