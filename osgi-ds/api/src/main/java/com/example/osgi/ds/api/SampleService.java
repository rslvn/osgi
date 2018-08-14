/**
 * 
 */
package com.example.osgi.ds.api;

import com.example.osgi.ds.api.model.SampleConfig;

/**
 * @author resulav
 *
 */
public interface SampleService {
	
	String getName();

	String getEcho(String name, String surname, String profession, Integer age);

	SampleConfig getConfig();
}
