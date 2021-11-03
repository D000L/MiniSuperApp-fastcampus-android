package com.doool.minisuperapp_android.financehome.superPayDashboard

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
 * Builder for the {@link SuperPayDashboardScope}.
 *
 * TODO describe this scope's responsibility as a whole.
 */
class SuperPayDashboardBuilder(dependency: ParentComponent) : ViewBuilder<SuperPayDashboardView, SuperPayDashboardRouter, SuperPayDashboardBuilder.ParentComponent>(dependency) {

  /**
   * Builds a new [SuperPayDashboardRouter].
   *
   * @param parentViewGroup parent view group that this router's view will be added to.
   * @return a new [SuperPayDashboardRouter].
   */
  fun build(parentViewGroup: ViewGroup): SuperPayDashboardRouter {
    val view = createView(parentViewGroup)
    val interactor = SuperPayDashboardInteractor()
    val component = DaggerSuperPayDashboardBuilder_Component.builder()
        .parentComponent(dependency)
        .view(view)
        .interactor(interactor)
        .build()
    return component.superpaydashboardRouter()
  }

  override fun inflateView(inflater: LayoutInflater, parentViewGroup: ViewGroup): SuperPayDashboardView {
    // TODO: Inflate a new view using the provided inflater, or create a new view programatically using the
    // provided context from the parentViewGroup.
    return SuperPayDashboardView(parentViewGroup.context)
  }

  interface ParentComponent {
    fun dependency () : SuperPayDashboardDependency
    // TODO: Define dependencies required from your parent interactor here.
  }

  @dagger.Module
  abstract class Module {

    @SuperPayDashboardScope
    @Binds
    internal abstract fun presenter(view: SuperPayDashboardView): SuperPayDashboardInteractor.SuperPayDashboardPresenter

    @dagger.Module
    companion object {

      @SuperPayDashboardScope
      @Provides
      @JvmStatic
      internal fun router(
          component: Component,
          view: SuperPayDashboardView,
          interactor: SuperPayDashboardInteractor): SuperPayDashboardRouter {
        return SuperPayDashboardRouter(view, interactor, component)
      }
    }

    // TODO: Create provider methods for dependencies created by this Rib. These should be static.
  }

  @SuperPayDashboardScope
  @dagger.Component(modules = arrayOf(Module::class), dependencies = arrayOf(ParentComponent::class))
  interface Component : InteractorBaseComponent<SuperPayDashboardInteractor>, BuilderComponent {

    @dagger.Component.Builder
    interface Builder {
      @BindsInstance
      fun interactor(interactor: SuperPayDashboardInteractor): Builder

      @BindsInstance
      fun view(view: SuperPayDashboardView): Builder

      fun parentComponent(component: ParentComponent): Builder
      fun build(): Component
    }
  }

  interface BuilderComponent {
    fun superpaydashboardRouter(): SuperPayDashboardRouter
  }

  @Scope
  @Retention(CLASS)
  internal annotation class SuperPayDashboardScope

  @Qualifier
  @Retention(CLASS)
  internal annotation class SuperPayDashboardInternal
}
