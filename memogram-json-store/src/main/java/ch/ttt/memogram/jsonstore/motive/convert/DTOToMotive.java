package ch.ttt.memogram.jsonstore.motive.convert;

import ch.ttt.memogram.domain.motive.Motive;
import ch.ttt.memogram.domain.tag.Tag;
import ch.ttt.memogram.jsonstore.common.Converter;
import ch.ttt.memogram.jsonstore.motive.MotiveJsonDTO;
import ch.ttt.memogram.jsonstore.motive.TagJsonDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

public final class DTOToMotive implements Converter<MotiveJsonDTO, Motive> {

    @Override
    public Motive convert(final MotiveJsonDTO element) {
        return new Motive(
                element.getTitle(),
                element.getCompleted(),
                createTags(element.getTags()));
    }

    private List<Tag> createTags(final List<TagJsonDTO> tags) {
        return tags.stream()
                .map(this::createTag)
                .collect(Collectors.toList());
    }

    private Tag createTag(final TagJsonDTO tagJsonDto) {
        return new Tag(tagJsonDto.getName());
    }
}
