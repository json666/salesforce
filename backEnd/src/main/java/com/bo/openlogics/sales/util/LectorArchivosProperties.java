package com.bo.openlogics.sales.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA. User: esalamanca Date: 20-03-14 Time: 05:22 PM
 * Lector de archivos properties.
 */
public class LectorArchivosProperties {

	public final static String APPLICATION_URL_REPORTES_SERVICE;
	public final static String APPLICATION_URL_SPF_SERVICE;
	public final static String APPLICATION_URL_OCE_SERVICE;
	public final static String REPORTES_LOCAL_OUTPUT_FOLDER;
	public final static String REPORTES_SERVLET_OUTPUT_FOLDER;
	public final static String REPORTES_SERVLET_OUTPUT_FOLDER_IMAGE;
	public final static String REPORTES_SERVLET_OUTPUT_FOLDER_CODBAR;


	static {
		InputStream stream = LectorArchivosProperties.class
				.getResourceAsStream("/app.properties");
		Properties properties = new Properties();

		try {
			properties.load(stream);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Si el archivo no se leyo correctamente o no existe la propiedad,
		// recibimos NULL
		APPLICATION_URL_REPORTES_SERVICE = properties
				.getProperty("application.url_reportes_service");
		APPLICATION_URL_SPF_SERVICE = properties
				.getProperty("application.url_spf_service");
		APPLICATION_URL_OCE_SERVICE = properties
				.getProperty("application.url_oce_service");
		REPORTES_LOCAL_OUTPUT_FOLDER = properties
				.getProperty("reportes.local.output.folder");
		REPORTES_SERVLET_OUTPUT_FOLDER = properties
				.getProperty("reportes.servlet.output.folder");
        REPORTES_SERVLET_OUTPUT_FOLDER_IMAGE = properties
                .getProperty("reportes.servlet.output.folder.image");
        REPORTES_SERVLET_OUTPUT_FOLDER_CODBAR = properties
                .getProperty("reportes.servlet.output.folder.codbar");
	}
}
