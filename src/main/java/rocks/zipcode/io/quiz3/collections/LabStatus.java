package rocks.zipcode.io.quiz3.collections;

/**
 * @author leon on 10/12/2018.
 * Ensure there are enumerations for, `COMPLETED`, `INCOMPLETE`, `PENDING`
 */
public enum LabStatus implements Comparable<LabStatus> {
    COMPLETED(1), INCOMPLETE(2), PENDING(3);

    private int value;

    LabStatus(int value) {
        this.value = value;
    }

    public int getValue() { return value; }
}
