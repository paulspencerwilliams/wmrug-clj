(ns wmrug-clj.models.task
  (:require [clojure.java.jdbc :as sql]))


(def psql {:subprotocol "postgresql"
           :subname "//localhost:5432/tasks"
           :user "tasks_user"
           :password "itsasecret"})

(defn all []

  (sql/query psql
             ["select * from tasks order by due asc"]
             ))
