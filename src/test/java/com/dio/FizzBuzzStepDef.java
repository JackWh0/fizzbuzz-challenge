package com.dio;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzzStepDef {
    private int number;
    private int length;
    private String answer;
    List<String> out;
    Boolean background = false;
    Boolean anotherFlag = false;

    @Given("a number selected by the user - {int}")
    public void selectNumber(int number) {
        this.number = number;
    }

    @When("the user clicked te FizzBuzz button")
    public void fizzBuzz(){
        FizzBuzz fizzBuzz = new FizzBuzz();
        answer = fizzBuzz.render(number);
    }

    @Then("the program prints {word}")
    public void checkAnswer(String expected){
        Assert.assertEquals(expected, answer);
    }

    @Given("the user wants a sequence of {int} numbers")
    public void theUserWantsASequenceOfNumbers(int length) {

        this.length = length;
    }

    @When("the user clicked the FizzBuzzSequence Button")
    public void theUserClickedTheFizzBuzzSequenceButton() {
      Sequence sequence = new Sequence(new FizzBuzz());
        this.out = sequence.generate(length);
    }

    @Then("the program printed:")
    public void theProgramPrinted(List<String> expected) {
        Assert.assertNotNull(out);
        Assert.assertEquals(expected.size() , out.size());
        for (int i = 0; i < expected.size(); i++){
            Assert.assertEquals(expected.get(i), out.get(i));
        }
    }

    @Then("the table must be converted:")
    public void theTableMustBeConverted(List<Person> dataTable) {
        Assert.assertNotNull(dataTable);
        for(Person person: dataTable) {
            System.out.println(person);
        }
    }

    @DataTableType
    public static List<Person> convert(DataTable dataTable) {
        List<Person> list = new ArrayList<>();

        if(dataTable.width() != 4) {
            return null;
        }

        for(List<String> columns : dataTable.cells()) {
            Person person = new Person(columns.get(0), columns.get(1), columns.get(2), Integer.parseInt(columns.get(3)));
            list.add(person);
        }

        return list;
    }

    @And("validate background flags")
    public void validateBackgroundFlag() {
        Assert.assertTrue(background);
        Assert.assertTrue(anotherFlag);
    }

    @Given("the background flag is set")
    public void theBackgroundFlagIsSet() {
       this.background = true;
    }


    @And("another flag is set")
    public void anotherFlagIsSet() {
       this.anotherFlag = true;
    }
}
