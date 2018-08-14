/**
 * 
 */
package com.example.osgi.felix.scr.core;

import static org.slf4j.LoggerFactory.getLogger;

import java.util.HashMap;
import java.util.Map;

import com.example.osgi.felix.scr.api.DummyService;
import org.apache.felix.scr.annotations.*;
import org.slf4j.Logger;

import com.example.osgi.felix.scr.api.SampleService;
import com.example.osgi.felix.scr.api.model.SampleConfig;

/**
 * @author resulav
 *
 */
@Component(enabled = true, immediate = true, metatype = true, configurationFactory = true)
@Service
public class SampleManager implements SampleService {

	private final Logger logger = getLogger(getClass());

	private static final String LOGGER_CALLED = "{} called";

	private static final String PROPERTY_NAME_NAME = "name";
	private static final String PROPERTY_NAME_MAX_SIZE = "maxSize";
	private static final String PROPERTY_NAME_NUMBER = "number";

	private static final String PROPERTY_DEFAULT_NAME = "nameVal";
	private static final int PROPERTY_DEFAULT_MAX_SIZE = 10;
	private static final long PROPERTY_DEFAULT_NUMBER = 100l;

    @Reference(policy = ReferencePolicy.STATIC, cardinality = ReferenceCardinality.MANDATORY_UNARY)
    private DummyService dummyService;


	@Property(name = PROPERTY_NAME_NAME, value = PROPERTY_DEFAULT_NAME, label = "Long property")
	private String name;

	@Property(name = PROPERTY_NAME_MAX_SIZE, intValue = PROPERTY_DEFAULT_MAX_SIZE, label = "Integer property")
	protected int maxSize = PROPERTY_DEFAULT_MAX_SIZE;

	@Property(name = PROPERTY_NAME_NUMBER, longValue = PROPERTY_DEFAULT_NUMBER, label = "Long property")
	private long number = PROPERTY_DEFAULT_NUMBER;

	private Map<String, Object> properties = new HashMap<>();

	@Activate
	void activate(final Map<String, Object> properties) {
		print(properties);
        logger.info("DummyService.getName: {}", dummyService.getName());
		logger.info("{} activated", getClass().getTypeName());
	}

	@Deactivate
	void deactivate(final Map<String, Object> properties) {
		print(properties);
		logger.info("{} deactivated", getClass().getTypeName());
	}

	@Modified
	void modified(final Map<String, Object> properties) {
		print(properties);
		logger.info("{} modifed", getClass().getTypeName());
	}

	private void print(final Map<String, Object> properties) {
		this.properties = properties;
		final String loggerFormat = "{}: {}";
		properties.forEach((k, v) -> logger.info(loggerFormat, k, v));
	}

	@Override
	public String getName() {
		logger.info(LOGGER_CALLED, "getName");
		return getClass().getTypeName();
	}

	@Override
	public String getEcho(String name, String surname, String profession, Integer age) {

		logger.info(LOGGER_CALLED, "getEcho");

		StringBuilder sb = new StringBuilder(getClass().getTypeName()).append(" -> ");

		sb.append("name: ").append(name).append(", ");
		if (surname != null) {
			sb.append("surname: ").append(surname).append(", ");
		}
		sb.append("profession: ").append(profession).append(", ");

		if (age != null) {
			sb.append("age: ").append(age);
		}

		return sb.toString();
	}

	@Override
	public SampleConfig getConfig() {
		logger.info(LOGGER_CALLED, "getConfig");
		return SampleConfig.builder()
				.name(properties.get(PROPERTY_NAME_NAME) == null ? null : properties.get(PROPERTY_NAME_NAME).toString())
				.maxSize(properties.get(PROPERTY_NAME_MAX_SIZE) == null ? null
						: (Integer) properties.get(PROPERTY_NAME_MAX_SIZE))
				.number(properties.get(PROPERTY_NAME_NUMBER) == null ? null
						: (Long) properties.get(PROPERTY_NAME_NUMBER))
				.build();
	}
}
