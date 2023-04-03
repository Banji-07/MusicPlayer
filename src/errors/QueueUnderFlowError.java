package errors;

import java.util.NoSuchElementException;

public class QueueUnderFlowError extends NoSuchElementException {
    public QueueUnderFlowError(String s) {
        super(s);
    }
}
