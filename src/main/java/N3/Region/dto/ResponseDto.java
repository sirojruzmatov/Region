package N3.Region.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //---> class ga getter va setter qo'yib beradi
@Builder //---> Quyidagi ResponsDto method ni boshqa class da ishlatganimizda obyekt olib beradi.
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto<T> {

    private Integer code;    //---> frond end bilan backend chi o'rtasidagi a'loqa vositasi
    private boolean success;
    private String message;
    private T data;
}
