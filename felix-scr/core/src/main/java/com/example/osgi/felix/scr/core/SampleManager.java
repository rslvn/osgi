/**
 * 
 */
package com.example.osgi.felix.scr.core;

import static org.slf4j.LoggerFactory.getLogger;

import org.apache.felix.scr.annotations.*;
import org.slf4j.Logger;

import com.example.osgi.felix.scr.api.SampleService;

import java.util.Optional;

/**
 * @author resulav
 *
 */
@Component(enabled = true, immediate = true)
@Service
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
            sb.append("age: ").append(age);
        }

        return sb.toString();
    }
}
