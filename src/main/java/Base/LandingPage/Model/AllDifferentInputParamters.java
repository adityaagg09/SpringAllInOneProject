package Base.LandingPage.Model;


import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

// @JsonIgnoreProperties({"firstName", "lastName"}) We will not receive and can't send value but can play in between code
@JsonPropertyOrder({"firstName", "lastName", "age", "salary"}) //when u want to send the data in a particular order
@JsonInclude(value = JsonInclude.Include.NON_EMPTY) //Don't send fields which are null
@JsonIgnoreProperties(ignoreUnknown = true)
public class AllDifferentInputParamters implements Serializable, Cloneable {

    @JsonProperty(value = "First_Name") //  Req & resp of it has name now First_name not firstName
    private String firstName;

    @JsonRawValue // We can now map json string to class whether it's return type is string not
    private String lastName;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // Now whatever rqst we receive will not populate, only we can add it
    private Integer age;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY) // Now whatever rqst we receive will only, can't populate
    private Integer salary;

    private String sex;

    @JsonFormat( shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss") // Date ko isme format send krna nho toh pta ni kuch ka kuch ata ha
    private String Date;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @JsonGetter("Gendi") // Ui se vales agar is name se aie toh isme map hogi woh
    public String getSex() {
        return sex;
    }

    @JsonSetter("Gender") // Jb response send hoga tb is name se data jaiga
    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public AllDifferentInputParamters clone() throws  CloneNotSupportedException {
        return  (AllDifferentInputParamters) super.clone() ;
    }

}
