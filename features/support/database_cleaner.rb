require 'database_cleaner'
require 'database_cleaner/cucumber'
require 'sequel'

DatabaseCleaner[:sequel, {:connection => Sequel.connect('postgres://tasks_user:itsasecret@localhost/tasks')}]
DatabaseCleaner.strategy = :truncation

Around do |scenario, block|
  DatabaseCleaner.cleaning(&block)
end
