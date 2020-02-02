package ch.ttt.memogram.datajpa.tag;

import ch.ttt.memogram.domain.tag.Tag;

import java.util.List;
import java.util.stream.Collectors;

public final class TagFactory {

    public static List<Tag> createTags(final List<TagEntity> entities) {
        return entities.stream()
                .map(TagFactory::createTag)
                .collect(Collectors.toList());
    }

    private static Tag createTag(final TagEntity tagEntity) {
        return new Tag(tagEntity.getName());
    }
}
