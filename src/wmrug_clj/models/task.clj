(ns wmrug-clj.models.task
  (:require [clojure.java.jdbc :as sql]
            [clj-time.format :as f]
            [clj-time.coerce :as c]))


(def psql {:subprotocol "postgresql"
           :subname "//localhost:5432/tasks"
           :user "tasks_user"
           :password "itsasecret"})

(defn all []
  (sql/query psql ["select * from tasks order by due asc"]))

(defn create [title due]
  (sql/insert! psql 
               :tasks 
               [:title :due] 
               [title (c/to-sql-time (f/parse (f/formatters :date) due))]))
