(ns space-age)

 ;; Earth: orbital period 365.25 Earth days, or 31557600 seconds
(defn on-earth [secs] (double (/ secs 31557600)))
(defn age-with-period [period] (fn [secs] (/ (on-earth secs) period)))
 ;; Mercury: orbital period 0.2408467 Earth years
(def on-mercury (age-with-period 0.2408467))
 ;; Venus: orbital period 0.61519726 Earth years
(def on-venus (age-with-period 0.61519726))
 ;; Mars: orbital period 1.8808158 Earth years
(def on-mars (age-with-period 1.8808158))
 ;; Jupiter: orbital period 11.862615 Earth years
(def on-jupiter (age-with-period 11.862615))
 ;; Saturn: orbital period 29.447498 Earth years
(def on-saturn (age-with-period 29.447498))
 ;; Uranus: orbital period 84.016846 Earth years
(def on-uranus (age-with-period 84.016846))
 ;; Neptune: orbital period 164.79132 Earth years
(def on-neptune (age-with-period 164.79132))
