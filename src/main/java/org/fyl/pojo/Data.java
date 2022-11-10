package org.fyl.pojo;

public class Data {
    private String gradeAndClass;
    private String date;
    private String inf;

    public Data(String gradeAndClass, String date, String inf) {
        this.gradeAndClass = gradeAndClass;
        this.date = date;
        this.inf = inf;
    }

    public Data() {
    }

    public String getGradeAndClass() {
        return gradeAndClass;
    }

    public void setGradeAndClass(String gradeAndClass) {
        this.gradeAndClass = gradeAndClass;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getInf() {
        return inf;
    }

    public void setInf(String inf) {
        this.inf = inf;
    }

    @Override
    public String toString() {
        return "Data{" +
                "gradeAndClass='" + gradeAndClass + '\'' +
                ", date='" + date + '\'' +
                ", inf='" + inf + '\'' +
                '}';
    }
}
