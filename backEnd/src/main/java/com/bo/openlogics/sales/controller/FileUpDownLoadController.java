package com.bo.openlogics.sales.controller;

import com.bo.openlogics.sales.model.JsonResult;
import com.bo.openlogics.sales.service.FileUpDownLoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * Created by osanchez on 1/10/14.
 */

@Controller
@RequestMapping(value = "/rest")
public class FileUpDownLoadController {

    @Autowired
    FileUpDownLoadService fileUpDownLoadService;


    @RequestMapping(value = "/uploadFiles", method = RequestMethod.POST)
    public @ResponseBody JsonResult handleFileUpload(MultipartHttpServletRequest request){
        MultipartFile file = request.getFile("document");

        return fileUpDownLoadService.subirArchivo(file);
    }

}
