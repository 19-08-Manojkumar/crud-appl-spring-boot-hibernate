package customer.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //to handle exception globally
public class CustomerExceptionHandler
{
	@ExceptionHandler //to catch customer not found exception
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException e)
	{
		CustomerErrorResponse error = new CustomerErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<CustomerErrorResponse>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler //to handle other exceptions
	public ResponseEntity<CustomerErrorResponse> handleException(Exception e)
	{
		CustomerErrorResponse error = new CustomerErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(e.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<CustomerErrorResponse>(error,HttpStatus.BAD_REQUEST);
	}
}
