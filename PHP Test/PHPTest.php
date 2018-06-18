<?php
// Setup: $ php composer.phar require facebook/webdriver

require_once('vendor/autoload.php');
use Facebook\WebDriver\Remote\RemoteWebDriver;
use Facebook\WebDriver\WebDriverBy;

$web_driver = RemoteWebDriver::create(
    "https://phillipramirez:8d1823e8-289b-4737-b678-87e93623ca94@ondemand.saucelabs.com:443/wd/hub",
    array("name"=> "PHP Test" ,"platform"=>"Windows 10", "browserName"=>"chrome", "version"=>"latest")
    );
$web_driver->get("https://www.dorkly.com");

/*
 Test actions here...
 */

$web_driver->quit();
?>