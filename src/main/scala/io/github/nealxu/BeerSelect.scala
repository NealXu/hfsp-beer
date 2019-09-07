package io.github.nealxu

import java.io.IOException

import javax.servlet.ServletException
import javax.servlet.http._

class BeerSelect extends HttpServlet {

  @throws(classOf[IOException])
  @throws(classOf[ServletException])
  override def doPost(req: HttpServletRequest, resp: HttpServletResponse): Unit = {
    val color = req.getParameter("color")
    val brandList = BeerExpert().getBrands(color)

    resp.setContentType("text/html")
    val out = resp.getWriter
    out.println("Beer Selection Advice<br>")
    brandList.foreach(brand => out.println(s"<br>try: $brand"))
  }

}
