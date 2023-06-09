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
@2
Feature: Home Page
  #I want to use this template for my feature file

  @tag
  Scenario: user navigates to homepage
   
    #Scenario: User navigate to home page
    Given User click on Data Structures dropdown
    When  User click on arrays from the dropdown
    Then  It  shows error message "You are not logged in"
  
  
  Scenario: Launch url and navigate to home page
    When User click on one of the module from home page
    Then It is showing error message You are not logged in
