package ch.ttt.memogram.jsonstore.motive;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.List;

@Data
public class MotiveJsonDTO {
    private String title;
    private Boolean completed;
    private List<TagJsonDTO> tags;
}
