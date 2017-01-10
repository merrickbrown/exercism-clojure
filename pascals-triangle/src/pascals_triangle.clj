(ns pascals-triangle)

(def triangle
  (iterate #(into []  (map + (cons 0 %) (conj % 0))) [(bigint 1)]))

(defn row
  [n]
  (nth triangle (dec n)))
