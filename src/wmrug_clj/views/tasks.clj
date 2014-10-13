(ns wmrug-clj.views.tasks
  (:use [hiccup.core :only (h)]
        [hiccup.form :only (form-to label text-field submit-button)])
  (:require [wmrug-clj.views.layout :as layout]
            [clj-time.format :as f]
            [clj-time.coerce :as c]))

(defn display-form []
  (form-to {:id "task_form"} [:post "/"]
           (label "title" "Title")
           (text-field "title")
           (label "due" "Due")
           (text-field "due")
           (submit-button "Save")))

(defn display-tasks [tasks]
  [:table {:id "tasks"}
   [:tr [:th "Title"][:th "Due"]]
   (map
     (fn [task] 
       [:tr
        [:td (h (:title task))]
        [:td (h (f/unparse (f/formatters :date)(c/from-sql-time (:due task))))]])
     tasks)])

(defn index [tasks]
  (layout/common "Task app"
                 (display-form)
                 [:div {:class "clear"}]
                 (display-tasks tasks)))
