package com.doool.minisuperapp_android.apphome

import android.view.LayoutInflater
import android.view.ViewGroup
import com.uber.rib.core.InteractorBaseComponent
import com.uber.rib.core.ViewBuilder
import dagger.Binds
import dagger.BindsInstance
import dagger.Provides
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy.CLASS
import javax.inject.Qualifier
import javax.inject.Scope


/**
 * Builder for the {@link AppHomeScope}.
 *
 * TODO describe this scope's responsibility as a whole.
 */
class AppHomeBuilder(dependency: ParentComponent) :
  ViewBuilder<AppHomeView, AppHomeRouter, AppHomeBuilder.ParentComponent>(dependency) {

  /**
   * Builds a new [AppHomeRouter].
   *
   * @param parentViewGroup parent view group that this router's view will be added to.
   * @return a new [AppHomeRouter].
   */
  fun build(parentViewGroup: ViewGroup): AppHomeRouter {
    val view = createView(parentViewGroup)
    val interactor = AppHomeInteractor()
    val component = DaggerAppHomeBuilder_Component.builder()
      .parentComponent(dependency)
      .view(view)
      .interactor(interactor)
      .build()
    return component.apphomeRouter()
  }

  override fun inflateView(inflater: LayoutInflater, parentViewGroup: ViewGroup): AppHomeView {
    // TODO: Inflate a new view using the provided inflater, or create a new view programatically using the
    // provided context from the parentViewGroup.
    return AppHomeView(parentViewGroup.context)
  }

  interface ParentComponent {
    // TODO: Define dependencies required from your parent interactor here.
  }

  @dagger.Module
  abstract class Module {


    @AppHomeScope
    @Binds
    internal abstract fun presenter(view: AppHomeView): AppHomeInteractor.AppHomePresenter

    @dagger.Module
    companion object {

      @AppHomeScope
      @Provides
      @JvmStatic
      internal fun router(
        component: Component,
        view: AppHomeView,
        interactor: AppHomeInteractor
      ): AppHomeRouter {
        return AppHomeRouter(view, interactor, component)
      }
    }

    // TODO: Create provider methods for dependencies created by this Rib. These should be static.
  }

  @AppHomeScope
  @dagger.Component(
    modules = arrayOf(Module::class),
    dependencies = arrayOf(ParentComponent::class)
  )
  interface Component : InteractorBaseComponent<AppHomeInteractor>, BuilderComponent {

    @dagger.Component.Builder
    interface Builder {
      @BindsInstance
      fun interactor(interactor: AppHomeInteractor): Builder

      @BindsInstance
      fun view(view: AppHomeView): Builder

      fun parentComponent(component: ParentComponent): Builder
      fun build(): Component
    }
  }

  interface BuilderComponent {
    fun apphomeRouter(): AppHomeRouter
  }

  @Scope
  @Retention(CLASS)
  internal annotation class AppHomeScope

  @Qualifier
  @Retention(CLASS)
  internal annotation class AppHomeInternal
}
