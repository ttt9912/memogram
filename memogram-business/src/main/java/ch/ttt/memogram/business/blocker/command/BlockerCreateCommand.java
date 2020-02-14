package ch.ttt.memogram.business.blocker.command;

import ch.ttt.memogram.domain.shared.Timebox;
import lombok.Value;

import java.util.List;

@Value
public class BlockerCreateCommand {
    private String title;
    private List<Timebox> options;
}
