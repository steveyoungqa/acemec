$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("SampleGoogleSearch.feature");
formatter.feature({
  "line": 1,
  "name": "Sample feature file for writing tests",
  "description": "As an automation tester\nI want to know how to write automation tests in Selenium with Cucumber\nSo that I can reduce my manual effort",
  "id": "sample-feature-file-for-writing-tests",
  "keyword": "Feature"
});
formatter.before({
  "duration": 102635,
  "status": "passed"
});
formatter.before({
  "duration": 354421,
  "status": "passed"
});
formatter.scenario({
  "line": 6,
  "name": "Opening Google, searching for some text and getting back the page title",
  "description": "",
  "id": "sample-feature-file-for-writing-tests;opening-google,-searching-for-some-text-and-getting-back-the-page-title",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "I am on \"http://www.google.com\"",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I search for \"Water on mars\"",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "my web page title is \"Water on mars - Google Search\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "http://www.google.com",
      "offset": 9
    }
  ],
  "location": "SampleSearchStepDefs.i_am_on(String)"
});
formatter.result({
  "duration": 2759511523,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Water on mars",
      "offset": 14
    }
  ],
  "location": "SampleSearchStepDefs.i_search_for(String)"
});
formatter.result({
  "duration": 1559083972,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Water on mars - Google Search",
      "offset": 22
    }
  ],
  "location": "SampleSearchStepDefs.my_web_page_title_is(String)"
});
formatter.result({
  "duration": 106992795,
  "status": "passed"
});
formatter.after({
  "duration": 54148,
  "status": "passed"
});
});