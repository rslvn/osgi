/**
 * 
 */
package com.example.osgi.ds.rest.util;

import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

/**
 * @author resulav
 *
 */
public class RestUtility {

	public static <T> T getService(Class<T> serviceClass) {
		BundleContext bc = FrameworkUtil.getBundle(serviceClass).getBundleContext();
		if (bc != null) {
			ServiceReference<T> reference = bc.getServiceReference(serviceClass);
			if (reference != null) {
				T impl = bc.getService(reference);
				if (impl != null) {
					return impl;
				}
			}
		}

		throw new RuntimeException(String.format("Service %s not found", serviceClass.getTypeName()));
	}

}
