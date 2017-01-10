(ns meetup)

(defn leap
  [year]
  (cond
   (= 0 (mod year 400)) true
   (= 0 (mod year 100)) false
   (= 0 (mod year 4)) true
   :default false))

(def days [:saturday :sunday :monday :tuesday :wednesday :thursday :friday])
(defn month-length [month year]
  ([31 (if (leap year) 29 28) 31 30 31 30 31 31 30 31 30 31] (dec month)))

(defn day 
  [date month year]
  (days (mod (+
            date
            (int (/ (mod year 100) 4))
            ([1 4 4 0 2 5 0 3 6 1 4 6] (dec month))
            (if
                (and (leap year) (or (= month 1) (= month 2)))
              -1
              0)
            ([6 4 2 0] (int (/ (mod year 400) 100)))
            (mod year 100))
           7)) )



(defn calendar-days
  [month year]
  (take (month-length month year)  (drop-while #(not= (day 1 month year) %) (cycle days))))

(defn calendar-dates
  [month year]
  (range 1 (inc (month-length month year))))

(defn firsts
  [month-calendar]
  (concat
   (repeat 7 '(:first))
   (drop 7 (repeat (count month-calendar) '()))))

(defn seconds
  [month-calendar]
  (concat
   (repeat 7 '())
   (repeat 7 '(:second))
   (drop 14 (repeat (count month-calendar) '()))))

(defn thirds
  [month-calendar]
  (concat
   (repeat 14 '())
   (repeat 7 '(:third))
   (drop 21 (repeat (count month-calendar) '()))))

(defn fourths
  [month-calendar]
  (concat
   (repeat 21 '())
   (repeat 7 '(:fourth))
   (drop 28 (repeat (count month-calendar) '()))))

(defn lasts
  [month-calendar]
  (concat
   (drop 7 (repeat (count month-calendar) '()))
   (repeat 7 '(:last))))

(defn teenths
  [month-calendar]
  (concat
   (repeat 12 '())
   (repeat 7 '(:teenth))
   (drop 19 (repeat (count month-calendar) '()))))

(defn props
  [month year]
  (let [calendar (calendar-dates month year)]
    (map
     (fn
       [date day first second third fourth last teenth]
       (vector date (concat
                       day
                       first
                       second
                       third
                       fourth
                       last
                       teenth)))
     calendar
     (map list (calendar-days month year))
     (firsts calendar)
     (seconds calendar)
     (thirds calendar)
     (fourths calendar)
     (lasts calendar)
     (teenths calendar)
     )))



(defn meetup
  [month year day-name which-day]
  [year
   month
   (first (first (filter
                  (fn
                    [[date [day & props]]]
                    (and
                     (= day day-name)
                     (some #(= % which-day) props)))
                  (props month year))))])




