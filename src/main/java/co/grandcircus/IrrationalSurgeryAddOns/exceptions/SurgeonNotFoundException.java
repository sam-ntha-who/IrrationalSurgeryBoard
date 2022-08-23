package co.grandcircus.IrrationalSurgeryAddOns.exceptions;

public class SurgeonNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public SurgeonNotFoundException(String surgeon) {
		super(surgeon + " not found.");
	}
	

}
