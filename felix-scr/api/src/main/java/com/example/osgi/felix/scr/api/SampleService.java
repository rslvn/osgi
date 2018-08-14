/**
 *
 */
package com.example.osgi.felix.scr.api;

import com.example.osgi.felix.scr.api.model.SampleConfig;

/**
 * @author resulav
 */
public interface SampleService {

    String getName();

    String getEcho(String name, String surname, String profession, Integer age);
    
    SampleConfig getConfig();

}
