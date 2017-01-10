(ns atbash-cipher (require [clojure.string :as string]))

(defn encode
  [plaintext]
  (let [cleaned (string/replace
                 (string/lower-case plaintext)
                 #"[^a-z0-9]+"
                 "")
        letters "abcdefghijklmnopqrstuvwxyz"
        numbers "1234567890"
        code (into
              {}
              (concat
               (map #(vector %1 %2)
                    letters
                    (reverse letters))
               (map #(vector % %)
                    numbers)))]
    (string/join " "
     (map #(apply str %) (partition-all 5 (map code cleaned))))))
