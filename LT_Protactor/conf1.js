var HtmlScreenshotReporter = require('protractor-jasmine2-screenshot-reporter');

var reporter = new HtmlScreenshotReporter({
  dest: 'LT_target/screenshots',
  filename: 'my-report.html'
});



// An example configuration file.
exports.config = {
  directConnect: true,

  specs: ['TestScript.js'],

// Setup the report before any tests start
beforeLaunch: function() {
  return new Promise(function(resolve){
    reporter.beforeLaunch(resolve);
  });
},

// Assign the test reporter to each running instance
onPrepare: function() {
  jasmine.getEnv().addReporter(reporter);


  var AllureReporter = require('jasmine-allure-reporter');
  jasmine.getEnv().addReporter(new AllureReporter({
    resultsDir: 'allure-results'
  }));



},

// Close the report after all tests finish
afterLaunch: function(exitCode) {
  return new Promise(function(resolve){
    reporter.afterLaunch(resolve.bind(this, exitCode));
  });
}






};