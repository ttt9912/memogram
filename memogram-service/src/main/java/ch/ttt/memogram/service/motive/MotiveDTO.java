package ch.ttt.memogram.service.motive;

import ch.ttt.memogram.domain.tag.Tag;
import lombok.Value;

import java.util.List;

@Value
public class MotiveDTO {
    private final String uuid;
    private final String title;
    private final Boolean completed;
    private final List<Tag> tags;
}
