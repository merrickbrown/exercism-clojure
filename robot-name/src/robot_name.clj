(ns robot-name)

(defn random-name
  []
  (str (apply str (for [i (range 2)] ((into [] "ABCDEFGHIJKLMNOPQRSTUVWXYZ") (int (rand 26))))) (apply str (for [i (range 3)] (int (rand 10)))) ))

(defn robot
  []
  (atom {:name (random-name)}))

(defn robot-name
  [r] (:name @r))

(defn reset-name
  [r]
  (swap! r assoc :name (random-name)))
