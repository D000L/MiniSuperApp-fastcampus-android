package com.doool.minisuperapp_android.appHome

import com.arkivanov.decompose.value.Value

interface AppHome {

  val models: Value<Model>

  class Model(
    val widgets: List<HomeWidget>
  )

  data class HomeWidget(
    val imageName: String,
    val title: String,
    val tapHandler: () -> Unit
  )
}