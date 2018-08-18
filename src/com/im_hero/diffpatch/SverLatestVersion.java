package com.im_hero.diffpatch;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "SverLatestVersion", urlPatterns = "/app/latest-version")
public class SverLatestVersion extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext context = getServletContext();
        context.setAttribute(Consts.Keys.APP_LATEST_VERSION_CODE, "2");
        context.setAttribute(Consts.Keys.APP_LATEST_VERSION_NAME, "DiffPatch 1.1");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletContext context = getServletContext();
        String versionCode = (String) context.getAttribute(Consts.Keys.APP_LATEST_VERSION_CODE);
        String versionName = (String) context.getAttribute(Consts.Keys.APP_LATEST_VERSION_NAME);
        Writer writer = response.getWriter();
        writer.write("{\"versionCode\":" + versionCode + ",\"versionName\":\"" + versionName + "\"}\n");
        writer.flush();
    }

}
