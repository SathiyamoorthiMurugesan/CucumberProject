Feature: This feature is to test Guru99 home page

Scenario Outline: Test Home page 
Given user launches the guru99 webpage
Then validate "HomePage"
When user enters text<SearchText> on search and clicks on search button

Examples:
|SearchText|
|"Java"|