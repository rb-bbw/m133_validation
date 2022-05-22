package ch.bbw.m133_validation;

import javax.validation.constraints.*;

public class PersonForm {
    @NotBlank // not null or whitespace
    private String name;
    @NotNull(message = "Age must be entered")
    @Min(value = 18, message = "{valid.age.min}")
    @Max(140)
    private Integer age;
    @NotBlank
    @Email // no email is a valid one unless @NotBlank is added
    private String email;


    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return "Person(Name: " + this.name + ", Age: " + this.age + ")";
    }
}
