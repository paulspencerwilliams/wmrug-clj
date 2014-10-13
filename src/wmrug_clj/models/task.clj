(ns wmrug-clj.models.task
  (:require [clj-time.format :as f]
            [clj-time.coerce :as c])
  (:use [korma.db]
        [korma.core]))



(defdb psql (postgres {:db "tasks"
                       :username "tasks_user"
                       :password "itsasecret"}))

(defentity tasks)

(defn all [] (select tasks (fields :title :due)(order :due :ASC)))

(defn create [title due]
  (insert tasks 
          (values {:title title 
                   :due (c/to-sql-time (f/parse (f/formatters :date) due))})))
