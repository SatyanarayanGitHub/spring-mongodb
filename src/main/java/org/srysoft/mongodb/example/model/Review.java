package org.srysoft.mongodb.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author SATYA
 *
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Review {
	private String userName;
	private int rating;
	private boolean approved;

}