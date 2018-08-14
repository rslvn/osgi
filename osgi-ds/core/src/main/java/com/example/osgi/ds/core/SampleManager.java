/**
 * 
 */
package com.example.osgi.ds.core;

import static org.slf4j.LoggerFactory.getLogger;

import java.util.Arrays;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.osgi.service.metatype.annotations.Option;
import org.slf4j.Logger;

import com.example.osgi.ds.api.DummyService;
import com.example.osgi.ds.api.SampleService;

/**
 * @author resulav
 *
 */
@Component(enabled = true, immediate = true)
@Designate(ocd = SampleManager.Config.class)
public class SampleManager implements SampleService {

	private final Logger logger = getLogger(getClass());

	@Reference(policy = ReferencePolicy.STATIC, cardinality = ReferenceCardinality.MANDATORY)
	private DummyService dummyService;

	@Activate
	void activate(Config config) {
		print(config);
		logger.info("{} activated", getClass().getTypeName());
	}

	@Deactivate
	void deactivate(Config config) {
		print(config);
		logger.info("{} deactivated", getClass().getTypeName());
	}

	@Modified
	void modified(Config config) {
		print(config);
		logger.info("{} modifed", getClass().getTypeName());
	}

	private void print(Config config) {
		final String loggerFormat = "{}: {}";
		logger.info(loggerFormat, "foo_bar", config.foo_bar());
		logger.info(loggerFormat, "max_size", config.max_size());
		logger.info(loggerFormat, "servicename_propertyname_boolean", config.servicename_propertyname_boolean());
		logger.info(loggerFormat, "servicename_propertyname_dropdown", config.servicename_propertyname_dropdown());
		logger.info(loggerFormat, "servicename_propertyname_password", config.servicename_propertyname_password());
		logger.info(loggerFormat, "servicename_propertyname_long", config.servicename_propertyname_long());
		logger.info(loggerFormat, "servicename_propertyname_string", config.servicename_propertyname_string());
		logger.info(loggerFormat, "servicename_propertyname_string_array", Arrays.toString(config.servicename_propertyname_string_array()));
		logger.info(loggerFormat, "items", Arrays.toString(config.items()));
	}

	@Override
	public String getName() {
		return getClass().getTypeName();
	}

	@Override
	public String getEcho(String name, String surname, String profession, Integer age) {
		StringBuilder sb = new StringBuilder(getClass().getTypeName()).append(" -> ");

		sb.append("name: ").append(name).append(", ");
		if (surname != null) {
			sb.append("surname: ").append(surname).append(", ");
		}
		sb.append("profession: ").append(profession).append(", ");

		if (age != null) {
			sb.append("age: ").append(age).append(", ");
		}

		return sb.toString();
	}

	@ObjectClassDefinition(name = "Annotation Demo Service - OSGi")
	@interface Config {

		@AttributeDefinition(name = "Max size", description = "The maximum size", min = "10", max = "100", required = false, cardinality = 0)
		int max_size() default 10;

		// Multiple values
		@AttributeDefinition(cardinality = 5)
		String[] items();

		// Options
		@AttributeDefinition(options = { @Option(label = "Option Foo", value = "foo"),
				@Option(label = "Option Bar", value = "bar"), })
		String foo_bar() default "bar";

		@AttributeDefinition(name = "Boolean Property", description = "Sample boolean value", type = AttributeType.BOOLEAN)
		boolean servicename_propertyname_boolean() default true;

		@AttributeDefinition(name = "String Property", description = "Sample String property", type = AttributeType.STRING)
		String servicename_propertyname_string() default "foo";

		@AttributeDefinition(name = "Dropdown property", description = "Sample dropdown property", options = {
				@Option(label = "DAYS", value = "DAYS"), @Option(label = "HOURS", value = "HOURS"),
				@Option(label = "MILLISECONDS", value = "MILLISECONDS"), @Option(label = "MINUTES", value = "MINUTES"),
				@Option(label = "SECONDS", value = "SECONDS") })
		String servicename_propertyname_dropdown() default "";

		@AttributeDefinition(name = "String Array Property", description = "Sample String array property", type = AttributeType.STRING)
		String[] servicename_propertyname_string_array() default { "foo", "bar" };

		/*
		 * To create password field, either set the AttributeType or have the property
		 * name end with "*.password" (or both).
		 */
		@AttributeDefinition(name = "Password Property", description = "Sample password property", type = AttributeType.PASSWORD)
		String servicename_propertyname_password() default "";

		@AttributeDefinition(name = "Long Property", description = "Sample long property", type = AttributeType.LONG)
		long servicename_propertyname_long() default 0L;
	}

}
