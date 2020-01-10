#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Testing Restful webservices
  I want to use this template for my feature file

  @GET_Restful
  Scenario: GET the Restservice details , store its detail and retrive it in the next step
    Given build the url for service
    And needed parameters added to the API
    When run GET restservice details
    Then validate the reponse details

 @POST_Restful
  Scenario: POST the Restservice details , store its detail and retrive it in the next step
    Given build the url for service
    And needed parameters added to the API
    When run GET restservice details
    And build url and parameter for posting reservation in a happy path
   
