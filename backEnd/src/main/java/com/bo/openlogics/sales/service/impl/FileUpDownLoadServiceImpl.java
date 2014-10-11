package com.bo.openlogics.sales.service.impl;

import com.bo.openlogic.core.bean.JsonResult;
import com.bo.openlogics.sales.model.FileMeta;

import com.bo.openlogics.sales.service.FileUpDownLoadService;
import com.bo.openlogics.sales.util.LectorArchivosProperties;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

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
                return new JsonResult(true, "You successfully uploaded " + "TEST" + " into " + "TEST" + "-uploaded !", "");
            } catch (Exception e) {
                return new JsonResult(false, "You failed to upload " + "TEST" + " => " + e.getMessage());

            }
        } else {
            return new JsonResult(false, "You failed to upload " + "TEST" + " because the file was empty.");
        }
    }

    @Override
    public JsonResult subirArchivos(MultipartHttpServletRequest request) {

        LinkedList<FileMeta> files = null;
        files=new LinkedList<FileMeta>();
        FileMeta fileMeta = null;
        //1. build an iterator
        Iterator<String> itr = request.getFileNames();
        MultipartFile mpf = null;
        JsonResult jsonResult = null;
        jsonResult = new JsonResult();
        try {
            //2. get each file
            //files.remove();
            while (itr.hasNext()) {
                System.out.println("INGRESANDO AL ITER....");
                mpf = request.getFile(itr.next());
                if (mpf.getOriginalFilename().indexOf(".") != -1) {
                    //2.1 get next MultipartFile

                    System.out.println(mpf.getOriginalFilename() + " uploaded! " + files.size());

                    //2.2 if files > 10 remove the first from the list
                    if (files.size() >= 10)
                        files.pop();

                    //2.3 create new fileMeta
                    fileMeta = new FileMeta();
                    fileMeta.setFileName(mpf.getOriginalFilename());
                    fileMeta.setFileSize(mpf.getSize() / 1024 + " Kb");
                    fileMeta.setFileType(mpf.getContentType());
                    //fileMeta.setBytes(mpf.getBytes());

                    System.out.println("PATH"+LectorArchivosProperties.REPORTES_SERVLET_OUTPUT_FOLDER_IMAGE + mpf.getOriginalFilename());
                    fileMeta.setBytes(mpf.getBytes());
                    FileOutputStream fileOutputStream=new FileOutputStream(LectorArchivosProperties.REPORTES_SERVLET_OUTPUT_FOLDER_IMAGE + mpf.getOriginalFilename());

                    // copy file to local disk (make sure the path "e.g. D:/temp/files" exists)
                    FileCopyUtils.copy(mpf.getBytes(),fileOutputStream);


                    //2.4 add to files
                    files.add(fileMeta);
                    jsonResult.setSuccess(true);
                    jsonResult.setResult(files);
                    jsonResult.setMessage("Archivo Subido");
                }else {
                    System.out.println("NO HAY IMAGEN");
                }
            }
            // result will be like this
            // [{"fileName":"app_engine-85x77.png","fileSize":"8 Kb","fileType":"image/png"},...]
            return jsonResult;
        } catch (IOException e) {
            System.out.println("Error:"+e.getMessage());
            jsonResult=new JsonResult(false, e.getMessage(),"");
        }catch(Exception e){
            System.out.println("Error:"+e.getMessage());
            jsonResult=new JsonResult(false, e.getMessage(),"");
        }
        return jsonResult;
    }
}
