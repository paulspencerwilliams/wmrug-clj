(ns wmrug-clj.handler
  (:use [compojure.core :only (defroutes)]
        [ring.adapter.jetty :as ring])
  (:require [compojure.route :as route]
            [compojure.handler :as handler]
            [wmrug-clj.controllers.tasks :as tasks]
            [wmrug-clj.views.layout :as layout]))

(defroutes routes
    tasks/routes
    (route/resources "/"))

(def app
  (handler/site routes))
