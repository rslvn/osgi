/**
 *
 */
package com.example.osgi.felix.scr.api;

import java.util.Optional;

/**
 * @author resulav
 */
public interface SampleService {

    String getName();

    String getEcho(String name, String surname, String profession, Integer age);

}
