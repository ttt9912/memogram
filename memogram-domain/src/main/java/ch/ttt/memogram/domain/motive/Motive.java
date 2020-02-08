package ch.ttt.memogram.domain.motive;

import ch.ttt.memogram.domain.tag.Tag;
import lombok.Value;

import java.util.List;

@Value
public class Motive {
    private final String title;
    // private final String description; TODO
    private final Boolean completed;
    private final List<Tag> tags;
}
