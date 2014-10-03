package com.bo.openlogics.sales.service;

import com.bo.openlogics.sales.model.JsonResult;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by osanchez on 1/10/14.
 */
public interface FileUpDownLoadService {

    public JsonResult subirArchivo(MultipartFile file);

}
