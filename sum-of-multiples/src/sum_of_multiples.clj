(ns sum-of-multiples)

(defn sum-of-multiples
  ([divs]
   (fn [coll]
     (transduce
      (filter
       (fn
         [k]
         (some #(= 0 (mod k %)) divs)))
      +
      coll)))
  ([divs n]
   ((sum-of-multiples divs) (range n))))
