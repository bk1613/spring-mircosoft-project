package com.synex.controller;

public class SafeShutdownException extends RuntimeException{

	public SafeShutdownException(String message) {
		super(message);
	}
	
}
