package com.bo.openlogics.sales.dozer;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class UtilTransport {
	private Mapper mapper;

	/**
	 * Inicializa los recursos de la clase
	 */
	@PostConstruct
	public void initializate() {
		mapper = new DozerBeanMapper();
	}

	/**
	 * 
	 * @param source
	 * @param toClass
	 * @return
	 */

	public <F, T> T convert(final F source, final Class<T> toClass) {
		if (source == null)
			return null;
		return mapper.map(source, toClass);
	}

	/**
	 * 
	 * @param source
	 * @param toClass
	 * @return
	 */
	public <T, U> List<U> convert(final List<T> source, final Class<U> toClass) {

		if (source == null) {
			return null;
		}
		final List<U> dest = new ArrayList<U>();

		for (T element : source) {
			dest.add(mapper.map(element, toClass));
		}

		return dest;
	}
}
