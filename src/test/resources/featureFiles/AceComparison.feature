Feature: Compare Stats & Logs between Ace and Old MEC website
  As an automation tester
  I want to compare statistics and logs between two sites
  So that I can reduce my manual effort

  Scenario Outline: Login to OLD MEC Site
    Given I am on "<MEC URL>"
    And I switch to Content Frame
    And I login with User ID "<MEC User>" and Password "<MEC Password>"
    Then I select Login
    And I select Continue to the MEC area link

    Given I select the Work Area dropdown
    And I select the Statistics & Logs option

    Then I record the Number Of Users
    Then I record the Number Of Courses
#    Then I record the Number Of Classes


#    Scenario: Login to NEW Ace Site
    Given I am on "<ACE URL>"
    And I login to the New Site with User ID "<ACE User>" and Password "<ACE Password>"
    Then I select Sign In
    And I record the Number of Users for the New Site
    And I record the Number of Courses for the New Site
#    And I record the Number of Classes for the New Site

    Then I compare Number of Users from OLD Mec to NEW ACE site
    Then I compare Number of Courses from OLD Mec to NEW ACE site

    Examples:
      | MEC URL                                   | ACE URL                                                          | MEC User | MEC Password | ACE User | ACE Password | Country | Region | English Version | Min User | Student Number |
#      | http://arsenic.avallain.com/britanico     | https://lms-api-sdbmig-uat.macmillan.education/ACE/britanico     | 95903    | cigew        | 95903    | password1    | Chile   | 2      | British         | 4000     | 4000           |
#      | http://arsenic.avallain.com/planetenglish | https://lms-api-sdbmig-uat.macmillan.education/ACE/planetenglish | 95903    | cigew        | 95903    | password1    | Chile   | 2      | British         | 2000     | 2000           |
      | http://arsenic.avallain.com/udg           | https://lms-api-sdbmig-uat.macmillan.education/ACE/udg           | 95903    | 8u7tf        | 95903    | password1    | Chile   | 2      | British         | 2500     | 2500           |


