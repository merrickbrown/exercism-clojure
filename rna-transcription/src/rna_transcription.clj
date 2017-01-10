(ns rna-transcription (:require [clojure.string :as string]))

(defn to-rna
  [dna-seq]
  (string/join (map #(or ({\C \G, \G \C, \A \U, \T \A} %) (throw (AssertionError.) )) dna-seq))
)
