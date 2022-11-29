package gr.codehub.jpademo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultApi <T>{

    private T data;
    private int errorCode;
    private String Description;

}
