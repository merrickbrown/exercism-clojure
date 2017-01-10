(ns perfect-numbers)

(defn classify
  [n]
  (if (< n 0)
    (throw (new IllegalArgumentException "classify is only defined for non-negative integers"))
    (let [content (reduce + 0 (filter #(= 0 (mod n %)) (range 1 (inc (int (/ n 2))))))]
      (cond
       (< content n) :deficient
       (= content n) :perfect
       (> content n) :abundant))))
