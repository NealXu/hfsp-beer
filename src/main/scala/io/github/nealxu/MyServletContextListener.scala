package io.github.nealxu

import io.github.nealxu.utils.LogSupport
import javax.servlet.{ServletContextEvent, ServletContextListener}

class MyServletContextListener extends ServletContextListener with LogSupport {

  override def contextInitialized(sce: ServletContextEvent): Unit = {
    logDebug("servlet context initialized")

    val sc = sce.getServletContext
    val dogBreed = sc.getInitParameter("breed")
    val dog = Dog(dogBreed)
    logDebug(s"dog breed is $dogBreed")

    sc.setAttribute("dog", dog)
  }

  override def contextDestroyed(sce: ServletContextEvent): Unit = {
    logDebug("servlet context destroyed")
  }

}
