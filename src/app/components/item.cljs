(ns app.components.item
  (:require [reagent.core :as r]
            [app.components.input :refer [todo-edit]]))

(defn todo-item []
  (let [editing (r/atom false)]
    (fn [{:keys [id done title]}
         {:keys [on-toggle on-delete on-save]}]
      [:li {:class (str (if done "completed ")
                        (if @editing "editing"))}
       [:div.view
        [:input.toggle {:type "checkbox" :checked done
                        :on-change #(on-toggle id)}]
        [:label {:on-double-click #(reset! editing true)} title]
        [:button.destroy {:on-click #(on-delete id)}]]
       (when @editing
         [todo-edit {:class "edit" :title title
                     :on-save #(on-save id %)
                     :on-stop #(reset! editing false)}])])))
