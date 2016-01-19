(ns tokbox-clj.app
  (:require [tokbox-clj.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
