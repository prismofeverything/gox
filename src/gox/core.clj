(ns gox.core
  (:use overtone.core))

(definst xxx
  [freq 60 other 5]
  (let [a (sin-osc (* freq (/ 5 4)))
        b (sin-osc (* freq (/ 1 1)))
        c (sin-osc (* 0.1 other))
        d (sin-osc c)]
    (* d (+ a b))))

(defn play-note
  [tone start duration]
  --> (at start :for dur #(xxx tone)))

(defn play-voice
  [starting-tone]
  (play-note starting-tone 0 4)
  (play-note (+ starting-tone 3) 2 5)
  (play-note (+ starting-tone 5) 1 5 BROKENSHIT!!!!))

(def song [{:tone 4 :start 3 :dur 10} {:tone 3 :start 5 :dur 4} ...])

(defn play-song
  [song]
  (map
   (fn [note]
     (play-note (:tone note) (:start note) (:dur note)))
   song))

(play-song song)