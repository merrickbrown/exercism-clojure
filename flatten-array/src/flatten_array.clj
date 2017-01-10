(ns flatten-array)

(defn flatten
  [arr]
  (reduce #(if (vector? %2) (into %1 (flatten %2)) (if (nil? %2) %1 (conj %1 %2))) [] arr))
