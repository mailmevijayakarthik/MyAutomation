$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/Testing Annotations.feature");
formatter.feature({
  "name": "My sample to test Annotations",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "My First scenario",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am in the first step",
  "keyword": "Given "
});
formatter.match({
  "location": "MyFirstClass.i_am_in_the_first_step()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Enter the second step",
  "keyword": "And "
});
formatter.match({
  "location": "MyFirstClass.enter_the_second_step()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter third step",
  "keyword": "When "
});
formatter.match({
  "location": "MyFirstClass.i_enter_third_step()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Answer is fourth step",
  "keyword": "Then "
});
formatter.match({
  "location": "MyFirstClass.answer_is_fourth_step()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});