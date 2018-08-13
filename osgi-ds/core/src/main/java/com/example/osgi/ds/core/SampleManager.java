/**
 * 
 */
package com.example.osgi.ds.core;

import static org.slf4j.LoggerFactory.getLogger;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.slf4j.Logger;

import com.example.osgi.ds.api.SampleService;

/**
 * @author resulav
 *
 */
@Component(enabled = true, immediate = true)
public class SampleManager implements SampleService {

	private final Logger logger = getLogger(getClass());

	@Activate
	void activate() {
		logger.info("{} activated", getClass().getTypeName());
	}

	@Deactivate
	void deactivate() {
		logger.info("{} deactivated", getClass().getTypeName());
	}

	@Modified
	void modified() {
		logger.info("{} modifed", getClass().getTypeName());
	}

	@Override
	public String getName() {
		return getClass().getTypeName();
	}

	@Override
	public String getEcho(String name, String surname, String profession, Integer age) {
	    StringBuilder sb = new StringBuilder(getClass().getTypeName()).append(" -> ");

	    sb.append("name: ").append(name).append(", ");
	    if(surname!=null){
            sb.append("surname: ").append(surname).append(", ");
        }
        sb.append("profession: ").append(profession).append(", ");

        if(age!=null){
            sb.append("age: ").append(age).append(", ");
        }

		return sb.toString();
	}
}
