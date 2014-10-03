package com.bo.openlogics.sales.service.impl;

import com.bo.openlogics.sales.model.JsonResult;
import com.bo.openlogics.sales.service.FileUpDownLoadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by osanchez on 1/10/14.
 */

@Service
public class FileUpDownLoadServiceImpl implements FileUpDownLoadService {

    @Override
    public JsonResult subirArchivo(MultipartFile file) {
        System.out.println("CARGANDO IMAGE BACKEND");
        if (!file.isEmpty()) {
            try {
                System.out.println(file.getName());
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File("TEST" + "-uploaded")));
                stream.write(bytes);
                stream.close();
                return new JsonResult(true,"You successfully uploaded " + "TEST" + " into " + "TEST" + "-uploaded !","");
            } catch (Exception e) {
                return new JsonResult(false, "You failed to upload " + "TEST" + " => " + e.getMessage());

            }
        } else {
            return new JsonResult(false,"You failed to upload " + "TEST" + " because the file was empty.");
        }
    }
}
