package com.bo.openlogics.sales.controller;

import com.bo.openlogics.sales.model.FileMeta;
import com.bo.openlogics.sales.model.JsonResult;
import com.bo.openlogics.sales.service.FileUpDownLoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by osanchez on 1/10/14.
 */

@Controller
public class FileUpDownLoadController {

    @Autowired
    FileUpDownLoadService fileUpDownLoadService;

    LinkedList<FileMeta> files = new LinkedList<FileMeta>();
    FileMeta fileMeta = null;


    @RequestMapping(value = "/uploadFiles", method = RequestMethod.POST)
    public
    @ResponseBody
    JsonResult handleFileUpload(MultipartHttpServletRequest request) throws IOException {
        JsonResult jsonResult = fileUpDownLoadService.subirArchivos(request);
        files = (LinkedList<FileMeta>) jsonResult.getResult();
        System.out.println("TAMAÑO:" + files.size());
        fileMeta = files.get(0);
        System.out.println("FILEMETA:" + fileMeta.getFileName());
        return jsonResult;
        /*try {
            response.setContentType(fileMeta.getFileType());
            response.setHeader("Content-disposition", "attachment; filename=\"" + fileMeta.getFileName() + "\"");
            FileCopyUtils.copy(fileMeta.getBytes(), response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    @RequestMapping(value = "/getImage/{value}", method = RequestMethod.GET)
    public void get(HttpServletResponse response, @PathVariable String value){
        FileMeta getFile = files.get(Integer.parseInt(value));
        try{
            /*String filePathToBeServed = "d://var//croc.png";//complete file name with path;
            File fileToDownload = new File(filePathToBeServed);
            InputStream inputStream = new FileInputStream(fileToDownload);*/
            //response.setContentType("application/force-download");
            response.setContentType(getFile.getFileType());
            response.setHeader("Content-Disposition", "attachment; filename="+getFile.getFileName());
            FileCopyUtils.copy(getFile.getBytes(), response.getOutputStream());
            response.flushBuffer();

        }catch(Exception e){

            e.printStackTrace();
        }
    }

}
