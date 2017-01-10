(ns gigasecond
  (require [clojure.instant :as instant])
  (import java.util.Calendar)) 

(defn from
  [year month date]
  (let [c (Calendar/getInstance)
        yearfield Calendar/YEAR
        monthfield Calendar/MONTH
        datefield Calendar/DATE]
    (.clear c)
    (.set c year (dec month) date)
    (.add c Calendar/SECOND 1e9)

    [(.get c yearfield) (inc (.get c monthfield)) (.get c datefield)]))
