/**
 * 
 */
package com.example.osgi.felix.scr.api.model;

import lombok.Builder;
import lombok.Data;

/**
 * @author resulav
 *
 */
@Data
@Builder
public class SampleConfig {

	private String name;
	private Integer maxSize;
	private Long number;
	
}
