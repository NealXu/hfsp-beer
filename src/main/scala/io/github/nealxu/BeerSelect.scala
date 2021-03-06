package io.github.nealxu

import java.io.IOException

import io.github.nealxu.utils.LogSupport
import javax.servlet.ServletException
import javax.servlet.http._

import scala.collection.JavaConverters._

class BeerSelect extends HttpServlet with LogSupport {

  @throws(classOf[IOException])
  @throws(classOf[ServletException])
  override def doPost(req: HttpServletRequest, resp: HttpServletResponse): Unit = {
    val color = req.getParameter("color")
    val brandList = BeerExpert().getBrands(color)
    val styles = brandList.toBuffer.asJava
    req.setAttribute("styles", styles)

    val servletContext = getServletContext
    val adminEmail = servletContext.getInitParameter("adminEmail")
    logDebug(s"admin email is $adminEmail")
    req.setAttribute("adminEmail", adminEmail)

    val view = req.getRequestDispatcher("result.jsp")

    view.forward(req, resp)
  }

}
