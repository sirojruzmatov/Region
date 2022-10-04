package N3.Region.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseDto {

    private Integer code;
    private boolean success;
    private String message;
}
