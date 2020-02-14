package ch.ttt.memogram.business.blocker.command;

import ch.ttt.memogram.domain.shared.Timebox;
import lombok.Value;

import java.util.List;

@Value
public class BlockerUpdateCommand {
    private String uuid;
    private String title;
    private List<Timebox> options;
}
