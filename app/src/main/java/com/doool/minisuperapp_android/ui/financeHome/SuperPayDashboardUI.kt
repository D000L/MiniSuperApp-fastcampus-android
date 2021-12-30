package com.doool.minisuperapp_android.ui.financeHome

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arkivanov.decompose.extensions.compose.jetpack.subscribeAsState
import com.doool.minisuperapp_android.financeHome.superPayDashboard.SuperPayDashboard

@Composable
fun SuperPayDashboardUI(component: SuperPayDashboard) {
  val model by component.models.subscribeAsState()

  Column(Modifier.padding(horizontal = 20.dp)) {
    Spacer(modifier = Modifier.height(12.dp))
    Header(component::onClickTopup)
    Spacer(modifier = Modifier.height(12.dp))
    BalanceCard(balance = model.balance.toString())
  }
}

@Composable
private fun Header(onClickTopup: () -> Unit) {
  Row(verticalAlignment = Alignment.CenterVertically) {
    Text(text = "슈퍼페이 잔고", fontSize = 22.sp, color = Color.Black, fontWeight = FontWeight.Bold)
    Spacer(modifier = Modifier.weight(1f))
    Text(
      modifier = Modifier.clickable(onClick = onClickTopup),
      fontSize = 18.sp,
      text = "충전하기",
      color = Color.Blue,
      fontWeight = FontWeight.Light
    )
  }
}

@Composable
private fun BalanceCard(balance: String) {
  Card(
    Modifier
      .fillMaxWidth()
      .height(180.dp),
    backgroundColor = Color(red = 0.35f, green = 0.34f, blue = 0.84f, alpha = 1.0f),
    shape = RoundedCornerShape(16.dp)
  ) {
    Box(Modifier.fillMaxSize()) {
      Text(
        modifier = Modifier.align(Alignment.Center),
        fontSize = 22.sp,
        color = Color.White,
        text = balance + "원"
      )
    }
  }
}