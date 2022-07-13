package org.ioc.model;

public class Group_Name {
    String Name, Course, NumberGroup, Year, IdOfGroup;
    public Group_Name(String name, String course, String numberGroup, String year, String idOfGroup){
        this.Name = name;
        this.Course = course;
        this.IdOfGroup = idOfGroup;
        this.NumberGroup = numberGroup;
        this.Year = year;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCourse() {
        return Course;
    }

    public void setCourse(String course) {
        Course = course;
    }

    public String getNumberGroup() {
        return NumberGroup;
    }

    public void setNumberGroup(String numberGroup) {
        NumberGroup = numberGroup;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getIdOfGroup() {
        return IdOfGroup;
    }

    public void setIdOfGroup(String idOfGroup) {
        IdOfGroup = idOfGroup;
    }
}
