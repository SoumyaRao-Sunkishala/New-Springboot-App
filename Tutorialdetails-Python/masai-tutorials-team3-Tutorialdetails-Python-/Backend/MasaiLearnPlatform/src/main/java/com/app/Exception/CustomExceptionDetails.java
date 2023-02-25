package com.app.Exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomExceptionDetails {
	
	private LocalDateTime localDateTime;
	private String message;
	private String description;

}
