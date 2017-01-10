(ns triangle)

(defn type
  [a b c]
  (let [[s1 s2 s3 :as sides] (sort (list a b c))]
    (cond
     (some #(>= 0 %) sides) :illogical
     (<= (+ s1 s2) s3) :illogical
     (= s1 s3) :equilateral
     (or (= s1 s2) (= s2 s3)) :isosceles
     :default :scalene)))
