package com.example.wiatrak.ui.theme;

import java.io.Serializable;

public class ClassSchedule implements Serializable {
    private String dayOfWeek;
    private String hour; // Змінено на String
    private String subject;
    private boolean isEvenWeek;

    // Конструктор класу
    public ClassSchedule(String dayOfWeek, String hour, String subject, boolean isEvenWeek) {
        this.dayOfWeek = dayOfWeek;
        this.hour = hour;
        this.subject = subject;
        this.isEvenWeek = isEvenWeek;
    }

    // Геттери
    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public String getHour() { // Змінено повертаємий тип
        return hour;
    }

    public String getSubject() {
        return subject;
    }

    public boolean isEvenWeek() {
        return isEvenWeek;
    }

    // Сеттери
    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public void setHour(String hour) { // Змінено тип параметра
        this.hour = hour;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setEvenWeek(boolean isEvenWeek) {
        this.isEvenWeek = isEvenWeek;
    }

    // Перевизначений метод toString()
    @Override
    public String toString() {
        return "ClassSchedule{" +
                "dayOfWeek='" + dayOfWeek + '\'' +
                ", hour='" + hour + '\'' + // Змінено формат
                ", subject='" + subject + '\'' +
                ", isEvenWeek=" + isEvenWeek +
                '}';
    }
}
