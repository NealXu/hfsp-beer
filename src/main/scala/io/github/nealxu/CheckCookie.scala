package io.github.nealxu

import io.github.nealxu.utils.LogSupport
import javax.servlet.http.{HttpServlet, HttpServletRequest, HttpServletResponse}

class CheckCookie extends HttpServlet with LogSupport {

  override def doGet(req: HttpServletRequest, reps: HttpServletResponse): Unit = {
    reps.setContentType("text/html")
    val out = reps.getWriter
    val cookies = req.getCookies
    if (cookies != null) {
      cookies.find(_.getName == "username") match {
        case Some(c) => out.println(s"Hello ${c.getValue}")
        case None =>
      }
    }
  }

}
