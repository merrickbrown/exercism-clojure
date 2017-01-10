(ns binary-search)

(defn middle
  [coll]
  (int (/ (count coll) 2)))

(defn search-for
  ([key coll]
   (search-for key coll {:eq =, :lt <}))
  ([key coll {eq :eq, lt :lt}]
   (if (or (= 0 (count coll)) (and (= 1 (count coll)) (not (eq key (first coll)))))
     (throw (new Throwable "not found"))
     (let [length (count coll)
           middle-index (int (/ length 2))
           first-half (take middle-index coll)
           last-half (take-last (- length middle-index) coll)]
       (cond
        (eq key (first last-half)) middle-index
        (lt key (first last-half)) (search-for key first-half)
        :default (+ middle-index (search-for key last-half))
        )))))
