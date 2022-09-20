#Day 1 AGENDA
  #Set up Github repository and familiarize ourselves with Git add --> Git Commit --> Git Push --> Git Fetch --> Git Pull. Git Checkout, creating a new branch with git
Feature: Prudential Home Page

  @websiteTitleValidation
  Scenario Outline: user confirms website title is expected
    Given User launches chrome
    When User navigates to "<website>"
    Then User confirms the website title is "Invest, Insure, Retire and Plan | Prudential Financial"
    Then User closes chrome


    Examples:
      |website|
      | https://www.prudential.com/|

  #Day1
  # what did we accomplish today?
  #korab
  #we just automated the prudential title validation, the next step is to go through the slideshow
  #paulina
  #We set up our dependencies, we learned basic functionalities of cucumber with it's gherkin statements, we learned how gherkin statements connect with the actual code,
  #Diar
  #Today we did set up for github repositories and learned git add, git push, git fetch, and git pull commands. We all created our own branches, contributed to them and merged the branches into master. We set up the dependencies for our cucumber framework, we created a cucumber runner class to execute our feature files stored in our project, and we created a test scenario to assert that the actual title of the page equals the expected title for the page.

  #Day 2 Agenda
  #Create Functional Epic and User story tickets for Prudential Landing with acceptance criteria

  #Day 3 Agenda
  #Develop cucumber Test Scenario using gherkin syntax
  #Create test scripts necessary to execute cucumber test scenario

  #Start of day 3
  @validateLandingSlideshowNavigation
  Scenario Outline: verifying navigation of slideshow
    Given User launches chrome
    When User navigates to "<website>"
    Then User confirms the website title is "Invest, Insure, Retire and Plan | Prudential Financial"
    And user confirms first slide appears
    When user clicks on plan for your future
    Then user confirms second slide appears
    When user clicks on reach your investment goals
    Then user confirms third slide appears
    When user clicks plan for future
    Then user confirms second slide appears
    When user clicks on insure your family
    Then user confirms first slide appears
    When user clicks on Reach your investing goals
    Then user confirms third slide appears
    When user clicks on insure your family
    Then user confirms first slide appears

    Examples:
      |website|
      | https://www.prudential.com/|





  #End of day 3