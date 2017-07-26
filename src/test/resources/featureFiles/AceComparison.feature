Feature: Compare Stats & Logs between Ace and Old MEC website
  As an automation tester
  I want to compare statistics and logs between two sites
  So that I can reduce my manual effort

  Scenario: Login to OLD Ace Site
    Given I am on "http://arsenic.avallain.com/britanico"
    And I switch to Content Frame
    And I login with User ID "95903" and Password "cigew"
    Then I select Login
    And I select Continue to the MEC area link

    Given I select the Work Area dropdown
    And I select the Statistics & Logs option

    Then I record the Number Of Users
    Then I record the Number Of Courses
#    Then I record the Number Of Classes


#    Scenario: Login to NEW Ace Site
    Given I am on "https://lms-api-sdbmig-uat.macmillan.education/ACE/britanico"
    And I login to the New Site with User ID "bri\95903" and Password "password1"
    Then I select Sign In
    And I record the Number of Users for the New Site
    And I record the Number of Courses for the New Site
#    And I record the Number of Classes for the New Site

    Then I compare Number of Users from OLD Mec to NEW ACE site
    Then I compare Number of Courses from OLD Mec to NEW ACE site

