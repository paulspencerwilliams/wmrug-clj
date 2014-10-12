(ns wmrug-clj.views.tasks
  (:use [hiccup.core :only (h)]
        [hiccup.form :only (form-to label text-area submit-button)])
  (:require [wmrug-clj.views.layout :as layout]
            [clj-time.format :as f]
            [clj-time.coerce :as c]))

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
                 [:div {:class "clear"}]
                 (display-tasks tasks)))
