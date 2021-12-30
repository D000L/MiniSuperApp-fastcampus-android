package com.doool.minisuperapp_android.ui.financeHome

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
import com.doool.minisuperapp_android.financeHome.topup.enterAmount.EnterAmountComponent

@Preview
@Composable
private fun PreviewEnterAmountUI() {

}

@Composable
fun EnterAmountUI(component: EnterAmountComponent) {
  var amount by remember { mutableStateOf(0L) }

  Column(
    modifier = Modifier
      .background(Color.White)
      .padding(10.dp)
  ) {

    Spacer(modifier = Modifier.height(8.dp))
    PaymentMethodSelect(onClickSelectPaymentMethod = component::enterAmountDidTapPaymentMethod)
    Spacer(modifier = Modifier.height(8.dp))
    AmountField(amount) { amount = it.toLong() }
    Spacer(modifier = Modifier.height(26.dp))
    EnterButton(onClickEnter = { component.enterAmountDidTapPaymentMethod() })
  }
}

@Composable
fun PaymentMethodSelect(onClickSelectPaymentMethod: () -> Unit) {
  Row(
    Modifier
      .clickable(onClick = onClickSelectPaymentMethod)
      .fillMaxWidth()
      .height(46.dp)
      .shadow(6.dp, RoundedCornerShape(8.dp))
      .background(Color.White, RoundedCornerShape(8.dp))
      .padding(10.dp),
    verticalAlignment = Alignment.CenterVertically
  ) {
    Box(
      Modifier
        .size(height = 20.dp, width = 34.dp)
        .background(Color.White, RoundedCornerShape(4.dp))
    )
    Spacer(modifier = Modifier.width(6.dp))
    Text(text = "우리은행 0123")
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
    Text(modifier = Modifier.align(Alignment.Top), text = "금액")
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