package study.bMart.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountResponse {

    private Integer code;
    private HttpStatus httpStatus;
    private String message;


}
