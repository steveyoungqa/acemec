Feature: Compare Stats & Logs between Ace and Old MEC website
  As an automation tester
  I want to compare statistics and logs between two sites
  So that I can reduce my manual effort

  Scenario Outline: Login to OLD MEC Site
    Given I am on "<MEC URL>" for "<Institution>"
    And I switch to Content Frame
    And I login with User ID "<MEC User>" and Password "<MEC Password>"
    Then I select Login
    And I select Continue to the MEC area link

    Given I select the Work Area dropdown

    And I select the Statistics & Logs option
    Then I record the Number Of Users

    Then I record the Number Of Courses
    Then I record the Number Of Classes

    And I select the Group Management option
    Then I record the Number of Groups

    And then I log out

#   Login to NEW Ace Site
    Given I am on "<ACE URL>" for "<Institution>"
    And I login to the New Site with User ID "<ACE User>" and Password "<ACE Password>"
    Then I select Sign In

    And I record the Number of Users for the New Site
    Then I go back to the New Site Dashboard
    And I record the Number of Courses for the New Site
    And I record the Number of Classes for the New Site
    And I record the Number of Groups for the New Site


#   COMPARISON TESTS:
    Then I compare Number of Users from OLD Mec to NEW ACE site
    Then I compare Number of Courses from OLD Mec to NEW ACE site
    Then I compare Number of Classes from OLD Mec to NEW ACE site
    Then I compare Number of Groups from OLD Mec to NEW ACE site

    And Then I log out the New Site

    Examples:
      | Institution                               | MEC URL                                             | ACE URL                                                                    | MEC User    | MEC Password | ACE User    | ACE Password | Min User | Student Number |
      | BTL                                       | http://arsenic.avallain.com/btl                     | https://lms-api-sdbmig-uat.macmillan.education/ACE/btl                     | 95903       | mdlifl       | 95903       | mdlifl       | 100      | 168            |
#      | Britanico                                 | http://arsenic.avallain.com/britanico               | https://lms-api-sdbmig-uat.macmillan.education/ACE/britanico               | 95903       | cigew        | 95903       | password1    | 4000     | 4000           |
#      | English in your hands                     | http://arsenic.avallain.com/planetenglish           | https://lms-api-sdbmig-uat.macmillan.education/ACE/planetenglish           | 95903       | phl63        | 95903       | password1    | 2000     | 2000           |
#      | UVL                                       | http://arsenic.avallain.com/Cilondrina              | https://lms-api-sdbmig-uat.macmillan.education/ACE/Cilondrina              | 95903       | cigew        | 95903       | gr33n        | 0        | 802            |
#      | UNIVERSIDAD DE GUADALAJARA                | http://arsenic.avallain.com/udg                     | https://lms-api-sdbmig-uat.macmillan.education/ACE/udg                     | 95903       | 8u7tf        | 95903       | password1    | 2500     | 2500           |
#      | ITESM OCCIDENTE                           | http://arsenic.avallain.com/itesm                   | https://lms-api-sdbmig-uat.macmillan.education/ACE/itesm                   | 95903       | jewe2        | 95903       | password1    | 1000     | 1245           |
#      | BRISTOL INGLES, VERACRUZ                  | http://arsenic.avallain.com/bristolingles           | https://lms-api-sdbmig-uat.macmillan.education/ACE/bristolingles           | 95903       | frei3        | 95903       | password1    | 500      | 586            |
#      | BILKENT                                   | http://arsenic.avallain.com/BilkentUniversity       | https://lms-api-sdbmig-uat.macmillan.education/ACE/BilkentUniversity       | 95903       | pixi66       | 95903       | password1    | 1000     | 2017           |
#      | AYDIN UNIVERSITY                          | http://arsenic.avallain.com/AydinUniversity         | https://lms-api-sdbmig-uat.macmillan.education/ACE/AydinUniversity         | 95903       | qxd46        | 95903       | password1    | 1000     | 1000           |
#      | KULTUR UNIVERSITY                         | http://arsenic.avallain.com/iku                     | https://lms-api-sdbmig-uat.macmillan.education/ACE/iku                     | csaadmin295 | csaadmin295  | csaadmin295 | csaadmin295  | 500      | 600            |
#      | THE UNIVERSITY OF QUEENSLAND              | http://arsenic.avallain.com/universityofqueensland  | https://lms-api-sdbmig-uat.macmillan.education/ACE/universityofqueensland  | 95903       | mhe39        | 95903       | password1    | 500      | 863            |
#      | Boost                                     | http://arsenic.avallain.com/boost                   | https://lms-api-sdbmig-uat.macmillan.education/ACE/boost                   | 95903       | k6g5s        | 95903       | password1    | 450      | 87             |
#      | ILS                                       | http://arsenic.avallain.com/ils                     | https://lms-api-sdbmig-uat.macmillan.education/ACE/ils                     | 95903       | iota9        | 95903       | password1    | 400      | 642            |
#      | MULTIMETHOD                               | http://arsenic.avallain.com/multimethod             | https://lms-api-sdbmig-uat.macmillan.education/ACE/multimethod             | 95903       | MEC03        | 95903       | password1    | 500      | 400            |
#      | UNIVERSIDAD PANAMERICANA, GUADALAJARA     | http://arsenic.avallain.com/up                      | https://lms-api-sdbmig-uat.macmillan.education/ACE/up                      | 95903       | MEC03        | 95903       | password1    | 250      | 446            |
#      | ULA, MEXICO (UNIVERSIDAD LATINOAMERICANA) | http://arsenic.avallain.com/ula                     | https://lms-api-sdbmig-uat.macmillan.education/ACE/ula                     | 95903       | bd962        | 95903       | password1    | 250      | 278            |
#      | CI LONDRINA(+CW)                          | http://arsenic.avallain.com/cilondrina              | https://lms-api-sdbmig-uat.macmillan.education/ACE/cilondrina              |             |              |             |              | 150      | 150            |
#      | INFOLANGUES                               | http://arsenic.avallain.com/infolangues             | https://lms-api-sdbmig-uat.macmillan.education/ACE/infolangues             | 95903       | 8pyet        | 95903       | password1    | 300      | 365            |
#      | EAQUALS                                   | http://arsenic.avallain.com/eaquals                 | https://lms-api-sdbmig-uat.macmillan.education/ACE/eaquals                 | 95903       | 8ikeb        | 95903       | password1    | 250      | 284            |
#      | MUNCHENER VHS                             | http://arsenic.avallain.com/mvhs                    | https://lms-api-sdbmig-uat.macmillan.education/ACE/mvhs                    | 95903       | uzy5ip       | 95903       | uzy5ip       | 250      | 284            |
#      | KATEDRA                                   | http://arsenic.avallain.com/katedra                 | https://lms-api-sdbmig-uat.macmillan.education/ACE/katedra                 |             |              |             |              | 125      | 212            |
#      | PERIOLIOLI LANGUAGES                         | http://arsenic.avallain.com/perioli-language-pilots | https://lms-api-sdbmig-uat.macmillan.education/ACE/perioli-language-pilots | 95903       | dyw22        | 95903       | password1    | 100      | 158            |
#      | UNIVERSIDAD INTERNACIONAL RIOJA           | http://arsenic.avallain.com/unir                    | https://lms-api-sdbmig-uat.macmillan.education/ACE/unir                    |             |              |             |              | 50       | 262            |
#      | PROSTAFF S.R.O                            | http://arsenic.avallain.com/professionalstaff       | https://lms-api-sdbmig-uat.macmillan.education/ACE/professionalstaff       |             |              |             |              | 30       | 14             |
#      | AIBSE                                     | http://arsenic.avallain.com/accademiabritannica     | https://lms-api-sdbmig-uat.macmillan.education/ACE/accademiabritannica     |             |              |             |              | 0        | 496            |
#      | LANGUAGES POINT (WAS SINGLE POINT)        | ?                                                   | ?                                                                          | 95903       | dvda5        | 95903       | password1    | 0        | 70             |
#      | BVV (Bayerischer Volkshochschulverband )  | http://arsenic.avallain.com/bvv                     | http://www.mec-3.com/bvv                                                   | 95903       | 45yes        | 95903       | password1    | 50       | 50             |

  Scenario:
    Then I quit the browser


#    INSTRUCTIONS TO RUN AUTOMATED COMPARISON TESTS:

#    It is best to run each Institution Comparison test one at a time so it easy to keep track of the outputted results
#    UnCommented out the Client you wish to test in the Example table, use CMD + ? on a MAC, move the cursor to the top of this file, right click and Run Feature: AceComparison
#    Use the Example Table to update URLS, Logins and Passwords

#    Courses comparison currently has a -16 rule applied after capturing Old vs New data

#    Ensure that in the webDriver/Driver folder you have set-up the path to your Chrome browser and that it is not commented out
#    i.e: System.setProperty("webdriver.chrome.driver", "/Users/mubeen/Documents/Repos/acemec/selenium/chromedriverOSX");



