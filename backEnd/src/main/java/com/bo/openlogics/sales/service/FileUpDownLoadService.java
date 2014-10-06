package com.bo.openlogics.sales.service;

import com.bo.openlogics.sales.model.FileMeta;
import com.bo.openlogics.sales.model.JsonResult;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.util.LinkedList;

/**
 * Created by osanchez on 1/10/14.
 */
public interface FileUpDownLoadService {

    public JsonResult subirArchivo(MultipartFile file);
    public JsonResult subirArchivos(MultipartHttpServletRequest request);
    //public void getImage(String value);

}
