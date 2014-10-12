(ns wmrug-clj.views.layout
  (:use [hiccup.core :only (html)]
        [hiccup.page :only (html5 include-css)]))

(defn common [title & body]
  (html5
    [:head
     [:meta {:charset "utf-8"}]
     [:title title]]
    [:body
     [:div {:id "header"}
      [:h1 {:class "container"} "Tasks"]]
     [:div {:id "content" :class "container"} body]]))
