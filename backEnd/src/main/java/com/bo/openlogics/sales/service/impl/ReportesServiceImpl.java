/**
 *
 */
package com.bo.openlogics.sales.service.impl;


import com.bo.openlogics.sales.service.ReportesService;
import com.bo.openlogics.sales.util.LectorArchivosProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * @author rmagne
 *
 */
@Service
public class ReportesServiceImpl implements ReportesService {

	/* (non-Javadoc)
	 * @see bo.gob.aduana.sga.oce.service.ReportesService#reporteOceImpPresencial(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Autowired
	private RestTemplate restTemplate;

	private final Logger logger = LoggerFactory.getLogger(ReportesServiceImpl.class);



	@Override
	public void reporteEtiquetasArticulo(HttpServletResponse response, String tipoReporte, String nroDocumento,String formato) {
		
		String name="reporte_etiqueta";
		logger.info("***** Iniciando la descarga del reporte *****");
		try {
			URL url = new URL(LectorArchivosProperties.APPLICATION_URL_REPORTES_SERVICE+"etiqueta/"+tipoReporte+"/"+nroDocumento+"/"+formato);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setDoOutput(true);
	        conn.setRequestMethod("GET");
	        if (conn.getResponseCode() == 200) {
	            /**
	             * Devolver la imagen recuperada de PDF
	             */
	            InputStream inputStream = conn.getInputStream();
	            response.setContentType("application/pdf");
	            response.setHeader("Content-Disposition", "filename=\"" + name + ".pdf" + "\"");
	            FileCopyUtils.copy(inputStream, response.getOutputStream());
	        }
	        logger.info("Reporte Descargado correctamente!");
		} catch (MalformedURLException e) {
			logger.info("Exception "+e.getMessage());
		} catch (ProtocolException e) {
			logger.info("Exception "+e.getMessage());
		} catch (IOException e) {
			logger.info("Exception "+e.getMessage());
		} finally{
			logger.info("***** Terminando la descarga del reporte *****");
		}

		
	}

}
