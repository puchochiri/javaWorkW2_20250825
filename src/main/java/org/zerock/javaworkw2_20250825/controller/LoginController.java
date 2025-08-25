package org.zerock.javaworkw2_20250825.controller;

import lombok.extern.java.Log;
import org.zerock.javaworkw2_20250825.dto.MemberDTO;
import org.zerock.javaworkw2_20250825.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/login")
@Log
public class LoginController extends HttpServlet {
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    log.info("login get...............");

     req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req,resp);
  }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    log.info("login post...............");

    String mid = req.getParameter("mid");
    String mpw = req.getParameter("mpw");

    String auto = req.getParameter("auto");

    boolean rememberMe = auto != null && auto.equals("on");


    try {
        MemberDTO memberDTO = MemberService.INSTANCE.login(mid, mpw);

        if(rememberMe){
           String uuid = UUID.randomUUID().toString();

           MemberService.INSTANCE.updateUuid(mid, uuid);
           memberDTO.setUuid(uuid);

           Cookie rememberCookie = new Cookie("remember-me",uuid);
           rememberCookie.setMaxAge(60*60^24*7); //쿠키유효기간은 7일
           resp.addCookie(rememberCookie);
        }


        HttpSession session = req.getSession();
        session.setAttribute("loginInfo",memberDTO);
        resp.sendRedirect("/todo/list");
    } catch (Exception e) {
        resp.sendRedirect("/login?result=error");
    }



  }
}
