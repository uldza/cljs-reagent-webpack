(ns app.components.app
  (:require [reagent.core :as r]
            [app.actions :as actions]
            [app.components.item :refer [todo-item]]
            [app.components.input :refer [todo-input]]
            [app.components.stats :refer [todo-stats]]))

(defn todo-app [todos]
  (let [filt (r/atom :all)]
    (fn []
      (let [items (vals @todos)
            done (->> items (filter :done) count)
            active (- (count items) done)]
        [:div
         [:section#todoapp
          [:header#header
           [:h1 "todos"]
           [todo-input {:id "new-todo"
                        :placeholder "What needs to be done?"
                        :on-save #(actions/add-todo todos %)}]]
          (when (-> items count pos?)
            [:div
             [:section#main
              [:input#toggle-all {:type "checkbox" :checked (zero? active)
                                  :on-change #(actions/complete-all todos (pos? active))}]
              [:label {:for "toggle-all"} "Mark all as complete"]
              [:ul#todo-list
               (for [todo (filter (case @filt
                                    :active (complement :done)
                                    :done :done
                                    :all identity) items)]
                 ^{:key (:id todo)} [todo-item todo {:on-toggle #(actions/toggle todos %)
                                                     :on-save #(actions/save todos %1 %2)
                                                     :on-delete #(actions/delete todos %)}])]]
             [:footer#footer
              [todo-stats {:active active
                           :done done
                           :filt filt
                           :on-clear #(actions/clear-done todos)}]]])]
         [:footer#info
          [:p "Double-click to edit a todo"]]]))))
