package com.banking.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Data
@ToString
public class DatabaseSequence {
	
	@Id
    private String id;
 	private long seq;

}
