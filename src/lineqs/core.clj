(ns lineqs.core (:gen-class))

(require '[lineqs.matrix :as m] '[lineqs.io :as io])

(defn clear-column-down
  "Zeroes column [col] from the row [col+1] to the last."
  [matrix col]
  (loop [mat (m/multiply-row matrix col (m/inverse (m/get-value matrix col col)))
         r (inc col)]
    (if (> r (count matrix))
      mat
      (recur (m/sum-rows mat col r (- (m/get-value mat r col))) (inc r)))))

(defn clear-column-up
  "Zeroes column [col] from the row [col-1] to the first."
  [matrix col]
  (loop [mat (m/multiply-row matrix col (m/inverse (m/get-value matrix col col)))
         r (dec col)]
    (if (< r 1)
      mat
      (recur (m/sum-rows mat col r (- (m/get-value mat r col))) (dec r)))))

(defn gauss-method
  "Set the diagonal to 1 and both triangles to 0"
  [matrix]
  (loop [mat matrix
         col 1]
    (if (> col (count matrix))
      mat
      (let [down (clear-column-down mat col)
            up (clear-column-up down col)]
        (recur up (inc col))))))

(defn print-roots
  "Print roots found by the Gaussian method."
  [matrix]
  (print "Roots = {")
  (dotimes [r (count matrix)]
    (if (< r (dec (count matrix)))
      (print (str (m/get-value matrix (inc r) (inc (count matrix))) ", "))
      (print (str (m/get-value matrix (inc r) (inc (count matrix))) "}")))))

(def test-mat [[2 -3 2, 2]
               [-1 -4 -3, -18]
               [3 5 -1, 10]]) ; Solution: x = 1, y = 2, z = 3


(defn -main
  "I don't do a whole lot."
  [& args]
  (let [filename (first args)
        matrix (io/read-matrix filename)]
    (if (m/lineqs? matrix)
      (io/print-roots (gauss-method matrix))
      (println "Error! This file is not in a format I can understand. :'("))))
