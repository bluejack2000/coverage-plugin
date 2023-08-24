package io.jenkins.plugins.coverage.metrics.model;

import java.util.Objects;

import org.kohsuke.stapler.export.Exported;
import org.kohsuke.stapler.export.ExportedBean;

/**
 * Model class containing data pertained to consecutive lines of modified code. Each object possesses a starting and
 * ending line number and the type of coverage of the block. Each object is associated with a FileWithModifiedLines
 * object.
 */
@ExportedBean
public class ModifiedLinesBlock {
    private final int startLine;
    private final int endLine;
    private final LineCoverageType type;

    /**
     * Constructor for the ModifiedLinesBlock class.
     *
     * @param startLine
     *         number of the first line of code associated with this block.
     * @param endLine
     *         number of the last line of code associated with this block.
     * @param type
     *         type of coverage.
     */
    public ModifiedLinesBlock(final int startLine, final int endLine, final LineCoverageType type) {
        this.startLine = startLine;
        this.endLine = endLine;
        this.type = type;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ModifiedLinesBlock)) {
            return false;
        }
        ModifiedLinesBlock that = (ModifiedLinesBlock) o;
        return getStartLine() == that.getStartLine() && getEndLine() == that.getEndLine()
                && getType() == that.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStartLine(), getEndLine(), getType());
    }

    @Exported
    public int getStartLine() {
        return startLine;
    }

    @Exported
    public int getEndLine() {
        return endLine;
    }

    @Exported
    public LineCoverageType getType() {
        return type;
    }

}
