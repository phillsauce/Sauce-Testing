require "selenium/webdriver"
 
caps = {
  :platform => "Windows 7",
  :browserName => "Chrome",
  :version => "45",
  :name => 'Ruby Tests'
}
 
driver = Selenium::WebDriver.for(:remote,
    :url => "https://phillipramirez:8d1823e8-289b-4737-b678-87e93623ca94@ondemand.saucelabs.com:443/wd/hub",
    :desired_capabilities => caps)
 
driver.get('https://kotaku.com')
 
puts "title of webpage is: #{driver.title()}"
 
driver.quit()