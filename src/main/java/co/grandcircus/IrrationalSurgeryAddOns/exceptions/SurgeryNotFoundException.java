package co.grandcircus.IrrationalSurgeryAddOns.exceptions;

public class SurgeryNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public SurgeryNotFoundException(String id) {
		super("Surgical Case: " + id + " not found.");
	}
	

}
