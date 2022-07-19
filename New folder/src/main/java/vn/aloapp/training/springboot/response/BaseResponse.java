/**
 * 
 */
package vn.aloapp.training.springboot.response;

import org.springframework.http.HttpStatus;

/**
 * @author longnguyen
 *
 */
public class BaseResponse {
	
	private int status;
    private String message;
    private Object data;
    
    public BaseResponse() {
		this.setStatus(HttpStatus.OK);
		this.setMessage(HttpStatus.OK);
		this.setData(null);
    }
    
	public int getStatus() {
		return status;
	}
	public void setStatus(HttpStatus statusEnum) {
		this.status = statusEnum.value();
		this.message = statusEnum.name();
	}
	public String getMessage() {
		return this.message;
	}
	public void setMessage(HttpStatus statusEnum) {
		this.message = statusEnum.name();
	}
	
	public void setMessageError(String message) {
		this.message = message;
	}
	
	public Object getData() {
		return data;
	}
	
	public void setData(Object data) {
		this.data = data;
	}

}
