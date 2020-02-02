package ch.ttt.memogram.datajpa.tag;

import ch.ttt.memogram.domain.tag.Tag;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public final class TagEntityFactory {

    public static List<TagEntity> createTagEntities(final List<Tag> tags) {
        return tags.stream()
                .map(TagEntityFactory::createTagEntity)
                .collect(Collectors.toList());
    }

    private static TagEntity createTagEntity(final Tag tag) {
        final TagEntity entity = new TagEntity();
        entity.setName(tag.getName());
        return entity;
    }
}
