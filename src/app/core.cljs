(ns app.core
  (:require [reagent.core :as r]
            [app.components.app :refer [todo-app]]
            [app.state :as state]
            [app.actions :as actions]))

(defonce init
  (do
    (actions/add-todo state/todos "Rename Cloact to Reagent")
    (actions/add-todo state/todos "Add undo demo")
    (actions/add-todo state/todos "Make all rendering async")
    (actions/add-todo state/todos "Allow any arguments to component functions")
    (actions/complete-all state/todos true)))

(r/render [todo-app state/todos]
          (js/document.getElementById "app"))
