package ch.ttt.memogram.datajpa.motive;

import ch.ttt.memogram.datajpa.tag.TagEntityFactory;
import ch.ttt.memogram.domain.motive.Motive;

import java.util.UUID;

public final class MotiveEntityFactory {

    public static MotiveEntity createMotiveEntity(final Motive motive) {
        final MotiveEntity entity = new MotiveEntity();
        entity.setTitle(motive.getTitle());
        entity.setCompleted(motive.getCompleted());
        entity.setTags(TagEntityFactory.createTagEntities(motive.getTags()));
        return entity;
    }
}
