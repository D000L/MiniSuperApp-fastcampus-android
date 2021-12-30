package com.doool.minisuperapp_android.ui.topup

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arkivanov.decompose.extensions.compose.jetpack.subscribeAsState
import com.doool.minisuperapp_android.financeHome.topup.enterAmount.EnterAmount
import com.doool.minisuperapp_android.financeHome.topup.enterAmount.EnterAmountComponent

@Preview
@Composable
private fun PreviewEnterAmountUI() {

}

@Composable
fun EnterAmountUI(component: EnterAmountComponent) {
  var amount by remember { mutableStateOf(0L) }
  val model by component.models.subscribeAsState()

  Column(
    modifier = Modifier
      .background(Color.White)
      .padding(10.dp)
  ) {

    Spacer(modifier = Modifier.height(8.dp))
    PaymentMethodSelect(
      paymentMethod = model.selectedPaymentMethod,
      onClickSelectPaymentMethod = component::enterAmountDidTapPaymentMethod
    )
    Spacer(modifier = Modifier.height(8.dp))
    AmountField(amount) { amount = it.toLong() }
    Spacer(modifier = Modifier.height(26.dp))
    EnterButton(onClickEnter = { component.enterAmountDidTapPaymentMethod() })
  }
}

@Composable
fun PaymentMethodSelect(
  paymentMethod: EnterAmount.SelectedPaymentMethod,
  onClickSelectPaymentMethod: () -> Unit
) {
  Row(
    Modifier
      .clickable(onClick = onClickSelectPaymentMethod)
      .fillMaxWidth()
      .height(70.dp)
      .shadow(6.dp, RoundedCornerShape(8.dp))
      .background(Color.White, RoundedCornerShape(8.dp))
      .padding(start = 20.dp, end = 22.dp),
    verticalAlignment = Alignment.CenterVertically
  ) {
    Box(
      Modifier
        .size(height = 34.dp, width = 46.dp)
        .background(
          Color(android.graphics.Color.parseColor(paymentMethod.image)),
          RoundedCornerShape(4.dp)
        )
    )
    Spacer(modifier = Modifier.width(22.dp))
    Text(text = paymentMethod.name, color = Color.Black, fontSize = 16.sp)
    Spacer(modifier = Modifier.weight(1f))
    IconButton(onClick = { /*TODO*/ }) {
      Icon(imageVector = Icons.Default.Done, contentDescription = null)
    }
  }
}

@Composable
private fun AmountField(amount: Long, updateAmount: (String) -> Unit) {
  Row(
    Modifier
      .fillMaxWidth()
      .height(80.dp)
      .shadow(6.dp, RoundedCornerShape(8.dp))
      .background(Color.White, RoundedCornerShape(8.dp))
      .padding(10.dp)
  ) {
    Text(modifier = Modifier.align(Alignment.Top), text = "금액", color = Color.Black)
    Spacer(modifier = Modifier.weight(1f))
    BasicTextField(
      modifier = Modifier.align(Alignment.Bottom),
      value = amount.toString(),
      onValueChange = updateAmount,
      textStyle = androidx.compose.ui.text.TextStyle(textAlign = TextAlign.End),
      keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
      decorationBox = { textField ->
        Row(horizontalArrangement = Arrangement.End) {
          textField()
          Text(text = "원")
        }
      }
    )
  }
}

@Composable
private fun EnterButton(onClickEnter: () -> Unit = {}) {
  TextButton(
    modifier = Modifier
      .clickable(onClick = onClickEnter)
      .height(46.dp)
      .fillMaxWidth()
      .shadow(6.dp, RoundedCornerShape(8.dp)),
    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red),
    shape = RoundedCornerShape(8.dp),
    onClick = { /*TODO*/ }) {
    Text(text = "충전", color = Color.White)
  }
}