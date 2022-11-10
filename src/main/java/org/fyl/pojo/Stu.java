package org.fyl.pojo;

import java.util.Objects;

public class Stu {
    private String gradeAndClass;
    private String name;
    private String room;
    private String id;

    @Override
    public String toString() {
        return "Stu{" +
                "gradeAndClass='" + gradeAndClass + '\'' +
                ", name='" + name + '\'' +
                ", room='" + room + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public String getGradeAndClass() {
        return gradeAndClass;
    }

    public void setGradeAndClass(String gradeAndClass) {
        this.gradeAndClass = gradeAndClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Stu() {
    }

    public Stu(String gradeAndClass, String name, String room, String id) {
        this.gradeAndClass = gradeAndClass;
        this.name = name;
        this.room = room;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stu stu = (Stu) o;
        return Objects.equals(id, stu.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
