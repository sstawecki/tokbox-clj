(ns tokbox-clj.config
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[tokbox-clj started successfully]=-"))
   :middleware identity})
