/**
 * 
 */
package com.example.osgi.core;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Deactivate;
import org.apache.felix.scr.annotations.Service;

import com.example.osgi.api.SampleService;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author resulav
 *
 */
@Component(enabled = true,immediate = true)
@Service
public class SampleManager implements SampleService {

    private final Logger logger = getLogger(getClass());

    @Activate
    void activate(){
        logger.info("{} activated",getClass().getSimpleName());
    }

    @Deactivate
    void deactivate(){
        logger.info("{} deactivated",getClass().getSimpleName());
    }

	@Override
	public String getName() {
		return "SampleManager";
	}

}
