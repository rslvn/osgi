/**
 * 
 */
package com.example.osgi.ds.api;

/**
 * @author resulav
 *
 */
public interface SampleService {
	
	String getName();

	String getEcho(String name, String surname, String profession, Integer age);
}
