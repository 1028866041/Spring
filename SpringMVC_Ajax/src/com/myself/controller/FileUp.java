package com.myself.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import java.io.*;

/**
 * Created by Administrator on 2017/7/3 0003.
 */
@Controller
public class FileUp {

    @RequestMapping(value="/upload",method = RequestMethod.POST)
    public String fileload(@RequestParam("file") CommonsMultipartFile[] file, HttpServletRequest request) throws IOException {

        System.out.println("FileUp");
        String path = request.getServletContext().getRealPath("/WEB-INF/file");
        int i,len;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        for(i=0; i<file.length; i++)
        {
            inputStream = file[i].getInputStream();
            outputStream = new FileOutputStream(new File(path, file[i].getOriginalFilename()));

            byte[] buffer = new byte[512];
            while((len = inputStream.read(buffer)) != -1){
                outputStream.write(buffer,0,len);
            }
        }
        inputStream.close();
        outputStream.close();

        return "/WEB-INF/jsp/success.jsp";
}
}
