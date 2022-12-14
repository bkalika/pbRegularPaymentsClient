package com.pb.dto;

/**
 * @author @bkalika
 */
public class SenderDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Long inn;

    public SenderDto() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return firstName;
    }

    public void setFirst_name(String firstName) {
        this.firstName = firstName;
    }

    public String getLast_name() {
        return lastName;
    }

    public void setLast_name(String lastName) {
        this.lastName = lastName;
    }

    public Long getInn() {
        return inn;
    }

    public void setInn(Long inn) {
        this.inn = inn;
    }

    @Override
    public String toString() {
        return "SenderDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", inn=" + inn +
                '}';
    }
}
