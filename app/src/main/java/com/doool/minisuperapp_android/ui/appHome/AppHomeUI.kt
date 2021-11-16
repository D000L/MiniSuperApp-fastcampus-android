package com.doool.minisuperapp_android.ui.appHome

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.jetpack.subscribeAsState
import com.doool.minisuperapp_android.R
import com.doool.minisuperapp_android.appHome.AppHome

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AppHomeUI(component: AppHome) {
  val model by component.models.subscribeAsState()

  Column(Modifier.background(Color.Gray)) {
    Text(text = "홈")

    LazyVerticalGrid(cells = GridCells.Fixed(2), content = {
      items(model.widgets) {
        HomeWidgetUI(widget = it)
      }
    })
  }
}

@Composable
private fun HomeWidgetUI(widget: AppHome.HomeWidget) {
  Column(
    Modifier
      .padding(25.dp)
      .fillMaxSize()
      .background(colorResource(id = R.color.white), shape = RoundedCornerShape(12.dp))
      .clickable { widget.tapHandler() },
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Icon(imageVector = Icons.Default.Home, contentDescription = null)
    Text(text = widget.title)
  }
}