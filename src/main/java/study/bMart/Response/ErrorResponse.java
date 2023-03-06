package study.bMart.Response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import javax.persistence.criteria.CriteriaBuilder;

@Getter
public class ErrorResponse {

    private Integer code;
    private HttpStatus httpStatus;
    private String message;


    public ErrorResponse(Integer code,HttpStatus httpStatus,String message) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.message = message;
    }
}