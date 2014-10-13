Given(/^the following tasks$/) do |tasks_to_create|
  tasks_to_create.map_headers! {|header| header.downcase.to_sym }
  tasks_to_create.hashes.each do |attributes|
    Task.create(attributes)
  end
end

When(/^I visit the homepage$/) do
  visit ('http://localhost:3000')
end

When(/^I add a task to "(.*?)" due "(.*?)"$/) do |title, due|
  visit ('http://localhost:3000')
  within("#task_form") do
    fill_in 'Title', :with => title
    fill_in 'Due', :with => due 
    click_button 'Save'
  end
end

Then(/^will see the following tasks$/) do |expected_tasks|
  rows = find("table#tasks").all('tr')
  table = rows.map { |r| r.all('th,td').map { |c| c.text.strip } }
  expected_tasks.diff!(table)
end

