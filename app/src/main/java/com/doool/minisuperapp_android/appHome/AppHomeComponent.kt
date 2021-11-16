package com.doool.minisuperapp_android.appHome

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value

class AppHomeComponent(
  componentContext: ComponentContext
) : AppHome, ComponentContext by componentContext {

  override val models: Value<AppHome.Model> = MutableValue(
    AppHome.Model(widgets = listOf(
      AppHome.HomeWidget(
        imageName = "car",
        title = "슈퍼택시",
        tapHandler = {

        }
      ),
      AppHome.HomeWidget(
        imageName = "cart",
        title = "슈퍼마트",
        tapHandler = {}
      )
    ))
  )

}