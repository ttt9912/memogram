package ch.ttt.memogram.datajpa.motive;

import ch.ttt.memogram.datajpa.tag.TagFactory;
import ch.ttt.memogram.domain.motive.Motive;

public class MotiveFactory {

    public static Motive createMotive(final MotiveEntity entity) {
        return new Motive(
                entity.getTitle(),
                entity.getCompleted(),
                TagFactory.createTags(entity.getTags()));
    }
}
