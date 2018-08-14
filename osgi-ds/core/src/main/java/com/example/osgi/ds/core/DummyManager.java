package com.example.osgi.ds.core;

import com.example.osgi.ds.api.DummyService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by resulav on 14.08.2018.
 */
@Component(enabled = true, immediate = true)
public class DummyManager implements DummyService{

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
}
