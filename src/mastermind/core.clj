(ns mastermind.core)

(def secret
  [(rand-int 10) (rand-int 10) (rand-int 10) (rand-int 10)])

(defn guess
  [guess-numbers]
  (let [answers {:right-place-and-number
                 (->> (interleave guess-numbers secret)
                      (partition 2 )
                      (filter #(= (first %) (second %)) )
                      (count))
                 :right-number (-> (filter #(.contains secret %) guess-numbers)
                                   (count))}]
    {:right-place-and-number (:right-place-and-number answers)
     :right-number (- (:right-number answers) (:right-place answers))}))

;; (guess [9 1 4 6])
