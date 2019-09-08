package io.github.nealxu

import io.github.nealxu.utils.LogSupport
import javax.servlet.http.{HttpServlet, HttpServletRequest, HttpServletResponse}

class ServletContextListenerTest extends HttpServlet with LogSupport {

  override def doGet(req: HttpServletRequest, resp: HttpServletResponse): Unit = {
    resp.setContentType("text/html")
    val out = resp.getWriter
    out.println("test context attributes set by listener<br>")
    out.println("<br>")
    val dog = getServletContext.getAttribute("dog").asInstanceOf[Dog]
    logDebug(s"$dog")

    out.println(s"Dog's breed is ${dog.breed}")
  }

}
