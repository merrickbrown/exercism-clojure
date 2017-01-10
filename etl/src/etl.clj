(ns etl (:require [clojure.string :as string]))

(defn transform
  [scores]
  (into {} (reduce into () (for [[k v] scores]
                             (map #(vector (string/lower-case %) k) v)))))
