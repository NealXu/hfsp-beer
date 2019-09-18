package io.github.nealxu

import io.github.nealxu.utils.LogSupport
import javax.servlet.http.{Cookie, HttpServlet, HttpServletRequest, HttpServletResponse}

class CookieTest extends HttpServlet with LogSupport {

  override def doPost(req: HttpServletRequest, resp:HttpServletResponse): Unit = {
    resp.setContentType("text/html")
    val name = req.getParameter("username")
    val cookie = new Cookie("username", name)
    cookie.setMaxAge(30 * 60)
    resp.addCookie(cookie)

    val view = req.getRequestDispatcher("cookieresult.jsp")
    view.forward(req, resp)

  }

}
