package org.srysoft.mongodb.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @author SATYA
 *
 */

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	private String city;
	private String country;

}