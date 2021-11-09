package com.doool.minisuperapp_android.ui.financeHome

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.jetpack.subscribeAsState
import com.doool.minisuperapp_android.financeHome.superPayDashboard.SuperPayDashboard

@Composable
fun SuperPayDashboardUI(component: SuperPayDashboard) {
  val model by component.models.subscribeAsState()

  Column() {
    Row() {
      Text(text = "슈퍼페이 잔고")
      Spacer(modifier = Modifier.weight(1f))
      Text(modifier = Modifier.clickable(onClick = component::onClickTopup), text = "충전하기")
    }
    Card(
      Modifier
        .fillMaxWidth()
        .height(160.dp), backgroundColor = Color.Blue
    ) {
      Box(Modifier.fillMaxSize()) {
        Text(modifier = Modifier.align(Alignment.Center), text = model.balance.toString())
      }
    }
  }

}
