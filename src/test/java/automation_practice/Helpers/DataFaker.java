package automation_practice.Helpers;

import com.github.javafaker.Faker;

public class DataFaker
{
    Faker faker = new Faker();

    public String setFirstName()
    {
        return faker.name().firstName();
    }
    public String setLastName()
    {
        return faker.name().lastName();
    }
    public String setPassword()
    {
        return faker.internet().password();
    }
    public String setEmailAddress()
    {
        return faker.internet().emailAddress();
    }
    public String setAddress()
    {
        return faker.address().streetAddress();
    }
    public String setCity()
    {
        return faker.address().cityName();
    }
    public String setMobilePhoneNumber()
    {
        return faker.phoneNumber().cellPhone();
    }

}
