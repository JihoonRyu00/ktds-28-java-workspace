package com.ktdsuniversity.edu.oop.exceptions;

public class HolderInitiateException extends RuntimeException {

//	public class RuntimeException extends Exception {
//	    @java.io.Serial
//	    static final long serialVersionUID = -7034897190745766939L;
//
//	    /** Constructs a new runtime exception with {@code null} as its
//	     * detail message.  The cause is not initialized, and may subsequently be
//	     * initialized by a call to {@link #initCause}.
//	     */
//	    public RuntimeException() {
//	        super();
//	    }
	    
	private static final long serialVersionUID = -4766163612547661107L;

	public HolderInitiateException(String message) {
		super(message);
	}
}
