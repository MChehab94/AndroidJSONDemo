package mchehab.com.jsondemo;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by muhammadchehab on 10/26/17.
 */

public class Person {

    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Person(JSONObject jsonObject){
        try{
            firstName = jsonObject.getString(JSONConstants.PERSON_FIRST_NAME);
            lastName = jsonObject.getString(JSONConstants.PERSON_LAST_NAME);
            age = jsonObject.getInt(JSONConstants.PERSON_AGE);
        }catch (JSONException jsonException){
            jsonException.printStackTrace();
        }
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString(){
        return firstName + " " + lastName + " is " + age + " years old";
    }
}
