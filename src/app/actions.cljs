(ns app.actions)

(defonce counter (atom 0))

(defn- mmap [m f a] (->> m (f a) (into (empty m))))

(defn add-todo [todos text]
  (let [id (swap! counter inc)]
    (swap! todos assoc id {:id id :title text :done false})))

(defn toggle [todos id] (swap! todos update-in [id :done] not))
(defn save [todos id title] (swap! todos assoc-in [id :title] title))
(defn delete [todos id] (swap! todos dissoc id))
(defn complete-all [todos v] (swap! todos mmap map #(assoc-in % [1 :done] v)))
(defn clear-done [todos] (swap! todos mmap remove #(get-in % [1 :done])))
