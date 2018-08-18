package com.im_hero.diffpatch;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet(name = "ServGetApkPatch", urlPatterns = "/app/get-apk-patch")
public class ServGetApkPatch extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int currVersion = Integer.valueOf(request.getParameter(Consts.Keys.APP_CURRENT_VERSION_CODE));
        int latestVersion = Integer.valueOf(getServletContext().getAttribute(Consts.Keys.APP_LATEST_VERSION_CODE).toString());

        // 判断当前版本的补丁文件是否存在
        String patchFileName = currVersion + '-' + latestVersion + ".patch";
        File patch = new File(getServletContext().getRealPath(Consts.Paths.FOLDER_APK_PATCH_FILES + '/' + patchFileName));

        // 不存在就创建一个新的补丁文件
        if (!patch.exists()) {
            System.out.println("Not exists.");
            return;
        }
        response.addHeader("content-disposition", "attachment;filename=" + patchFileName);
        // 将补丁文件发送给APP
        FileInputStream fis = new FileInputStream(patch);
        ServletOutputStream sos = response.getOutputStream();
        byte[] buffer = new byte[8192];
        int len;
        while ((len = fis.read(buffer)) > 0) {
            sos.write(buffer, 0, len);
        }
        sos.flush();
    }
}
