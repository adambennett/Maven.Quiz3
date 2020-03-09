package rocks.zipcode.io.quiz3.collections;

import java.util.*;

/**
 * @author leon on 10/12/2018.
 */
public class Student {

    private List<Lab> labs;

    public Student() {
        this(null);
    }

    public Student(List<Lab> labs) {
        if (labs != null) {
            this.labs = labs;
        } else {
            this.labs = new ArrayList<>();
        }
    }

    public Lab getLab(String labName) {
        for (Lab l : labs) {
            if (l.getName().equals(labName)) {
                return l;
            }
        }
        return null;
    }

    public void setLabStatus(String labName, LabStatus labStatus) {
        for (Lab l : labs) {
            if (l.getName().equals(labName)) {
                if (!l.getStatus().equals(LabStatus.PENDING)) {
                    throw new UnsupportedOperationException("Cannot set the status of a lab that has not been forked!");
                } else {
                    l.setStatus(labStatus);
                    return;
                }
            }
        }
        throw new UnsupportedOperationException("Cannot set the status of a lab that has not been forked!");
    }

    public void forkLab(Lab lab) {
        for (Lab l : labs) {
            if (l.equals(lab)) {
                l.setStatus(LabStatus.PENDING);
                return;
            }
        }
        lab.setStatus(LabStatus.PENDING);
        this.labs.add(lab);
    }

    public LabStatus getLabStatus(String labName) {
        for (Lab l : labs) {
            if (l.getName().equals(labName)) {
                return l.getStatus();
            }
        }
        return null;
    }

    @Override
    public String toString() {
        Collections.sort(this.labs);
        String toRet = "";
        for (Lab l : labs) {
            if (!toRet.equals("")) { toRet += "\n"; }
            toRet += l.getName() + " > " + l.getStatus();
        }
        return toRet;
    }
}
