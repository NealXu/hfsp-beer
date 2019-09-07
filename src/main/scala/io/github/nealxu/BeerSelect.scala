package io.github.nealxu

import java.io.IOException

import javax.servlet.ServletException
import javax.servlet.http._

class BeerSelect extends HttpServlet {

  @throws(classOf[IOException])
  @throws(classOf[ServletException])
  override def doPost(req: HttpServletRequest, resp: HttpServletResponse): Unit = {
    val color = req.getParameter("color")

    resp.setContentType("text/html")
    val out = resp.getWriter
    out.println(s"<br>Got beer color $color")

  }

}
