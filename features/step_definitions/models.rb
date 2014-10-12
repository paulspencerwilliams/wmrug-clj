require 'sequel'

Sequel::Model.plugin(:schema)
DB = Sequel.postgres('tasks',
                            :user=>'tasks_user',
                            :password=>'itsasecret',
                            :host=>'localhost',
                            :port=>5432,
                            :max_connections=>10)

unless DB.table_exists? (:tasks)
  DB.create_table :tasks do
    primary_key :id
    string      :title, :null => false
    timestamp   :due
  end
end

class Task < Sequel::Model(:tasks)
end
