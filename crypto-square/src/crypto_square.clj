(ns crypto-square (require [clojure.string :as string]))

(defn normalize-plaintext
  [input]
  (string/replace (string/lower-case input) #"[^0-9a-z]+" ""))

(defn square-size
  [normtext]
  (some #(if (<= (count normtext) (* % %)) % false ) (range)))

(defn plaintext-segments
  [input]
  (let [plaintext (normalize-plaintext input)
        segment-length (square-size plaintext)]
    (into [] (map #(apply str %) (partition-all segment-length plaintext)))))

(defn pad
  ([s n c]
   (.concat s (apply str (repeat (- n (count s)) c))))
  ([s n]
   (pad s n " ")))

(defn normalize-ciphertext
  [input]
  (let [sq (plaintext-segments input)]
    (string/join " " (map string/trim (apply map str
                              (map
                               #(pad % (count (first sq)))
                               sq))))))

(defn ciphertext
  [input]
  (string/replace (normalize-ciphertext input) #"[ ]+" ""))


