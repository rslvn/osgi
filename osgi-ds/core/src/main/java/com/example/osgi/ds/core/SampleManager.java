/**
 * 
 */
package com.example.osgi.ds.core;

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

import com.example.osgi.ds.api.DummyService;
import com.example.osgi.ds.api.SampleService;
import com.example.osgi.ds.api.model.SampleConfig;

import lombok.extern.slf4j.Slf4j;

/**
 * @author resulav
 *
 */
@Slf4j
@Component(enabled = true, immediate = true)
@Designate(ocd = SampleManager.Config.class)
public class SampleManager implements SampleService {

	private static final String LOGGER_CALLED = "{} called";

	@Reference(policy = ReferencePolicy.STATIC, cardinality = ReferenceCardinality.MANDATORY)
	private DummyService dummyService;

	private Config config;

	@Activate
	void activate(Config config) {
		print(config);
		log.info("DummyService.getName: {}", dummyService.getName());
		log.info("{} activated", getClass().getTypeName());
	}

	@Deactivate
	void deactivate(Config config) {
		print(config);
		log.info("{} deactivated", getClass().getTypeName());
	}

	@Modified
	void modified(Config config) {
		print(config);
		log.info("{} modifed", getClass().getTypeName());
	}

	private void print(Config config) {
		this.config = config;
		StringBuilder sb = new StringBuilder();
		sb.append("foo_bar: ").append(config.foo_bar()).append("\n\t");
		sb.append("max_size: ").append(config.max_size()).append("\n\t");
		sb.append("servicename_propertyname_boolean: ").append(config.servicename_propertyname_boolean())
				.append("\n\t");
		sb.append("servicename_propertyname_dropdown: ").append(config.servicename_propertyname_dropdown())
				.append("\n\t");
		sb.append("servicename_propertyname_password: ").append(config.servicename_propertyname_password())
				.append("\n\t");
		sb.append("servicename_propertyname_long: ").append(config.servicename_propertyname_long()).append("\n\t");
		sb.append("servicename_propertyname_string: ").append(config.servicename_propertyname_string()).append("\n\t");
		sb.append("servicename_propertyname_string_array: ")
				.append(Arrays.toString(config.servicename_propertyname_string_array())).append("\n\t");
		sb.append("items: ").append(Arrays.toString(config.items())).append("\n\t");
		log.info(sb.toString());
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

	@Override
	public SampleConfig getConfig() {
		log.info(LOGGER_CALLED, "getConfig");
		return SampleConfig.builder().name(config.foo_bar()).maxSize(config.max_size())
				.number(config.servicename_propertyname_long()).build();
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
		String servicename_propertyname_dropdown() default "SECONDS";

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
