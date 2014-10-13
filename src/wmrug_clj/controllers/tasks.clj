(ns wmrug-clj.controllers.tasks
  (:use [compojure.core :only (defroutes GET POST)])
  (:require [clojure.string :as str]
            [ring.util.response :as ring]
            [wmrug-clj.views.tasks :as view]
            [wmrug-clj.models.task :as model]))

(defn index []
  (view/index (model/all)))

(defn create
  [title due]
  (model/create title due)
  (ring/redirect "/"))

(defroutes routes
  (GET  "/" [] (index))
  (POST "/" [title due] (create title due)))
