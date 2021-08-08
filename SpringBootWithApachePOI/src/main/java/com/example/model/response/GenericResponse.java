package com.example.model.response;

public class GenericResponse {

	private String status;
	private String message;
	private String filepath;
	private Object responsebody;
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getResponsebody() {
		return responsebody;
	}
	public void setResponsebody(Object responsebody) {
		this.responsebody = responsebody;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	
	
}
