package proje.sorubankasi.dto.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WebSocketDTO {

 private Long seconds;
 public WebSocketDTO(Long seconds){
     this.seconds=seconds;
 }

}
