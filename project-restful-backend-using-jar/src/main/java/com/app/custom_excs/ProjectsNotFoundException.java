package com.app.custom_excs;

public class ProjectsNotFoundException extends RuntimeException {
	public ProjectsNotFoundException(String mesg) {
		super(mesg);
	}
}
