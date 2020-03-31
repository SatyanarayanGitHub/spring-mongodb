package org.srysoft.mongodb.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author SATYA
 *
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Review {
	private String userName;
	private int rating;
	private boolean approved;

}