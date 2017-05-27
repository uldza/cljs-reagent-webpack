(ns app.state
  (:require [reagent.core :as r]))

(defonce todos (r/atom (sorted-map)))
