package com.bo.openlogics.sales.service;

import com.bo.openlogics.core.bean.JsonResult;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * Created by osanchez on 1/10/14.
 */
public interface FileUpDownLoadService {

    public JsonResult subirArchivo(MultipartFile file);
    public JsonResult subirArchivos(MultipartHttpServletRequest request);
    //public void getImage(String value);

}
